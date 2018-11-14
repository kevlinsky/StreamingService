package ru.kpfu.streamingservice;

import ru.kpfu.repositories.*;

import java.util.*;

public class User {
    protected final String firstName;
    protected final String lastName;
    public UserRepository ur1 = new UserRepository();
    protected List<String> userFilms = new ArrayList<>();
    protected List<String> userMusic = new ArrayList<>();

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (ur1.userList.contains(firstName)) {
            System.out.println("This user is already exist");
        } else {
            if (ur1.userList.contains(lastName)){
                System.out.println("This user is already exist");
            } else {
                ur1.userList.add("User{" + "First Name: " + firstName + ", Last Name: " + lastName + "} \n");
            }
        }
    }
    public String toString() {
        return "User{" + "First Name: " + firstName + ", Last Name: " + lastName + "} \n";
    }

    public void BuyFilm (String name, FilmRepository fr1){
        boolean search = fr1.filmListName.contains(name);
        double e = 0.00001;
        if (search == false){
            System.out.println("Can`t find this film");
        } else {
            boolean f = false;
            while (f == false) {
                System.out.println("Please enter the price:");
                Scanner sc = new Scanner(System.in);
                double price = sc.nextDouble();
                int index = fr1.filmListName.indexOf(name);
                if (price - fr1.filmListCost.get(index) < e) {
                    userFilms.add("Name: " + fr1.filmListName.get(index) + "Genre: " + fr1.filmListGenre.get(index) + "Duration: " + fr1.filmListDuration.get(index) + "Cost: " + fr1.filmListCost.get(index));
                    System.out.println("Congratulations! Film was addded to your library");
                    f = true;
                } else {
                    System.out.println("Incorrect price");
                    f = false;
                }
            }
        }
    }

    public void GetUsersFilms(){
        for (int i = 0; i < userFilms.size(); i++) {
            System.out.println(userFilms.get(i));
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRepository getUr1() {
        return ur1;
    }
}
