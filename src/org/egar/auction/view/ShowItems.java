package org.egar.auction.view;

import org.egar.auction.Eceptions.EmptyCollectionOfItemException;
import org.egar.auction.Eceptions.ItemOutOfCollection;
import org.egar.auction.model.Bid;
import org.egar.auction.model.Category;
import org.egar.auction.model.Item;
import org.egar.auction.storage.Storage;


public class ShowItems {

    public static boolean viewItems() { //каталог товаров по категориям

        boolean isExc = false;
        try {
            if (Storage.items.isEmpty()) throw new EmptyCollectionOfItemException();
            System.out.println("Каталог товаров: \n");
            for (Category i : Category.values()) {
                System.out.println(i.getDescription() + ":");
                System.out.println();
                for (Item item : Storage.items) {
                    if (!item.isSolded()) { //показываем только непроданный товар
                        if (i.equals(item.getCategory())) {
                            System.out.println(item.getName() + "; код:" + item.getCode() + "; цена: "
                                    + item.getPrice());
                        }
                        else {System.out.println("Нет товаров этой категории");}
                    }
                }
                System.out.println();
            }
        } catch (EmptyCollectionOfItemException exc) {
            System.out.println("Аукцион закрыт. Нет данных просмотра.");
            isExc=true;
        }
        return isExc;
    }

    public static void searhFromItemList(String name) {

        if (Storage.items.isEmpty()) System.out.println("Аукцион закрыт. Нет данных просмотра.");
        boolean retval = Storage.items.contains(name);
        if (retval) {
            for (Item item : Storage.items) {
                if (name.equalsIgnoreCase(item.getName())) {
                    if (!item.isSolded()) {
                        System.out.println("Наименование товара: " + item.getName()
                                + "; категория товара: " + item.getCategory().getDescription()
                                + "; код:" + item.getCode()
                                + "; цена: " + item.getPrice() + "; есть в наличии: да");
                    } else {
                        System.out.println("Наименование товара: " + item.getName()
                                + "; категория товара: " + item.getCategory().getDescription()
                                + "; код:" + item.getCode() + "; цена: "
                                + item.getPrice() + "; есть в наличии: нет");
                    }
                }
            }
        } else {
            System.out.println("Exception: Такого товара нет");
        }
    }

    public static void viewBidOfItem(int code) {

        try{
        Item itemForAuction = null;
        for (Item item : Storage.items) {
            if (code == (item.getCode())) itemForAuction = item;
        }
        if(itemForAuction==null) throw new ItemOutOfCollection();
        if (itemForAuction.isSolded())
            System.out.println("Лот:" + itemForAuction.getName() + " (код:" + itemForAuction.getCode() + ") - продан");
        else {
            if (Storage.bids.isEmpty())
                System.out.println("Лот:" + itemForAuction.getName() + " (код:" + itemForAuction.getCode() + ") - пока нет ставок");
            else {
                for (Bid bid : Storage.bids) {
                    if (code == bid.getCode()) {
                        System.out.println("Лот: " + itemForAuction.getName() + " (код:" + itemForAuction.getCode() + ") ставки:\n");
                        System.out.println("Пользователь: " + bid.getUser().getUserName() + ", ставка: " + bid.getValue());
                    }
                }
            }
        }
    }
    catch(ItemOutOfCollection exc){
        System.out.println("Exception: Нет такого товара");}
    }
}
