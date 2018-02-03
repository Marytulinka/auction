package org.egar.auction.storage;

import org.egar.auction.model.*;
import org.egar.auction.model.comparators.ItemPriceComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Storage {

    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User("user", "12345", "Иванов Иван", Role.USER));
        users.add(new User("user2", "12345", "Петров Петр", Role.USER));
        users.add(new User("admin", "12345", "Имя Администратора", Role.ADMIN));
    }

    public static List<Item> items = new ArrayList<>();

    static {
        items.add(new Item("Ботинки для горных лыж 1", Category.EQUIPMENT, 20810, 1, true, 600));
        items.add(new Item("Горные лыжи", Category.EQUIPMENT, 37806, 2, true, 600));
        items.add(new Item("Палки для горных лыж", Category.EQUIPMENT, 2710, 3, false, 500));
        items.add(new Item("Варежки", Category.ACCESSORIES, 1750, 4, false, 500));
        items.add(new Item("Балаквала", Category.ACCESSORIES, 2300, 5, false, 500));
        items.add(new Item("Гетры", Category.ACCESSORIES, 2450, 6, false, 500));
        items.add(new Item("Маска", Category.OPTICS, 7600, 7, false, 500));
        items.add(new Item("Растирка", Category.OPTICS, 1950, 8, false, 500));
        items.add(new Item("Адаптер", Category.OPTICS, 1500, 9, false, 500));
        items.add(new Item("Адаптер 2.0", Category.OPTICS, 1550, 10, false, 500));
        items.add(new Item("Адаптер 3.0", Category.OPTICS, 1700, 11, false, 500));
        items.add(new Item("Ботинки для горных лыж 2", Category.EQUIPMENT, 21800, 12, false, 600));
        items.add(new Item("Ботинки для горных лыж 3", Category.EQUIPMENT, 25000, 13, false, 600));
        Collections.sort(items, new ItemPriceComparator());
    }

    public static List<Bid> bids = new ArrayList<>();

    static {
        bids.add(new Bid(29000, users.get(0), 1));
        bids.add(new Bid(28850, users.get(1), 1));
        bids.add(new Bid(28900, users.get(1), 1));
        bids.add(new Bid(37900, users.get(0), 2));
        bids.add(new Bid(38000, users.get(1), 2));
        bids.add(new Bid(3000, users.get(1), 3));


    }

    public static List<Purchase> purchase = new ArrayList<>();

    static {
        purchase.add(new Purchase(items.get(0),users.get(0), true));
        purchase.add(new Purchase(items.get(1),users.get(0), false));
//        purchase.add(new Purchase(items.get(1),users.get(1)));


    }
}
