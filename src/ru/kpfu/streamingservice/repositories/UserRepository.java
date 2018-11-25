package ru.kpfu.streamingservice.repositories;

import java.util.*;

public class UserRepository implements IRepository{
    public List<String> userList = new ArrayList<>();
    private static UserRepository instance;

    public static UserRepository getInstance(){
        if (instance == null){
            instance = new UserRepository();
        }
        return instance;
    }

    public UserRepository(){
    }

    public void getAll(){
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
        }
    }

    public int getCount(){
        return userList.size();
    }
}
