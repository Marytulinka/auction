package org.egar.auction.model;

/**
 * Ставка
 */
public class Bid {
    public int value; //размер ставки
    public User user; //пользователь,установивший ставку
    public int code; //код товара


    public Bid(int value, User user, int code) {
        this.value = value;
        this.user = user;
        this.code = code;
    }

}
