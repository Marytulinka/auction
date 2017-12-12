package org.egar.auction.model;

public class Purchase {

    private Item item;
    private User user; //покупатель

    public Purchase(Item item, User user){
        this.item=item;
        this.user=user;

    }

    public Item getItem (){
        return item;
    }

    public User getUser(){
        return user;
    }
}