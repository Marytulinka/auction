package org.egar.auction;


import org.egar.auction.controller.ItemService;
import org.egar.auction.controller.UserService;
import org.egar.auction.view.Menu;
import org.egar.auction.view.ShowItems;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Menu.showMainMenu();
        Scanner sc = new Scanner(System.in);
        int role = sc.nextInt();

        if (role == 1)
        {
            System.out.print("Вам доступен только просмотр каталога товаров");
            ShowItems.viewItems();
        }
        if (role == 2)

        { //зашли как пользователь
            do { //авторизуемся
                Scanner in = new Scanner(System.in);
                System.out.println();
                System.out.print("Введите логин: ");
                String login = in.nextLine();
                System.out.print("Введите пароль: ");
                String password = in.nextLine();
                System.out.print("");
                UserService.login(login, password);
            }
            while (UserService.currentUser == null);
            Scanner sc3 = new Scanner(System.in);
            Menu.showUserMenu();
            String action = sc3.nextLine();
            switch (action) {
                case "1": //отображение каталога товаров
                    ShowItems.viewItems();
                    break;
                case "2":
                    System.out.print("Введите код товара для участия в аукционе: ");
                    Scanner sc4 = new Scanner(System.in);
                    int code = sc4.nextInt();
                    ItemService.makeBidOfItem(code);
            }
        }
    }
}






