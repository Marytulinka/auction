package org.egar.auction.view;

import org.egar.auction.model.Bid;
import org.egar.auction.model.Purchase;
import org.egar.auction.model.Role;
import org.egar.auction.model.User;
import org.egar.auction.storage.Storage;

public class Statistics {

    public static void statistics() { //[ГОТОВО]

        System.out.println("Статистика по пользователям: \n");
        if (Storage.bids.isEmpty() && Storage.purchase.isEmpty()) {
            System.out.println("Нет данных для просмотра");
        } else System.out.println("Пользователь -- Кол-во его лотов -- Кол-во его ставок");
        int amountOfItems = 0;
        int amountOfBids = 0;
        for (User user : Storage.users) {
            for (Purchase purchase : Storage.purchase) {
                    if (user.getLogin().equals(purchase.getUser().getLogin()))
                        amountOfItems += 1;
                }
                for (Bid bid : Storage.bids) {
                    if (user.getLogin().equals(bid.getUser().getLogin()))
                        amountOfBids += 1;
                }
                System.out.println(user.getUserName() + " ---------- " + amountOfItems + " --------------- " + amountOfBids);
        }
    }
}
