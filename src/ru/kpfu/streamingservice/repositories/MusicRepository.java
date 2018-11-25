package ru.kpfu.streamingservice.repositories;

import java.util.*;

public class MusicRepository implements IRepository {
    public List<String> musicListName = new ArrayList<>();
    public List<String> musicListGenre = new ArrayList<>();
    public List<Integer> musicListDuration = new ArrayList<>();
    public List<Double> musicListCost = new ArrayList<>();
    private static MusicRepository instance;

    public static MusicRepository getInstance(){
        if (instance == null){
            instance = new MusicRepository();
        }
        return instance;
    }

    public MusicRepository(){

    }

    public void getAll (){
        for (int i = 0; i < musicListName.size(); i++) {
            System.out.print("Name: " + musicListName.get(i) + " ");
            System.out.print("Genre:" + musicListGenre.get(i) + "");
            System.out.print("Duration: " + musicListDuration.get(i) + " ");
            System.out.print("Cost: " + musicListCost.get(i));
            System.out.println();
        }
    }

    public int getCount() {
        return musicListName.size();
    }
}
