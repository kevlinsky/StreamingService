package ru.kpfu.streamingservice;

import java.util.*;

public abstract class Multimedia {
    protected String name;
    protected String genre;
    protected int duration;
    protected double cost;

    public Multimedia(String name, String genre, int duration, double cost) {
        this.name = name;
        this.genre = genre;
        this.duration = duration;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Multimedia that = (Multimedia) o;

        if (duration != that.duration) return false;
        if (Double.compare(that.cost, cost) != 0) return false;
        if (!name.equals(that.name)) return false;
        return genre.equals(that.genre);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + genre.hashCode();
        result = 31 * result + duration;
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
