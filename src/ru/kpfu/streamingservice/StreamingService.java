package ru.kpfu.streamingservice;

import org.omg.CORBA.UserException;
import ru.kpfu.streamingservice.commands.*;
import ru.kpfu.streamingservice.exceptions.*;

import java.io.IOException;
import java.util.*;

public class StreamingService {
    public Command[] commands = new Command[]{new BuyFilmCommand(), new BuySongCommand()};
    public String[] commandsName = new String[] {"buy film", "buy song"};
    public static void main (String[] args){
        StreamingService ss = new StreamingService();
        Scanner sc = new Scanner(System.in);
        User u1 = new User("Artem", "Elin");
        User u2 = new User("Roman","Syunyakov");
        User u3 = new User("Kirill", "Korolev");
        User u4 = new User("Artem", "Elin");
        int usercount = u1.getUserRepository().getCount();
        System.out.println(usercount);
        Music m1 = new Music("Thunder", "R&B", 120, 230);
        Film f1 = new Film("Ragnarok","Action", 120, 2.50);
        System.out.println(u1.userFilms.toString());
        try {
            System.out.println("Enter the command:");
            String command = sc.nextLine();
            ss.userCommand(command, u1);
        } catch (CommandException ex) {
            System.out.println("Unknown command");
            System.exit(1);
        }
    }

    public void userCommand(String command, User u1) throws CommandException{
        try {
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < commands.length; i++) {
                if (command.equals(commandsName[i])){
                    System.out.println("Enter the content name");
                    String name = sc.nextLine();
                    commands[i].execute(name, u1);
                    break;
                }
            }
        } catch (Exception ex) {
            throw new CommandException();
        }
    }
}
