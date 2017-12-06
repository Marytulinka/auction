package org.egar.auction.controller;

import org.egar.auction.model.Bid;
import org.egar.auction.model.Item;
import org.egar.auction.storage.Storage;
import org.egar.auction.view.Menu;
import org.egar.auction.view.ShowItems;

import java.util.Scanner;

public class ItemService {

    public static void makeBidOfItem(int code) {  //установка своей ставки

        Item itemForAuction = null;
        for (Item item : Storage.items) {
            if (code == (item.getCode()))
                itemForAuction = item;
            //break;
        }
        float max = itemForAuction.getPrice();
        for (Bid bid : Storage.bids) {
            if (code == bid.getCode()) {
                if (bid.getValue() > max) max = bid.getValue();
            }
        }
        System.out.println("лот: " + itemForAuction.getName() + "; начальная цена: " + itemForAuction.getPrice() + "; текущая цена: " + max);
        Menu.showBidMenu();
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Введите вашу ставку (целое число):");
                Scanner sc123 = new Scanner(System.in);
                int bid_value = sc123.nextInt();
                for (Bid bid : Storage.bids) {
                    if ((code == bid.getCode()) && (bid_value <= max)) {
                        System.out.println("Ставка должна быть выше предыдущей");

                    }
                }
                Storage.bids.add(new Bid(bid_value, UserService.currentUser, code));
                System.out.println("лот:" + itemForAuction.getName() + "; ставка от пользователя" + UserService.currentUser.getUserName() + " - " + bid_value +
                        "; текущая цена: " + bid_value);
                System.out.println("Продолжать аукцион? Y/N");
            case 2:
                ShowItems.viewBidOfItem(code);
        }
    }
}

