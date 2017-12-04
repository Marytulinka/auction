package org.egar.auction.storage;

import org.egar.auction.model.Bid;
import org.egar.auction.model.Category;
import org.egar.auction.model.Item;

import java.util.Scanner;

import static org.egar.auction.storage.UserService.currentUser;


public class ItemService {

    public static void viewItems() {

        for (Category i : Category.values()) {
            System.out.println(i.getDescription() + ":");
            System.out.println();
            for (int j = 0; j < Storage.ITEMS.length; j++) {
                if (i.equals(Storage.ITEMS[j].getCategory())) {
                    System.out.println(Storage.ITEMS[j].getName() + "; код:" + Storage.ITEMS[j].getCode() + "; цена: " + Storage.ITEMS[j].getPrice());
                }
            }
            System.out.println();
        }
    }

    public static void makeBidOfItem(int code) {  //установка своей ставки

        Item itemForAuction = null;
        int j = 0;
        for (int i = 0; i < Storage.ITEMS.length; i++) {
            if (code == (Storage.ITEMS[i].getCode()))
                itemForAuction = Storage.ITEMS[i]; //break;
        }
        System.out.println("лот: " + itemForAuction.getName() + "; начальная цена: " + itemForAuction.getPrice() + "; текущая цена: "
                + (itemForAuction.getPrice() + Storage.summaOfBidForItem(code)));
        boolean comp;
        do {
            System.out.println("Введите вашу ставку (целое число):");
            Scanner sc = new Scanner(System.in);
            int bid = sc.nextInt();
            if () {//проверка, что ставка больше предыдущей

            }
            Storage.arrayOfBid[j] = new Bid(bid, currentUser, code);
            j++;
            System.out.println("лот:" + itemForAuction.getName() + "; ставка от пользователя" + currentUser.getUserName() + " - " + bid +
                    "; текущая цена: " + (itemForAuction.getPrice() + bid));
            System.out.println("Продолжать аукцион? Y/N");
            Scanner sc1 = new Scanner(System.in);
            String cont = sc1.nextLine();
            String yes = "Y";
            comp = yes.equals(cont);
        }
        while (comp);
    }
}

