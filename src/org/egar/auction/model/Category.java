package org.egar.auction.model;
/**
 * Определяем категории товаров
 */
public enum Category {

    EQUIPMENT("Снаряжение"),ACCESSORIES ("Акссесуары"), OPTICS("Оптика");

    String description;

    Category (String description) {
        this.description=description;
    }

    public String getDescription() {return description;}

}
