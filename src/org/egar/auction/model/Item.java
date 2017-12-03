package org.egar.auction.model;
/**
 * Характеристики товара: наименование, цена, категория, код
 */
public class Item {

    public String name;
    public Category category;
    public float price;
    public int code;

    public Item(String name, Category category, float price, int code){
        this.name=name;
        this.category=category;
        this.price=price;
        this.code=code;
    }
}

