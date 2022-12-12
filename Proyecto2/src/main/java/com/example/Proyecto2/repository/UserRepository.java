package com.example.Proyecto2.repository;

import com.example.Proyecto2.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.Proyecto2.utils.Utils.cargar;

@Repository
public class UserRepository implements IUserRepository{
    final private List<User> usuarios = cargar();

    @Override
    public List<User> findAllUsers() { return usuarios; }

    @Override
    public void saveUser(User user) {
        usuarios.add(user);
    }

    @Override
    public Optional<User> findUserByName(String name) {
        return usuarios.stream().filter(
                user -> user.getNombre().equals(name)
        ).findFirst();
    }
}
