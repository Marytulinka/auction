package org.egar.auction;

import org.egar.auction.controller.UserService;
import org.egar.auction.model.Role;
import org.egar.auction.view.Menu;
import org.egar.auction.view.ShowItems;
import org.egar.auction.view.Statistics;

import java.util.Scanner;

import static org.egar.auction.controller.UserService.currentUser;


public class Main {

    public static void main(String[] args) {


        Menu.showMainMenu();
        Scanner mc = new Scanner(System.in);
        int mainChoice = mc.nextInt();
        switch (mainChoice) {
            case 1:
                boolean whatToSHow = ShowItems.viewItems();
                if(whatToSHow) break;
                    else{
                Menu.searchSortingAndShowBids();}
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
                        System.out.println("Тут будет условие для возврата в меню гостевого режима");
                    case 5:
                        System.out.println("Тут будет возврат в главное меню");

                }
            case 2:
                boolean authMode = true;
                while (authMode) {
                    Scanner lp = new Scanner(System.in);
                    System.out.println("Введите логин: ");
                    String login = lp.nextLine();
                    System.out.println("Введите пароль: ");
                    String pass = lp.nextLine();
                    UserService.login(login, pass);
                    if (currentUser.getRole() == Role.ADMIN)
                        Statistics.statistics();
                    else System.out.print("Необходимо войти как администратор");
                    System.out.print("Для выхода из профиля введите - 1;\nДля возврата в главное меню - 2.");
                    int des = lp.nextInt();
                    if (des == 1) {
                        currentUser = null;
                        authMode = false;
                    }
                    //if(des==2) {}

                }


        }

    }
}






