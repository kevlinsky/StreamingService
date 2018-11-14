package ru.kpfu.repositories;

import java.util.*;

public class FilmRepository {
    public List<String> filmListName = new ArrayList<>();
    public List<String> filmListGenre = new ArrayList<>();
    public List<Integer> filmListDuration = new ArrayList<>();
    public List<Double> filmListCost = new ArrayList<>();

    public void GetFilms (){
        for (int i = 0; i < filmListName.size(); i++) {
            System.out.print("Name: " + filmListName.get(i) + " ");
            System.out.print("Genre:" + filmListGenre.get(i) + "");
            System.out.print("Duration: " + filmListDuration.get(i) + " ");
            System.out.print("Cost: " + filmListCost.get(i));
            System.out.println();
        }
    }

    public int GetFilmsCount() {
        return filmListName.size();
    }
}
