package org.egar.auction.model;
/**
 * Характеристики пользователя: логин,  пароль, имя, роль
 */
public class User {

    private String login;
    private String password;
    private String userName;
    private Role role;
    //private String[] myPurchases;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public Role getRole(){
        return role;
    }


    public User(String login,String password,String userName,Role role){
        this.login=login;
        this.password=password;
        this.userName=userName;
        this.role=role;
    }
}

