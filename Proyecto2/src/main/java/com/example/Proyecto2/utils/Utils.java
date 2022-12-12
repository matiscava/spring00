package com.example.Proyecto2.utils;

import com.example.Proyecto2.entities.User;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<User> cargar(){
        List<User> usuarios = new ArrayList<>();
        usuarios.add(new User("Matias", "Scavarelli", 32));
        usuarios.add(new User("Lionel", "Messi", 35));
        usuarios.add(new User("Carmen", "Electra", 47));
        usuarios.add(new User("Sergio", "Denis", 64));

        return usuarios;
    }
}
