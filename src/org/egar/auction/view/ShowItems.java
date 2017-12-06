package org.egar.auction.view;

import org.egar.auction.model.Bid;
import org.egar.auction.model.Category;
import org.egar.auction.model.Item;
import org.egar.auction.storage.Storage;

public class ShowItems {

    public static void viewItems() { //каталог товаров по категориям

        System.out.println("Каталог товаров: \n");
        for (Category i : Category.values()) {
            System.out.println(i.getDescription() + ":");
            System.out.println();
            for (Item item : Storage.items) {
                if (i.equals(item.getCategory())) {
                    System.out.println(item.getName() + "; код:" + item.getCode() + "; цена: "
                            + item.getPrice());
                }
            }
            System.out.println();
        }
    }

    public static void viewBidOfItem(int code){

        Item itemForAuction = null;
        for (Item item : Storage.items) {
            if (code == (item.getCode())) itemForAuction = item;
        }

        if(Storage.bids.isEmpty()) System.out.println("Пока нет ставок");
        else {
            for (Bid bid : Storage.bids) {
                if (code == bid.getCode()) {
                    System.out.println("лот: " + itemForAuction.getName() + " ставки:\n");
                    System.out.println("Пользователь: " + bid.getUser().getUserName() + ", ставка: " + bid.getValue());
                }
            }
        }
    }
}
