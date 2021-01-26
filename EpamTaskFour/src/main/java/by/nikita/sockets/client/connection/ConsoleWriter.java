package by.nikita.sockets.client.connection;

public class ConsoleWriter {
    public void printOptionalMenu(){
        System.out.println(
                " 1 - \n 2 - \n 3 - \n 4 - \n 5 - \n 6 - \n 7 - \n 8 - \n 9 - \n 10 - \n 11 - \n 12 - \n 13 - \n 14 - \n 15 - \n 16 - "
        );
    }

    public void printSpecificChoice(String choice){
        switch (choice){
            case "1":
                break;
            default:
                System.out.println("You don't need to do anything");
        }
    }
}
