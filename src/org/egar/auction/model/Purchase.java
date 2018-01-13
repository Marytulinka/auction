package org.egar.auction.model;

/**
 * Характеристики покупок: купленный товар; пользователь,купивший товар; признак доставки товара покупателю
 */
public class Purchase {

    private Item item;
    private User user;
    private boolean delivered;

    public Purchase(Item item, User user, boolean delivered){ //заносим в коллекцию инфо о покупке
        this.item = item;
        this.user = user;
        this.delivered = delivered;

    }

    public boolean isDelivered(){
        return delivered;
    }

    public User getUser(){
        return user;
    }

    public Item getItem () {
        return item;
    }
}
