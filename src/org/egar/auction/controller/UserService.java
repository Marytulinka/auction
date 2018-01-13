package org.egar.auction.controller;


import org.egar.auction.model.User;
import org.egar.auction.storage.Storage;
import org.egar.auction.view.Menu;
import org.egar.auction.view.ShowItems;
import org.egar.auction.view.ShowUsersItem;


import java.util.Scanner;

public class UserService {

    public static User currentUser;

    // Авторизация пользователя
    public static void login() {

        Scanner lp = new Scanner(System.in);
        System.out.println("Введите логин: ");
        String login = lp.nextLine();
        System.out.println("Введите пароль: ");
        String password = lp.nextLine();

        for (User user : Storage.users) {
            if ((user.getLogin().equals(login)) && (user.getPassword()).equals(password)) {
                System.out.print("Вы вошли как: " + user.getRole().getDescription() + " - " + user.getUserName() + "\n");
                currentUser = user;
            }
        }
        if (currentUser == null) {
            System.out.println("Такого пользователя не существует либо введен неверный логин или пароль");
        }
    }

    public static void userChoice(int userChoice) {

        switch (userChoice) {
            case 1:
                boolean emptyCatalog = ShowItems.showItems(); //метод возвращает true, если каталог пустой
                while (!emptyCatalog) {
                    boolean rightCode;
                    int chosenItemForAuction;
                    do {
                        chosenItemForAuction = ShowItems.userChooseItem(); //получаем код товара, интересный пользователю
                        rightCode = ShowItems.showBidOfItem(chosenItemForAuction);
                    }
                    while (!rightCode);
                    Menu.showBidMenu();
                    Scanner bm = new Scanner(System.in);
                    int workWithBids = bm.nextInt();
                    switch (workWithBids) {
                        case 1:
                            ItemService.makeBidOfItem(chosenItemForAuction);
                            break;
                    }


                }
                break;
            case 2:
                ShowUsersItem.showUserBids(currentUser);
                break; //Просмотреть ваши лоты и ставки
            case 3:
                ShowUsersItem.showUserBin(currentUser);
                break; //Просмотреть корзину
            case 4:
                break; //Возврат в главное меню
        }

    }
}




