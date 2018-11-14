package ru.kpfu.repositories;

import java.util.*;

public class UserRepository {
    public List<String> userList = new ArrayList<>();

    public String GetUsers(){
        return userList.toString();
    }

    public int GetUsersCount(){
        return userList.size();
    }
}
