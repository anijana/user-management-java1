package com.example.usermanagement.service;

import com.example.usermanagement.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserService {
    private static List<User> users = new ArrayList<>();
    private static int userCount = 0;

    static {
        users.add(new User(++userCount,"Tanmoy Mndal","tm","Kolkata","8541525258"));
        users.add(new User(++userCount," Amit Kumar","ak","Bangalore","15646511165"));
        users.add(new User(++userCount,"simma adi","adi","Hydrabad","9148541414"));
        users.add(new User(++userCount,"Minoti Jana","mj","Kolkata","81564841514"));
    }

    public List<User> findAll(){
        return users;
    }
    public User findById(int id){
        Predicate<? super User> predicate = user -> user.getUserId() == id;
        User user = users.stream().filter(predicate).findFirst().get();

        return user;
        }
    public void createUser(User user){
        users.add(user);
        }

    public void deleteUser(int id){
        Predicate<? super User> predicate = todo -> todo.getUserId() == id;
        users.removeIf(predicate);
        }
}


