package org.egar.auction.model;

/**
 * Характеристики товара: наименование, цена, категория, код, признак продаже товара
 */
public class Item {

    private String name;
    private Category category;
    private float price;
    private int code;
    private boolean solded;
    private float priceForDelivery;

    public Item(String name, Category category, float price, int code, boolean solded, float priceForDelivery) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.code = code;
        this.solded = solded;
        this.priceForDelivery = priceForDelivery;
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

    public float getPriceForDelivery() {
        return priceForDelivery;
    }
}

