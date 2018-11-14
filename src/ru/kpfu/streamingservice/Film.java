package ru.kpfu.streamingservice;

import ru.kpfu.repositories.FilmRepository;

import java.util.*;
public class Film extends Multimedia {

    protected FilmRepository fr1 = new FilmRepository();

    public Film(String name, String genre, int duration, double cost) {
        super(name, genre, duration, cost);
        fr1.filmListName.add(name);
        fr1.filmListGenre.add(genre);
        fr1.filmListDuration.add(duration);
        fr1.filmListCost.add(cost);
    }

    public String toString() {
        return "Film{" + "Name: " + name + ", Genre: " + genre + ", Duration: " + duration + "} \n";
    }
}
