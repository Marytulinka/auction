package org.egar.auction.controller;

import org.egar.auction.model.Bid;
import org.egar.auction.model.Purchase;
import org.egar.auction.model.Role;
import org.egar.auction.model.User;
import org.egar.auction.storage.Storage;

public class UserService {

    public static User currentUser;

    public static void login(String login, String password) {

        for (User user : Storage.users) {
            if ((user.getLogin().equals(login)) && (user.getPassword()).equals(password)) {
                System.out.print("Вы вошли как: " + user.getRole().getDescription() + " - " + user.getUserName() + "\n");
                currentUser = user;
            }
        }
        if (currentUser == null) {
            System.out.print("Неверный логин или пароль");
        }
        System.out.print("");
    }
}




