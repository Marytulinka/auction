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
                if (i.equals(Storage.ITEMS[j].category)) {
                    System.out.println(Storage.ITEMS[j].name + "; код:" + Storage.ITEMS[j].code + "; цена: " + Storage.ITEMS[j].price);
                }
            }
            System.out.println();
        }
    }

    public static void makeBidOfItem(int code) {  //установка своей ставки

        Item itemForAuction = null;
        int j = 0;
        for (int i = 0; i < Storage.ITEMS.length; i++) {
            if (code == (Storage.ITEMS[i].code))
                itemForAuction = Storage.ITEMS[i]; //break;
        }
        System.out.println("лот: " + itemForAuction.name + "; начальная цена: " + itemForAuction.price + "; текущая цена: "
                + (itemForAuction.price + Storage.summaOfBidForItem(code)));
        boolean comp;
        do {
            System.out.println("Введите вашу ставку (целое число):");
            Scanner sc = new Scanner(System.in);
            int bid = sc.nextInt();
            if () {//проверка, что ставка больше предыдущей

            }
            Storage.arrayOfBid[j] = new Bid(bid, currentUser, code);
            j++;
            System.out.println("лот:" + itemForAuction.name + "; ставка от пользователя" + currentUser.userName + " - " + bid +
                    "; текущая цена: " + (itemForAuction.price + bid));
            System.out.println("Продолжать аукцион? Y/N");
            Scanner sc1 = new Scanner(System.in);
            String cont = sc1.nextLine();
            String yes = "Y";
            comp = yes.equals(cont);
        }
        while (comp);
    }
}

