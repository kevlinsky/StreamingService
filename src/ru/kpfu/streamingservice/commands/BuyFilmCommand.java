package ru.kpfu.streamingservice.commands;

import java.util.*;
import ru.kpfu.streamingservice.repositories.*;
import ru.kpfu.streamingservice.*;

public class BuyFilmCommand extends Command{
    public Scanner sc = new Scanner(System.in);
    public Object execute(User u1){
        System.out.println("Enter the name of film");
        String name = sc.nextLine();
        FilmRepository fr1 = FilmRepository.getInstance();
        boolean search = fr1.filmListName.contains(name);
        double e = 0.00001;
        if (search == false){
            System.out.println("Can`t find this film");
        } else {
            boolean f = false;
            while (f == false) {
                System.out.println("Please enter the price:");
                Scanner sc = new Scanner(System.in);
                double price = 0;
                try { //Исключение для некорректного ввода цены, в том числе через точку (InputMismatchException)
                    price = sc.nextDouble();
                } catch (Exception e1) {
                    System.out.println("Wrong enter");
                }
                int index = fr1.filmListName.indexOf(name);
                if (Math.abs(price - fr1.filmListCost.get(index)) < e) {
                    u1.userFilms.add("Name: " + fr1.filmListName.get(index) + " Genre: " + fr1.filmListGenre.get(index) + " Duration: " + fr1.filmListDuration.get(index) + " Cost: " + fr1.filmListCost.get(index));
                    System.out.println("Congratulations! Film was addded to your library");
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
