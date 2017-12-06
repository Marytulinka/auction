package org.egar.auction.model;
/**
 * Роли пользователей
 */

public enum Role {
    ADMIN("администратор"),USER("пользователь"), GUEST("гость");

    String description;

    Role (String description) {
        this.description=description;
    }

    public String getDescription() {return description;}


}