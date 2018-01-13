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
                boolean whatToSHow = ShowItems.showItems();
                if (whatToSHow) break;
                else {
                    Menu.searchSortingAndShowBids();
                }
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
                            ShowItems.showBidOfItem(bidOfItem);
                            System.out.println("Хотите выбрать другой товар? Y/N");
                            String endViewOfBids = boi.nextLine();
                            if (endViewOfBids.equalsIgnoreCase("Y")) contViewOfBids = false;
                            if (endViewOfBids.equalsIgnoreCase("N")) contViewOfBids = true;

                        }
                        break;
                    case 4:
                        ShowItems.showItems();
                        System.out.println("Тут будет условие для возврата в меню гостевого режима");
                    case 5:
                        System.out.println("Тут будет возврат в главное меню");

                }
            case 4:
                break; //выход из программы

            case 2: //Просмотр статистики администратором
                System.out.println("Войдите как администратор");
                boolean needToLoginLikeAdmin = true;
                while (needToLoginLikeAdmin) { //авторизуемся до тех пор, пока пользователь не войдет как админ или не передумает
                    UserService.login();
                    if (currentUser.getRole() == Role.ADMIN) {
                        Statistics.statistics();
                        needToLoginLikeAdmin = false;
                    } else {
                        System.out.println("У данного пользователя нет прав для просмотра статистики");
                        System.out.println("Перезайти - 1;\nВозврат в главное меню - 2.");
                        Scanner lp = new Scanner(System.in);
                        int desicion = lp.nextInt();
                        if (desicion == 1) {
                            currentUser = null;
                            needToLoginLikeAdmin = true;
                        }
                    /*if (desicion == 2)
                    {
                        //возврат в мейнМеню
                    }*/
                        else break;
                    }
                }
                break;
            case 3:
                boolean needToLogin = true;
                while (needToLogin) {
                    UserService.login(); //авторизуемся, пока не будет усеха. надо еще добавить выход в главное меню
                    if (currentUser == null) {
                        System.out.println("Повторите попытку авторизации");
                        needToLogin = true;
                    } else {
                        needToLogin = false;
                    }
                }
                Menu.showUserMenu();
                Scanner uc = new Scanner(System.in);
                int userChoice = uc.nextInt();
                UserService.userChoice(userChoice);


        }
    }

}







