package org.egar.auction.controller;

import org.egar.auction.model.User;
import org.egar.auction.storage.Storage;

public class UserService {

    public static User currentUser;

    public static void login(String login, String password) {

        for (int i = 0; i < Storage.USERS.length; i++) {
            if ((Storage.USERS[i].getLogin().equals(login)) && (Storage.USERS[i].getPassword()).equals(password)) {
                System.out.print("Вы вошли как: " + Storage.USERS[i].getRole().getDescription() + " - " + Storage.USERS[i].getUserName()+ "\n");
                currentUser = Storage.USERS[i];
            }
        }
        if (currentUser == null) {
            System.out.print("Неверный логин или пароль");
        }
        System.out.print("");
    }
}



