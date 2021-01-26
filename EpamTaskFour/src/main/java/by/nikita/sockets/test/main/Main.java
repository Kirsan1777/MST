package by.nikita.sockets.test.main;

import by.nikita.sockets.client.entity.Text;
import by.nikita.sockets.client.service.FileService;
import by.nikita.sockets.server.service.ParserService;
import by.nikita.sockets.server.service.TextEditorService;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       String string = "Yt oo yyy wwww q q q. Saas ads. asdas adqrwr.das ds asdad, asdawmrrw. rwars";
        TextEditorService textEditorService = new TextEditorService();
        ParserService parserService = new ParserService();
        //textEditorService.function12(string, 2);
        parserService.testParameter(string);

    }
}
