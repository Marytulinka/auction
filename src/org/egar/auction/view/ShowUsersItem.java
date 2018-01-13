package org.egar.auction.view;

import org.egar.auction.Eceptions.AnswerOutOfRange;
import org.egar.auction.model.Bid;
import org.egar.auction.model.Item;
import org.egar.auction.model.Purchase;
import org.egar.auction.model.User;
import org.egar.auction.storage.Storage;

import java.util.Scanner;

public class ShowUsersItem {

    public static void showUserBids(User user) {

        System.out.println("Ваши лоты и ставки");
        for (Bid bid : Storage.bids) {
            if (user.equals(bid.getUser())) {
                for (Item item : Storage.items) {
                    if (bid.getCode() == item.getCode()) {
                        System.out.println("Лот:" + item.getName() + ", Ваша ставка:" + bid.getValue() + "Продан: " + item.isSolded());
                    }
                }
            }
        }
    }

    /**
     * * Корзина пользователя
     */
    public static boolean showUserBin(User user) {

        boolean noToCount = true;
        float summaOfUser = 0;
        System.out.println("Ваши товары");
        for (Purchase purchase : Storage.purchase) {
            if (user.equals(purchase.getUser())) {
                System.out.println("Лот: " + purchase.getItem().getName() + ", Доставлен: " + purchase.isDelivered());
            }
        }

        try {
            System.out.println("Рассчитать общую сумму? Y/N");
            Scanner wtd = new Scanner(System.in);
            String whatToDo = wtd.nextLine();
            if (whatToDo.equalsIgnoreCase("Y")) {
                for (Purchase purchase : Storage.purchase) {
                    if (user.equals(purchase.getUser())) {
                        summaOfUser += (purchase.getItem().getPrice() + purchase.getItem().getPriceForDelivery());
                    }
                }
                System.out.println("Общая сумма товаров (с учетом цены доставки) = " + summaOfUser);
            }
            //if (whatToDo.equalsIgnoreCase("N")) {
//
            //}
            else throw new AnswerOutOfRange();
        } catch (AnswerOutOfRange exp) {
            System.out.println("Введено некорректное значение");
            noToCount = false;
        }
        return noToCount;
    }
}
