package org.egar.auction.storage;

import org.egar.auction.model.User;

public class UserService {

    public static User currentUser;

    public static void login(String login, String password) {

        for (int i = 0; i < Storage.USERS.length; i++) {
            if ((Storage.USERS[i].login.equals(login)) && (Storage.USERS[i].password).equals(password)) {
                System.out.print("Вы вошли как: " + Storage.USERS[i].role.getDescription() + " - " + Storage.USERS[i].userName+ "\n");
                currentUser = Storage.USERS[i];
            }
        }
        if (currentUser == null) {
            System.out.print("Неверный логин или пароль");
        }
    }
}



