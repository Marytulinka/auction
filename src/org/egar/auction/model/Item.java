package org.egar.auction.model;
/**
 * Характеристики товара: наименование, цена, категория, код
 */
public class Item {

    private String name;
    private Category category;
    private float price;
    private int code;

    public Item(String name, Category category, float price, int code){
        this.name=name;
        this.category=category;
        this.price=price;
        this.code=code;
    }

    public String getName(){
        return name;
    }

    public Category getCategory(){
        return category;
    }

    public float getPrice(){
        return price;
    }

    public int getCode(){
        return code;
    }

    public void setName(){
        this.name=name;
    }

    public void setCategory(){
        this.category=category;
    }

    public void setPrice(){
        this.price=price;
    }

    public void setCode(){
        this.code=code;
    }
}

