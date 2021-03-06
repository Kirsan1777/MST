package by.nikita.sockets.client.entity;

import by.nikita.sockets.client.service.FileService;
import by.nikita.sockets.server.entity.SocketServer;
import by.nikita.sockets.test.main.Serializator;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;


public class SocketClient {

    //private static Socket clientSocket;
//сокет для общения

    //private static BufferedReader reader;
// нам нужен ридер читающий с консоли, иначе как
// мы узнаем что хочет сказать клиент?

    //private static BufferedReader in;
// поток чтения из сокета

   // private static BufferedWriter out;
// поток записи в сокет

    private static final Logger log = Logger.getLogger(SocketClient.class);


    public static void main(String[] args) throws IOException {
        Serializator serializator = new Serializator();
        Text text = new Text();
        FileService fileWorker = new FileService();

        String numberOfOperation = "-1";

        Socket clientSocket = new Socket("localhost", 1);// этой строкой мы запрашиваем у сервера доступ на соединение
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));// читать соообщения с сервера
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));// писать туда же

        while(!numberOfOperation.equals("0")) {
            try {

// адрес - локальный хост, порт - 4004, такой же как у сервера
                System.out.println("Что вы хотите сделать с текстом: ");// если соединение произошло и потоки успешно созданы - мы можемработать дальше и предложить клиенту что то ввести

                text.setAllText(fileWorker.readTxtFile());
                serializator.serializableObjectInFile(text);

                numberOfOperation = reader.readLine();// ждём пока клиент что-нибудь не напишет в консоль
                log.info("Client send message");
                out.write(numberOfOperation.concat("\n"));
                out.flush();// отправляем сообщение на сервер

                String serverWord = in.readLine();// ждём, что скажет сервер
                log.info("Client get message");
                System.out.println(serverWord);// получив - выводим на экран
                text = serializator.deserializableObjectOutFile();

            } catch (IOException | ClassNotFoundException e) {
                System.err.println(e);
                log.error("Error in code client");
            }
        }
        clientSocket.close();
        in.close();
        out.close();
    }
}
