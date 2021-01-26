package by.nikita.sockets.test.main;

import by.nikita.sockets.client.entity.Text;

import java.io.*;

public class Serializator {


    public void serializableObjectInFile(Text text) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Java\\Sokets\\src\\main\\resources\\serializableObject");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(text);
        objectOutputStream.close();//new update
    }

    public Text deserializableObjectOutFile() throws IOException, ClassNotFoundException {
        Text text;
        FileInputStream fileInputStream = new FileInputStream("D:\\Java\\Sokets\\src\\main\\resources\\serializableObject");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        text = (Text) objectInputStream.readObject();
        return text;
    }

    public ObjectOutputStream serializableObjectInArrByte(Text text) throws IOException {
        ByteArrayOutputStream bArray = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bArray);
        objectOutputStream.writeObject(text);
        objectOutputStream.close();
        return objectOutputStream;
    }


}
