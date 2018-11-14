package ru.kpfu.streamingservice;

import ru.kpfu.repositories.FilmRepository;
import ru.kpfu.repositories.UserRepository;

public class StreamingService {
    public static void main (String[] args){
        User u1 = new User("Artem", "Elin");
        User u2 = new User("Roman","Syunyakov");
        User u3 = new User("Kirill", "Korolev");
        int usercount = u1.getUr1().GetUsersCount();
        System.out.println(usercount);
        Music m1 = new Music("Thunder", "R&B", 120, 230);
        m1.setCost(225);
        System.out.println(m1.getCost());
        Film f1 = new Film("Ragnarok","Action", 120, 2.50);
        u1.BuyFilm("Ragnarok", new FilmRepository());
    }
}
