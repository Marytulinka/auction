package org.egar.auction.model;

/**
 * Ставка
 */
public class Bid {
    private int value; //размер ставки
    private User user; //пользователь,установивший ставку
    private int code; //код товара

    public int getValue() {
        return value;
    }

    public User getUser() {
        return user;
    }

    public int getCode() {
        return code;
    }

    public Bid(int value, User user, int code) {
        this.value = value;
        this.user = user;
        this.code = code;
    }

}
