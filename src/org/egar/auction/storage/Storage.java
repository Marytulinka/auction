package org.egar.auction.storage;

import org.egar.auction.model.*;

import java.util.ArrayList;
import java.util.List;


public class Storage {

    public static final User[] USERS = new User[3];

    static {
        USERS[0] = new User("user", "12345", "Имя пользователя 1", Role.USER);
        USERS[1] = new User("admin", "12345", "Администратор", Role.ADMIN);
        USERS[2] = new User("", "", "", Role.GUEST);
    }

    public static List<Item> items = new ArrayList<>();

    static {
        items.add(new Item("Ботинки для горных лыж", Category.EQUIPMENT, 20810, 1, false));
        items.add(new Item("Горные лыжи", Category.EQUIPMENT, 37806, 2, false));
        items.add(new Item("Палки для горных лыж", Category.EQUIPMENT, 2710, 3, false));
        items.add(new Item("Варежки", Category.ACCESSORIES, 1750, 4, false));
        items.add(new Item("Балаквала", Category.ACCESSORIES, 2300, 5, false));
        items.add(new Item("Гетры", Category.ACCESSORIES, 2450, 6, false));
        items.add(new Item("Маска", Category.OPTICS, 7600, 7, false));
        items.add(new Item("Растирка", Category.OPTICS, 1950, 8, false));
        items.add(new Item("Адаптер", Category.OPTICS, 1500, 9, false));
    }

    public static List<Bid> bids = new ArrayList<>();

    public static List<Item> purchase = new ArrayList<>();
}
