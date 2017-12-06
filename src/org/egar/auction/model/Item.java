package org.egar.auction.model;

/**
 * Характеристики товара: наименование, цена, категория, код
 */
public class Item {

    private String name;
    private Category category;
    private float price;
    private int code;
    private boolean solded;

    public Item(String name, Category category, float price, int code, boolean solded) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.code = code;
        this.solded = solded;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }

    public int getCode() {
        return code;
    }

    public boolean isSolded() {
        return solded;
    }
}

