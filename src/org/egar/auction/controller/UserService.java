package org.egar.auction.controller;

import org.egar.auction.model.Bid;
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

    public static void statistics() {

        int amountOfItems = 0;
        int amountOfBids = 0;
        System.out.println("Статистика по пользователям: \n");
        if (Storage.bids.isEmpty()) System.out.println("Нет данных для просмотра");
        for (User user : Storage.users) {
            if(user.getRole() == Role.USER) {
                for (Bid bid : Storage.bids) {
                    if (user.getLogin().equals(bid.getUser().getLogin())) {
                        amountOfItems +=bid. ;
                        amountOfBids += ;
                    }
                }
                System.out.println(user.getUserName() + " " + amountOfItems + " " + amountOfBids);
            }
        }
    }
}




