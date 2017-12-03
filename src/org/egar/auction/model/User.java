package org.egar.auction.model;
/**
 * Характеристики пользователя: логин,  пароль, имя, роль
 */
public class User {

    public final String login;
    public final String password;
    public final String userName;
    public final Role role;
    public String[] myPurchases;

    public User(String login,String password,String userName,Role role){
        this.login=login;
        this.password=password;
        this.userName=userName;
        this.role=role;
    }
}

