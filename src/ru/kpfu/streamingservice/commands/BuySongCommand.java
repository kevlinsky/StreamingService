package ru.kpfu.streamingservice.commands;

import java.io.IOException;
import java.util.*;
import ru.kpfu.streamingservice.repositories.*;
import ru.kpfu.streamingservice.*;

public class BuySongCommand extends Command{
    public Scanner sc = new Scanner(System.in);
    public Object execute(User u1){
        System.out.println("Enter the name of song");
        String name = sc.nextLine();
        MusicRepository mr1 = MusicRepository.getInstance();
        boolean search = mr1.musicListName.contains(name);
        double e = 0.00001;
        if (search == false){
            System.out.println("Can`t find this song");
        } else {
            boolean f = false;
            while (f == false) {
                System.out.println("Please enter the price:");
                Scanner sc = new Scanner(System.in);
                double price = 0;
                try { //Исключение для некорректного ввода цены, в том числе через точку (InputMismatchException)
                    price = sc.nextDouble();
                } catch (Exception ex) {
                    System.out.println("Wrong enter");
                }
                int index = mr1.musicListName.indexOf(name);
                if (Math.abs(price - mr1.musicListCost.get(index)) < e) {
                    u1.userSongs.add("Name: " + mr1.musicListName.get(index) + " Genre: " + mr1.musicListGenre.get(index) + " Duration: " + mr1.musicListDuration.get(index) + " Cost: " + mr1.musicListCost.get(index));
                    System.out.println("Congratulations! Song was addded to your library");
                    f = true;
                } else {
                    System.out.println("Incorrect price");
                    f = false;
                }
            }
        }
        return null;
    }
}
