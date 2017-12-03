package org.egar.auction;



import org.egar.auction.storage.ItemService;
import org.egar.auction.storage.UserService;

import java.util.Scanner;


public class Main {

    private static void showUserMenu() {

        System.out.println("Выберите действие: \n Просмотр каталога товаров - 1; Участие в акуционе - 2; Просмотреть 'Мои покупки' - 3." );
        System.out.println();

    }

    public static void main(String[] args) {

        System.out.print("Выберите роль для работы: \n Гость - 1;\n Пользователь - 2;\n Администратор - 3.\n");

        Scanner sc = new Scanner(System.in);
        int role = sc.nextInt();

        if (role == 1) { //зашли как гость, смотрим каталог товаров
            System.out.println("Каталог товаров: \n");
            ItemService.viewItems();
        }
        if (role == 2) { //зашли как пользователь
            do { //авторизуемся
                Scanner sc2 = new Scanner(System.in);
                System.out.println();
                System.out.print("Введите логин: ");
                String login = sc2.nextLine();
                System.out.print("Введите пароль: ");
                String password = sc2.nextLine();
                UserService.login(login, password);
            }
            while (UserService.currentUser == null);
            showUserMenu();
            Scanner sc1 = new Scanner(System.in);
            String action = sc1.nextLine();
            switch (action) {
                case "1": //отображение каталога товаров
                    ItemService.viewItems();
                    break;
                case "2":
                    System.out.print("Введите код товара для участия в аукционе: ");
                    Scanner sc3 = new Scanner(System.in);
                    int code = sc3.nextInt();
                    ItemService.makeBidOfItem(code);
            }
        }
    }
}






