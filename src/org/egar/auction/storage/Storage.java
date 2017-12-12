package org.egar.auction.storage;

import org.egar.auction.model.*;

import java.util.ArrayList;
import java.util.List;


public class Storage {

    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User("user", "12345", "Иванов Иван", Role.USER));
        users.add(new User("user2", "12345", "Петров Петр", Role.USER));
        users.add(new User("admin", "12345", "Администратор", Role.ADMIN));
        users.add(new User("", "", "", Role.GUEST));
    }

    public static List<Item> items = new ArrayList<>();

    static {
        items.add(new Item("Ботинки для горных лыж", Category.EQUIPMENT, 20810, 1, true));
        items.add(new Item("Горные лыжи", Category.EQUIPMENT, 37806, 2, true));
        items.add(new Item("Палки для горных лыж", Category.EQUIPMENT, 2710, 3, false));
        items.add(new Item("Варежки", Category.ACCESSORIES, 1750, 4, false));
        items.add(new Item("Балаквала", Category.ACCESSORIES, 2300, 5, false));
        items.add(new Item("Гетры", Category.ACCESSORIES, 2450, 6, false));
        items.add(new Item("Маска", Category.OPTICS, 7600, 7, false));
        items.add(new Item("Растирка", Category.OPTICS, 1950, 8, false));
        items.add(new Item("Адаптер", Category.OPTICS, 1500, 9, false));
    }

    public static List<Bid> bids = new ArrayList<>();

    static {
        bids.add(new Bid(29000,users.get(0) , 1));
        bids.add(new Bid(28900,users.get(1) , 1));
        bids.add(new Bid(37900,users.get(0) , 2));
        bids.add(new Bid(38000,users.get(1) , 2));


    }

    public static List<Purchase> purchase = new ArrayList<>();

    static{
        purchase.add(new Purchase(items.get(0),users.get(0)));
        purchase.add(new Purchase(items.get(1),users.get(1)));


    }
}
