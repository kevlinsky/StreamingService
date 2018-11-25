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

    public void buyFilm (String name, FilmRepository fr1){
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
                try { //Исключение для ввода цены через точку (InputMismatchException)
                    price = sc.nextDouble();
                } catch (Exception e1) {
                    System.out.println("Price must be separated by comma");
                }
                int index = fr1.filmListName.indexOf(name);
                if (Math.abs(price - fr1.filmListCost.get(index)) < e) {
                    userFilms.add("Name: " + fr1.filmListName.get(index) + " Genre: " + fr1.filmListGenre.get(index) + " Duration: " + fr1.filmListDuration.get(index) + " Cost: " + fr1.filmListCost.get(index));
                    System.out.println("Congratulations! Film was addded to your library");
                    f = true;
                } else {
                    System.out.println("Incorrect price");
                    f = false;
                }
            }
        }
    }

    public void buySong(String name, MusicRepository mr1){
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
                try { //Исключение для ввода цены через точку (InputMismatchException)
                    price = sc.nextDouble();
                } catch (Exception e1) {
                    System.out.println("Price must be separated by comma");
                }
                int index = mr1.musicListName.indexOf(name);
                if (Math.abs(price - mr1.musicListCost.get(index)) < e) {
                    userSongs.add("Name: " + mr1.musicListName.get(index) + " Genre: " + mr1.musicListGenre.get(index) + " Duration: " + mr1.musicListDuration.get(index) + " Cost: " + mr1.musicListCost.get(index));
                    System.out.println("Congratulations! Song was addded to your library");
                    f = true;
                } else {
                    System.out.println("Incorrect price");
                    f = false;
                }
            }
        }
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
