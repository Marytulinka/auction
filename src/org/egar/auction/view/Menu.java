package org.egar.auction.view;

public class Menu {

    public static void showMainMenu() {

        System.out.print("Выберите действие:\nПросмотр каталога лотов по категориям - 1;\n" +
                "Войти как администратор для просмотра статистики - 2;\nВойти для участия в аукционе - 3;Выйти из программы - 4.\n");
    }

    /*public static void showItemMenu() {

        System.out.println("Для возврата в меню введите - 1;\n");
        System.out.println();
    }*/

    public static void searchSortingAndShowBids() {

        System.out.println("Для сортировки по наименованию введите - 1;\nДля поиска лота в каталоге - 2;\nПросмотр списка ставок по лоту - 3;\n" +
                "Просмотреть каталог еще раз - 4;\nВозврат в главное меню - 5.");
        System.out.println();
    }


    public static void showUserMenu() {

        System.out.println("Выберите действие: \n Участие в аукционе - 1;\n Просмотр лотов и ставок пользователя - 2;\n Просмотра корзины пользователя - 3;\n " +
                "Расчеты - 4.\n");
        System.out.println();
    }

    public static void showBidMenu(){
        System.out.println("Выберите действие: \n Повысить ставку - 1;\n Просмотреть список ставок по лоту - 2");
    }
}
