package org.egar.auction.view;

public class Menu {

    public static void showMainMenu() {

        System.out.print("Выберите роль для работы: \n Гость - 1;\n Пользователь - 2;\n Администратор - 3.\n");
    }


    public static void showUserMenu() {

        System.out.println("Выберите действие: \n Просмотр каталога товаров - 1;\n Участие в аукционе - 2;\n Просмотреть 'Мои покупки' - 3");
        System.out.println();
    }

    public static void showBidMenu(){
        System.out.println("Выберите действие: \n Повысить ставку - 1;\n Просмотреть список ставок по лоту - 2");
    }
}
