package org.egar.auction.view;

import org.egar.auction.Eceptions.EmptyCollectionOfItemException;
import org.egar.auction.Eceptions.ItemOutOfCollection;
import org.egar.auction.model.Bid;
import org.egar.auction.model.Category;
import org.egar.auction.model.Item;
import org.egar.auction.storage.Storage;

import java.util.Scanner;


public class ShowItems {

    /**
     * каталог товаров по категориям [ГОТОВО]
     */
    public static boolean showItems() {

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
                    }
                }
                System.out.println();
            }
        } catch (EmptyCollectionOfItemException exc) {
            System.out.println("Аукцион закрыт. Нет данных просмотра.");
            isExc = true;
        }
        return isExc;
    }

    public static int userChooseItem() {  //выбираем товар для участия в аукционе

        System.out.println("Введите код товара для участия в аукционе");
        Scanner cifa = new Scanner(System.in); // chosen item for auction
        return cifa.nextInt();
    }

    public static void searhFromItemList(String name) { //поиск по каталогу

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
            System.out.println("Такого товара нет");
        }
        System.out.println("Exception: Неверно введено наименование товара. Должно быть существительным. Проверьте правильность написания.");
    }

    /**
     * просмотр ставок по лоту
     */
    public static boolean showBidOfItem(int code) {

        boolean rightCode = true;
        try {
            Item itemForAuction = null;
            for (Item item : Storage.items) {
                if (code == (item.getCode())) {
                    itemForAuction = item;
                }
            }
            if (itemForAuction == null) throw new ItemOutOfCollection();
            if (!Storage.bids.isEmpty()) {
                System.out.println("Лот: " + itemForAuction.getName() + " (код:" + itemForAuction.getCode() + ")\n Ставки:\n");
                boolean haveBid = Storage.bids.contains(code);
                if (haveBid) {
                    for (Bid bid : Storage.bids) {
                        if (code == bid.getCode()) {
                            System.out.println("Пользователь: " + bid.getUser().getUserName() + ", ставка: " + bid.getValue());
                        }
                    }
                } else
                    System.out.println("Лот:" + itemForAuction.getName() + " (код:" + itemForAuction.getCode() + ") - пока нет ставок");
            }
        } catch (ItemOutOfCollection exc) {
            System.out.println("Exception: Нет такого товара");
            System.out.print("");
            rightCode = false;
        }
        return rightCode; //признак наличие товара, код которого ввел пользователь
    }
}

