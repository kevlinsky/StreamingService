package ru.kpfu.streamingservice;

import ru.kpfu.streamingservice.repositories.*;

import java.util.*;

public class User {
    protected final String firstName;
    protected final String lastName;
    UserRepository ur = UserRepository.getInstance();
    public List<String> userFilms = new ArrayList<>();
    public List<String> userSongs = new ArrayList<>();
    //public List<Music> musicWishlist = new ArrayList<>();

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (ur.userList.contains(firstName + " " +lastName)){
            System.out.println("This user is already exist");
        } else {
            ur.userList.add(firstName + " " + lastName);
        }
    }
    public String toString() {
        return "User{" + "First Name: " + firstName + ", Last Name: " + lastName + "} \n";
    }

    public void getUsersFilms(){
        for (int i = 0; i < userFilms.size(); i++) {
            System.out.println(userFilms.get(i));
        }
    }

    public void getUsersSongs(){
        for (int i = 0; i < userSongs.size(); i++) {
            System.out.println(userSongs.get(i));
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRepository getUserRepository() {
        return ur;
    }
}
