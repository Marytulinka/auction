package org.egar.auction.storage;

import org.egar.auction.model.Category;
import org.egar.auction.model.Item;
import org.egar.auction.model.Role;
import org.egar.auction.model.User;
import org.egar.auction.model.Bid;


public class Storage {

    public static final User[] USERS = new User[3];

    static {
        USERS[0] = new User("user", "12345", "Имя пользователя 1", Role.USER);
        USERS[1] = new User("admin", "12345", "Администратор", Role.ADMIN);
        USERS[2] = new User("user2", "12345", "Имя пользователя 2", Role.USER);
    }

    public static final Item[] ITEMS = new Item[9];

    static {
        ITEMS[0] = new Item("Ботинки для горных лыж", Category.EQUIPMENT, 20810, 1);
        ITEMS[1] = new Item("Горные лыжи", Category.EQUIPMENT, 37806, 2);
        ITEMS[2] = new Item("Палки для горных лыж", Category.EQUIPMENT, 2710, 3);
        ITEMS[3] = new Item("Варежки", Category.ACCESSORIES, 1750, 4);
        ITEMS[4] = new Item("Балаквала", Category.ACCESSORIES, 2300, 5);
        ITEMS[5] = new Item("Гетры", Category.ACCESSORIES, 2450, 6);
        ITEMS[6] = new Item("Маска", Category.OPTICS, 7600, 7);
        ITEMS[7] = new Item("Растирка", Category.OPTICS, 1950, 8);
        ITEMS[8] = new Item("Адаптер", Category.OPTICS, 1500, 9);
    }

    //Collection listOfBid = new ArrayList();

    static Bid[] arrayOfBid = new Bid[100];

    public static int summaOfBidForItem (int code){
        int summa=0;
        for(int i=0; i<100; i++){
            if (arrayOfBid[i].getCode()==code)
                summa+=arrayOfBid[i].getValue();
            }
        return summa;
    }
}
