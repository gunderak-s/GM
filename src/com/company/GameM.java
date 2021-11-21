package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GameM implements Serializable, CONSTANTS {

    //---------------------------------------------------Поля-------------------------------------------------------

    Cell[][] fieldGame;
    Cell[] roadGame;
    int turn;
    int numberOfHouses;
    ArrayList<Player> players;
    Cell[] Netherlands;
    Cell[] England;
    Cell[] Poland;
    Cell[] France;
    Cell[] Ukraine;
    Cell[] Norway;
    Cell[] Czech;

    //##################################################################################################################################################
    GameM() {
        fieldGame = null;
        roadGame = null;
        numberOfHouses = 32;
        players = null;
        turn=0;
    }
    //##################################################################################################################################################
    void game(boolean newGame) {
        //---------------------------------------------------Ініціалізація значень і запуск цикла-------------------------------------------------------
        if (newGame){
            setField();
            setPlayers();
        }
        int cube1;
        int cube2;
        int selectedNumber;
        int numberOnRoad = 0;
        Scanner scanner = new Scanner(System.in);
        for (int i=0;i< players.size();i++)
            roadGame[0].redrawSymbolPlayer(" ",players.get(i).symbol);
        while (players.size() > 1) {
            printField();
            //--------------------------------------------------Діалог----------------------------------------------------------------------------------
            System.out.print("Натисніть 0, щоб" + players.get(turn).name + "кинув кубики, або ");
            for (int i = 0; i < players.size(); i++)
                System.out.print((i + 1) + "- щоб" + players.get(i).name + "зайшов в банк, ");
            if (scanner.hasNextInt()) {
                selectedNumber = scanner.nextInt();
                switch (selectedNumber) {
                    case 0:
                        break;
                    case 1, 2, 3, 4:
                        System.out.println(players.get(selectedNumber - 1).name + " яку клітинку хочете купити? Введіть її номер на дорозі гри");
                        if (scanner.hasNextInt())
                            numberOnRoad = scanner.nextInt();
                        roadGame[numberOnRoad].purchase(players.get(selectedNumber),numberOnRoad);
                        continue;
                    default:
                        System.out.print("Некоректне значення");
                        continue;
                }
            }
            //--------------------------------------------------Хід гравця----------------------------------------------------------------------------------
            players.get(turn).throwDice();
            if (roadGame[players.get(turn).positionOnRoad].playerFromCell(players.get(turn))){
                players.get(turn).move(roadGame.length);
                roadGame[players.get(turn).positionOnRoad].playerIntoCell(players.get(turn));
            }
            //--------------------------------------------------Видалення поточного гравця, якщо став банкротом---------------------------------------------
            if (players.get(turn).money < 0) {
                System.out.println("Ви стали банкротом" + players.get(turn).name);
                players.remove(turn);
            }
            if (players.get(turn).identicalCubes())
                System.out.println("Киньте кубики ще раз" + players.get(turn).name);
                //--------------------------------------------------Передача ходу-------------------------------------------------------------------------------
            else {
                turn++;
                if (turn > players.size() - 1)
                    turn = 0;
            }
        }
        //--------------------------------------------------Після циклу - оголошення переможця----------------------------------------------------------

        System.out.println("Вітаємо з перемогою" + players.get(turn).name + "!");
    }

    //##################################################################################################################################################
    void setPlayers() {
        players = new ArrayList<Player>();
        players.add(new Player("Федір", "♇"));
        players.add(new Player("Галина", "&"));
        /*Scanner scanner= new Scanner(System.in);
        String s = null;
        String s1=null;

       do {

            System.out.println("Введіть ім'я та символ гравця, stop - для виходу");
            if (scanner.hasNext())
                s=scanner.next();
            if (scanner.hasNext())
                s1=scanner.next();

            players.add(new Player(s,s1));
        }while (!s.equals("stop"));

        scanner.close();
        */
    }
    //##################################################################################################################################################
    void printField() {
        for (int rowCells = 0; rowCells < SIZE_GAME; rowCells++)
            for (int i = 0; i < SIZE_CELLS; i++) {
                for (int j = 0; j < SIZE_GAME; j++)
                    fieldGame[rowCells][j].printMatrix(i);
                System.out.println(BLACK_BACKGROUND);
            }
    }

    //##################################################################################################################################################
    public void setField() {
        //---------------------------------------------Заповнення всього поля Cell клітинками-----------------------------------------------------------
        fieldGame = new Cell[SIZE_GAME][SIZE_GAME];
        for (int i = 0; i <= 10; i++)
            for (int j = 0; j <= 10; j++)
                fieldGame[i][j] = new Cell();
        //---------------------------------------------Заповнення CityCell клітинок---------------------------------------------------------------------
        CityCell[] Italy = new CityCell[3];
        fieldGame[0][1] = new CityCell("Вн", 2, RED_BACKGROUND, 0, 150, 150, null, fieldGame[1][1],Italy, 220, 18, 90, 250, 700, 875, 1050);
        fieldGame[0][3] = new CityCell("Мл", 2, RED_BACKGROUND, 0, 150, 150, null, fieldGame[1][3],Italy, 220, 18, 90, 250, 700, 875, 1050);
        fieldGame[0][4] = new CityCell("Бр", 2, RED_BACKGROUND, 0, 150, 150, null, fieldGame[1][4],Italy, 240, 20, 100, 300, 750, 925, 1100);
        Italy[0] = (CityCell) fieldGame[0][1];
        Italy[1] = (CityCell)fieldGame[0][3];
        Italy[2] = (CityCell)fieldGame[0][4];

        CityCell[] Netherlands = new CityCell[3];
        fieldGame[0][6] = new CityCell("Ам", 2, PURPLE_BACKGROUND, 0, 150, 150, null, fieldGame[1][6], Netherlands, 260, 22, 110, 330, 800, 975, 1150);
        fieldGame[0][7] = new CityCell("Гр", 2, PURPLE_BACKGROUND, 0, 150, 150, null, fieldGame[1][7], Netherlands,260, 22, 110, 330, 800, 975, 1150);
        fieldGame[0][9] = new CityCell("Лс", 2, PURPLE_BACKGROUND, 0, 150, 150, null, fieldGame[1][9], Netherlands,280, 24, 120, 360, 850, 1025, 1200);
        Netherlands[0] = (CityCell) fieldGame[0][6];
        Netherlands[1] = (CityCell) fieldGame[0][7];
        Netherlands[2] = (CityCell) fieldGame[0][9];

        CityCell[] Norway= new CityCell[3];
        fieldGame[1][10] = new CityCell("Кріс", 3, BLUE_BACKGROUND, 0, 200, 200, null, fieldGame[1][9], Norway,300, 26, 130, 390, 900, 1100, 1275);
        fieldGame[2][10] = new CityCell("Шієн", 3, BLUE_BACKGROUND, 0, 200, 200, null, fieldGame[2][9], Norway,300, 26, 130, 390, 900, 1100, 1275);
        fieldGame[4][10] = new CityCell("Осло", 3, BLUE_BACKGROUND, 0, 200, 200, null, fieldGame[4][9], Norway,320, 28, 150, 450, 1000, 1200, 1400);
        Norway[0] = (CityCell) fieldGame[1][10];
        Norway[1] = (CityCell) fieldGame[2][10];
        Norway[2] = (CityCell) fieldGame[4][10];

        CityCell[] Ukraine = new CityCell[2];
        fieldGame[7][10] = new CityCell("Льві", 3, GRAY_BACKGROUND, 0, 200, 200, null, fieldGame[7][9], Ukraine,350, 35, 175, 500, 1100, 1300, 1500);
        fieldGame[9][10] = new CityCell("Київ", 3, GRAY_BACKGROUND, 0, 200, 200, null, fieldGame[9][9], Ukraine,400, 50, 200, 600, 1400, 1700, 2000);
        Ukraine[0] = (CityCell) fieldGame[7][10];
        Ukraine[1] = (CityCell) fieldGame[9][10];

       CityCell[] Czech = new CityCell[3];
        fieldGame[1][0] = new CityCell("Праг", 1, GREEN_BACKGROUND, 0, 100, 100, null, fieldGame[1][1], Czech,200, 16, 80, 220, 600, 800, 1000);
        fieldGame[2][0] = new CityCell("Злін", 1, GREEN_BACKGROUND, 0, 100, 100, null, fieldGame[2][1], Czech,180, 14, 70, 200, 550, 750, 950);
        fieldGame[4][0] = new CityCell("Брно", 1, GREEN_BACKGROUND, 0, 100, 100, null, fieldGame[4][1], Czech,180, 14, 70, 200, 550, 750, 950);
        Czech[0] = (CityCell) fieldGame[1][0];
        Czech[1] = (CityCell) fieldGame[2][0];
        Czech[2] = (CityCell) fieldGame[4][0];

        CityCell[] Poland = new CityCell[3];
        fieldGame[6][0] = new CityCell("Като", 1, BRIGHT_RED_BACKGROUND, 0, 100, 100, null, fieldGame[6][1], Poland,160, 12, 60, 180, 500, 700, 900);
        fieldGame[7][0] = new CityCell("Опол", 1, BRIGHT_RED_BACKGROUND, 0, 100, 100, null, fieldGame[7][1], Poland,140, 10, 50, 150, 450, 625, 750);
        fieldGame[9][0] = new CityCell("Вроц", 1, BRIGHT_RED_BACKGROUND, 0, 100, 100, null, fieldGame[9][1], Poland,140, 10, 50, 150, 450, 625, 750);
        Poland[0] = (CityCell) fieldGame[6][0];
        Poland[1] = (CityCell) fieldGame[7][0];
        Poland[2] = (CityCell) fieldGame[9][0];

        CityCell[] France = new CityCell[3];
        fieldGame[10][1] = new CityCell("Нант", 0, YELLOW_BACKGROUND, 0, 50, 50, null, fieldGame[9][1], France,120, 8, 40, 100, 300, 450, 600);
        fieldGame[10][2] = new CityCell("Парж", 0, YELLOW_BACKGROUND, 0, 50, 50, null, fieldGame[9][2], France,100, 6, 30, 90, 270, 400, 550);
        fieldGame[10][4] = new CityCell("Ліон", 0, YELLOW_BACKGROUND, 0, 50, 50, null, fieldGame[9][4], France,100, 6, 30, 90, 270, 400, 550);
        France[0] = (CityCell) fieldGame[10][1];
        France[1] = (CityCell) fieldGame[10][2];
        France[2] = (CityCell) fieldGame[10][4];

        CityCell[] England = new CityCell[2];
        fieldGame[10][7] = new CityCell("Манч", 0, CYAN_BACKGROUND, 0, 50, 50, null, fieldGame[9][7], England,60, 4, 20, 60, 180, 320, 450);
        fieldGame[10][9] = new CityCell("Лонд", 0, CYAN_BACKGROUND, 0, 50, 50, null, fieldGame[9][9], England,60, 2, 10, 30, 90, 160, 250);
        England[0] = (CityCell) fieldGame[10][7];
        England[1] = (CityCell) fieldGame[10][9];
        //---------------------------------------------Заповнення порт---------------------------------------------------------------------
        PortCell[] ports = new PortCell[4];
        fieldGame[10][5] = new PortCell(0, 0,fieldGame[9][5],null, ports,200,25,100,200);
        fieldGame[5][0] = new PortCell(1,0, fieldGame[5][1],null, ports, 200,25,50,100,200 );
        fieldGame[0][5] = new PortCell(2,0, fieldGame[1][5],null, ports, 200,25,50,100,200 );
        fieldGame[5][10] = new PortCell(3,0, fieldGame[5][9],null, ports, 200,25,50,100,200 );
        ports[0] = (PortCell) fieldGame[10][5];
        ports[1] = (PortCell) fieldGame[5][0];
        ports[2] = (PortCell) fieldGame[0][5];
        ports[3] = (PortCell) fieldGame[5][10];
        //---------------------------------------------Заповнення компаній---------------------------------------------------------------------
        CompanyCell[] company = new CompanyCell[2];
        fieldGame[8][0]=();
        fieldGame[0][8]=();
        //---------------------------------------------Заповнення клітинок інших ігрових класів---------------------------------------------------------------------
        Chance[] chances = new Chance[13];
        chances[0] = (player) -> {
            roadGame[39].redrawSymbolPlayer(" ", player.symbol);
            player.positionOnRoad = 39;
            roadGame[39].playerIntoCell(player);
        };
        chances[1] = (player) -> {
            roadGame[0].redrawSymbolPlayer(" ", player.symbol);
            player.positionOnRoad = 0;
            roadGame[0].playerIntoCell(player);
        };
        chances[2] = (player) -> player.awayFromPrisonCell++;

        chances[3] = (player) -> {
            if (player.positionOnRoad == 36) player.money = player.money + 200;
            roadGame[25].redrawSymbolPlayer(" ", player.symbol);
            player.positionOnRoad = 25;
            roadGame[25].playerIntoCell(player);
        };
        chances[4] = (player) -> player.money = player.money - 15;
        chances[5] = (player) -> player.money = player.money + 150;



        chances[6] = (player) -> {
            if (player.positionOnRoad != 7) player.money = player.money + 200;
            roadGame[15].redrawSymbolPlayer(" ", player.symbol);
            player.positionOnRoad = 15;
            roadGame[15].playerIntoCell(player);

        };
        chances[7] = (player) -> player.money = player.money + 50;
        chances[8] = (player) -> player.money = player.money - 20;
        chances[9] = (player) -> player.money = player.money - 150;
        chances[10] = (player) -> player.money = player.money + 100;

        chances[11] = (player) -> {
            player.money = player.money + 200;
            roadGame[15].redrawSymbolPlayer(" ", player.symbol);
            player.positionOnRoad = 15;
            roadGame[15].playerIntoCell(player);
        };

        chances[12] = (player) -> {
            player.positionOnRoad = player.positionOnRoad - 3;
            roadGame[player.positionOnRoad].redrawSymbolPlayer(" ", player.symbol);
            roadGame[player.positionOnRoad].playerIntoCell(player);
        };
        ChanceRealisedCell chanceRealisedCell = new ChanceRealisedCell(chances);



        //---------------------------------------------Заповнення країн містами---------------------------------------------------------------------


        //---------------------------------------------Заповнення roadGame і номерів клітинок---------------------------------------------------------------------
        roadGame = new Cell[40];
        int numbrOnRoad = 0;
        for (int i = 10; i >= 0; i--) {
            roadGame[numbrOnRoad] = fieldGame[10][i];
            roadGame[numbrOnRoad].drawTextIntoCell(String.valueOf(numbrOnRoad),3,true);
            numbrOnRoad++;
        }
        for (int j = 9; j >= 0; j--) {
            roadGame[numbrOnRoad] = fieldGame[j][0];
            roadGame[numbrOnRoad].drawTextIntoCell(String.valueOf(numbrOnRoad),3,true);
            numbrOnRoad++;
        }
        for (int i = 10; i >= 1; i--) {
            roadGame[numbrOnRoad] = fieldGame[0][i];
            roadGame[numbrOnRoad].drawTextIntoCell(String.valueOf(numbrOnRoad),3,true);
            numbrOnRoad++;
        }
        for (int j = 9; j >= 1; j--){
            roadGame[numbrOnRoad] = fieldGame[j][10];
            roadGame[numbrOnRoad].drawTextIntoCell(String.valueOf(numbrOnRoad),3,true);
            numbrOnRoad++;
    }
    }
}

