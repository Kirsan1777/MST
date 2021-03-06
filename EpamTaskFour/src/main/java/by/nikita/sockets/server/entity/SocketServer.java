package by.nikita.sockets.server.entity;

import by.nikita.sockets.client.entity.Text;
import by.nikita.sockets.server.service.ParserService;
import by.nikita.sockets.server.service.TextEditorService;
import by.nikita.sockets.test.main.Serializator;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import org.apache.log4j.Logger;

public class SocketServer {

    private static final Logger log = Logger.getLogger(SocketServer.class);
    private static Socket clientSocket;//сокет для общения
    private static ServerSocket server;// серверсокет
    private static BufferedReader in;// поток чтения из сокета
    private static BufferedWriter out;// поток записи в сокет


    public static void main(String[] args) {
        Serializator serializator = new Serializator();
        ParserService parser = new ParserService();
        TextEditorService textEditorService = new TextEditorService();
        Text text;
        String word = "-1";

        try {

            server = new ServerSocket(1);// серверсокет прослушивает порт 4004
            log.info("Сервер запущен!");
            clientSocket = server.accept();// accept() будет ждать пока кто-нибудь не захочет подключиться
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));// теперь мы можем принимать сообщения
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));// и отправлять

                while (!word.equals("0")) {

                    word = in.readLine();// ждём пока клиент что-нибудь нам напишет
                    log.info("Server get message");
                    text = serializator.deserializableObjectOutFile();

                    List<String> list = parser.getAllSentenceOutString(text.getAllText());

                    text.setResult(textEditorService.function6(text.getAllText()));
                    serializator.serializableObjectInFile(text);

                    for(String str : text.getResult()){
                        System.out.println(str);
                    }


                    out.write("Подтверждаю, вы написали : " + word + "\n");// не долго думая отвечает клиенту
                    out.flush();// выталкиваем все из буфера
                    log.info("Server send message");
                }
                // в любом случае сокет будет закрыт
                clientSocket.close();
                log.info("Server closed");
                in.close();
                out.close();
                server.close();
// потоки тоже хорошо бы закрытьfinally {
//
//        }

        }  catch (IOException | ClassNotFoundException e) {
            System.err.println(e);
            log.error("Error in code server");
        }

    }
}