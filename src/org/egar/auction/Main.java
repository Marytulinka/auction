package org.egar.auction;


import org.egar.auction.controller.ItemService;
import org.egar.auction.controller.UserService;
import org.egar.auction.view.Menu;
import org.egar.auction.view.ShowItems;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Menu.showMainMenu();
        Scanner mc = new Scanner(System.in);
        int mainChoice = mc.nextInt();
        switch (mainChoice) {
            case 1:
                ShowItems.viewItems();
                Menu.searchSortingAndShowBids();
                Scanner sos = new Scanner(System.in);
                int searchOrSorting = sos.nextInt();
                switch (searchOrSorting) {
                    case 1:
                        System.out.println("Пока не написала");
                    case 2:
                        boolean contSearch = true;
                        while (contSearch) {
                            System.out.println("Введите наименование товара для поиска: ");
                            Scanner sn = new Scanner(System.in);
                            String searchName = sn.nextLine();
                            ShowItems.searhFromItemList(searchName);
                            System.out.println("Завершить поиск? Y/N");
                            String end = sn.nextLine();
                            if (end.equalsIgnoreCase("Y")) contSearch = false;
                            if (end.equalsIgnoreCase("N")) contSearch = true;
                        }
                        break;
                    case 3:
                        boolean contViewOfBids = true;
                        while (contViewOfBids) {
                            System.out.print("Введите код товара для просмотра ставок: ");
                            Scanner boi = new Scanner(System.in);
                            int bidOfItem = boi.nextInt();
                            ShowItems.viewBidOfItem(bidOfItem);
                            System.out.println("Хотите выбрать другой товар? Y/N");
                            String endViewOfBids = boi.nextLine();
                            if (endViewOfBids.equalsIgnoreCase("Y")) contViewOfBids = false;
                            if (endViewOfBids.equalsIgnoreCase("N")) contViewOfBids = true;

                        }
                        break;
                    case 4:
                        ShowItems.viewItems();
                        System.out.print("Тут будет условие для возврата в меню гостевого режима");
                    case 5:
                        System.out.print("Тут будет возврат в главное меню");

                }


        }

    }
}






