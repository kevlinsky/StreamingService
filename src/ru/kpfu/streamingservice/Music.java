package ru.kpfu.streamingservice;

import ru.kpfu.streamingservice.repositories.*;

public class Music extends Multimedia {

    protected MusicRepository mr1 = MusicRepository.getInstance();

    public Music(String name, String genre, int duration, double cost) {
        super(name, genre, duration, cost);
        mr1.musicListName.add(name);
        mr1.musicListGenre.add(genre);
        mr1.musicListDuration.add(duration);
        mr1.musicListCost.add(cost);
    }

    public String toString() {
        return "Music{" + "Name: " + name + ", Genre: " + genre + ", Duration: " + duration + ", Cost: " + cost + "} \n";
    }
}