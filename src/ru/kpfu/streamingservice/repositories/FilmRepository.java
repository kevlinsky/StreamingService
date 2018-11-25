package ru.kpfu.streamingservice.repositories;

import java.util.*;

public class FilmRepository implements IRepository{
    public List<String> filmListName = new ArrayList<>();
    public List<String> filmListGenre = new ArrayList<>();
    public List<Integer> filmListDuration = new ArrayList<>();
    public List<Double> filmListCost = new ArrayList<>();
    private static FilmRepository instance;

    public static FilmRepository getInstance(){
        if (instance == null) {
            instance = new FilmRepository();
        }
        return instance;
    }

    private FilmRepository(){}

    public void getAll (){
        for (int i = 0; i < filmListName.size(); i++) {
            System.out.print("Name: " + filmListName.get(i) + " ");
            System.out.print("Genre:" + filmListGenre.get(i) + "");
            System.out.print("Duration: " + filmListDuration.get(i) + " ");
            System.out.print("Cost: " + filmListCost.get(i));
            System.out.println();
        }
    }

    public int getCount() {
        return filmListName.size();
    }
}
