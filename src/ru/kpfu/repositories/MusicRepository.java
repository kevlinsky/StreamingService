package ru.kpfu.repositories;

import java.util.*;

public class MusicRepository {
    public List<String> musicListName = new ArrayList<>();
    public List<String> musicListGenre = new ArrayList<>();
    public List<Integer> musicListDuration = new ArrayList<>();
    public List<Double> musicListCost = new ArrayList<>();

    public void GetMusic (){
        for (int i = 0; i < musicListName.size(); i++) {
            System.out.print("Name: " + musicListName.get(i) + " ");
            System.out.print("Genre:" + musicListGenre.get(i) + "");
            System.out.print("Duration: " + musicListDuration.get(i) + " ");
            System.out.print("Cost: " + musicListCost.get(i));
            System.out.println();
        }
    }

    public int GetMusicCount() {
        return musicListName.size();
    }
}
