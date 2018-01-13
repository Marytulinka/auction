package org.egar.auction.view;

public class Menu {

    public static void showMainMenu() {

        System.out.print("Выберите действие:\nПросмотр каталога лотов по категориям - 1;\n" +
                "Просмотр статистики - 2;\nВойти для участия в аукционе - 3;\nВыйти из программы - 4.\n");
    }

    public static void searchSortingAndShowBids() {

        System.out.println("Для сортировки по наименованию введите - 1;\nДля поиска лота в каталоге - 2;\nПросмотр списка ставок по лоту - 3;\n" +
                "Просмотреть каталог еще раз - 4;\nВозврат в главное меню - 5.");
        System.out.println();
    }


    public static void showUserMenu() {

        System.out.println("Выберите действие: \n Просмотреть каталог и выбрать лот для участие в аукционе - 1;\n Просмотреть ваши лоты и ставки - 2;\n Просмотреть корзину - 3;\n " +
                "Возврат в главное меню - 4.");
    }

    public static void showBidMenu(){
        System.out.println("Выберите действие: \n Сделать / повысить ставку - 1;\n Выбрать другой товар - 2;\n Покинуть аукцион - 3");
    }
}
