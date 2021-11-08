package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class GameM {
    //---------------------------------------------------Костанти-------------------------------------------------------
    // темніші рядків
    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";
    // світліші рядків
    public static final String GRAY_BACKGROUND = "\u001B[100m";
    public static final String BRIGHT_RED_BACKGROUND = "\u001B[101m";
    public static final String BRIGHT_GREEN_BACKGROUND = "\u001B[102m";
    public static final String BRIGHT_YELLOW_BACKGROUND = "\u001B[103m";
    public static final String BRIGHT_BLUE_BACKGROUND = "\u001B[104m";
    public static final String BRIGHT_PURPLE_BACKGROUND = "\u001B[105m";
    public static final String BRIGHT_CYAN_BACKGROUND = "\u001B[106m";
    public static final String BRIGHT_WHITE_BACKGROUND = "\u001B[107m";
    // символів
    final static String HOUSE = Character.toString(0x2302); // домик

    //---------------------------------------------------Поля-------------------------------------------------------
    final static int SIZE_GAME = 11;
    Cell[][] fieldGame;
    Cell[] roadGame;
    int numberOfHouses;
    ArrayList<Player> players;
    Cell[] Italy;
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
        Italy = null;
    }

    //##################################################################################################################################################
    void game() {
        //---------------------------------------------------Ініціалізація значень і запуск цикла-------------------------------------------------------
        setField();
        setPlayers();
        int turn = 0;
        int cube1;
        int cube2;
        int selectedNumber;
        int numberOnRoad = 0;
        Scanner scanner = new Scanner(System.in);
        while (players.size() > 1) {
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
                        if (checkAndShopping(numberOnRoad, players.get(selectedNumber - 1)))
                            System.out.print("покупка здійснена");
                        else
                            System.out.print("Неможлива покупка");
                        continue;
                    default:
                        System.out.print("Некоректне значення");
                        continue;
                }
            }
            //--------------------------------------------------Хід гравця----------------------------------------------------------------------------------
            cube1 = (int) (Math.random() * 6) + 1;
            cube2 = (int) (Math.random() * 6) + 1;
            move(players.get(turn), cube1 + cube2);
            //--------------------------------------------------Видалення поточного гравця, якщо став банкротом---------------------------------------------
            if (players.remove(turn).money<0)
              System.out.println("Ви стали банкротом"+ players.get(turn).name);
            if(cube1==cube2)
               System.out.println("Киньте кубики ще раз"+players.get(turn).name);
            //--------------------------------------------------Передача ходу-------------------------------------------------------------------------------
            turn++;
            if (turn > players.size() - 1)
                turn = 0;
        }
        //--------------------------------------------------Після циклу - оголошення переможця----------------------------------------------------------

        System.out.println("Вітаємо з перемогою" + players.get(turn).name + "!");
    }

    //##################################################################################################################################################
    void move(Player player, int cube) {
        roadGame[player.positionOnRoad].redrawSymbolPlayer(player.symbol, " ");
        for (int i = 0; i < cube; i++) {
            if (player.positionOnRoad != 40) {
                player.positionOnRoad++;
            } else {
                player.positionOnRoad = 0;
            }
        }
        roadGame[player.positionOnRoad].action(player);
    }

    //##################################################################################################################################################
    boolean checkAndShopping(int numberOnRoad, Player player) {

        return true;
    }

    //##################################################################################################################################################
    void setPlayers() {
        players = new ArrayList<Player>();
        players.add(new Player("Федір", "$"));
        players.add(new Player("Галина", "&"));
    }

    //##################################################################################################################################################
    void printField() {
        for (int rowCells = 0; rowCells < SIZE_GAME; rowCells++)
            for (int i = 0; i < Cell.SIZE_CELLS; i++) {
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
        fieldGame[0][1] = new CityCell("Вене", 2, RED_BACKGROUND, 0, 150, 150, null, fieldGame[1][1], 220, 18, 90, 250, 700, 875, 1050);
        fieldGame[0][3] = new CityCell("Міла", 2, RED_BACKGROUND, 0, 150, 150, null, fieldGame[1][3], 220, 18, 90, 250, 700, 875, 1050);
        fieldGame[0][4] = new CityCell("Барі", 2, GameM.RED_BACKGROUND, 0, 150, 150, null, fieldGame[1][4], 240, 20, 100, 300, 750, 925, 1100);
        fieldGame[0][6] = new CityCell("Амст", 2, GameM.PURPLE_BACKGROUND, 0, 150, 150, null, fieldGame[1][6], 260, 22, 110, 330, 800, 975, 1150);
        fieldGame[0][7] = new CityCell("Горн", 2, GameM.PURPLE_BACKGROUND, 0, 150, 150, null, fieldGame[1][7], 260, 22, 110, 330, 800, 975, 1150);
        fieldGame[0][9] = new CityCell("Лісе", 2, GameM.PURPLE_BACKGROUND, 0, 150, 150, null, fieldGame[1][9], 280, 24, 120, 360, 850, 1025, 1200);
        fieldGame[1][10] = new CityCell("Кріс", 3, GameM.BLUE_BACKGROUND, 0, 200, 200, null, fieldGame[1][9], 300, 26, 130, 390, 900, 1100, 1275);
        fieldGame[2][10] = new CityCell("Шієн", 3, GameM.BLUE_BACKGROUND, 0, 200, 200, null, fieldGame[2][9], 300, 26, 130, 390, 900, 1100, 1275);
        fieldGame[4][10] = new CityCell("Осло", 3, GameM.BLUE_BACKGROUND, 0, 200, 200, null, fieldGame[4][9], 320, 28, 150, 450, 1000, 1200, 1400);
        fieldGame[7][10] = new CityCell("Льві", 3, GameM.GRAY_BACKGROUND, 0, 200, 200, null, fieldGame[7][9], 350, 35, 175, 500, 1100, 1300, 1500);
        fieldGame[9][10] = new CityCell("Київ", 3, GameM.GRAY_BACKGROUND, 0, 200, 200, null, fieldGame[9][9], 400, 50, 200, 600, 1400, 1700, 2000);
        fieldGame[1][0] = new CityCell("Праг", 1, GameM.GREEN_BACKGROUND, 0, 100, 100, null, fieldGame[1][1], 200, 16, 80, 220, 600, 800, 1000);
        fieldGame[2][0] = new CityCell("Злін", 1, GameM.GREEN_BACKGROUND, 0, 100, 100, null, fieldGame[2][1], 180, 14, 70, 200, 550, 750, 950);
        fieldGame[4][0] = new CityCell("Брно", 1, GameM.GREEN_BACKGROUND, 0, 100, 100, null, fieldGame[4][1], 180, 14, 70, 200, 550, 750, 950);
        fieldGame[6][0] = new CityCell("Като", 1, GameM.BRIGHT_RED_BACKGROUND, 0, 100, 100, null, fieldGame[6][1], 160, 12, 60, 180, 500, 700, 900);
        fieldGame[7][0] = new CityCell("Опол", 1, GameM.BRIGHT_RED_BACKGROUND, 0, 100, 100, null, fieldGame[7][1], 140, 10, 50, 150, 450, 625, 750);
        fieldGame[9][0] = new CityCell("Вроц", 1, GameM.BRIGHT_RED_BACKGROUND, 0, 100, 100, null, fieldGame[9][1], 140, 10, 50, 150, 450, 625, 750);
        fieldGame[10][1] = new CityCell("Нант", 0, GameM.YELLOW_BACKGROUND, 0, 50, 50, null, fieldGame[9][1], 120, 8, 40, 100, 300, 450, 600);
        fieldGame[10][2] = new CityCell("Парж", 0, GameM.YELLOW_BACKGROUND, 0, 50, 50, null, fieldGame[9][2], 100, 6, 30, 90, 270, 400, 550);
        fieldGame[10][4] = new CityCell("Ліон", 0, GameM.YELLOW_BACKGROUND, 0, 50, 50, null, fieldGame[9][4], 100, 6, 30, 90, 270, 400, 550);
        fieldGame[10][7] = new CityCell("Манч", 0, GameM.CYAN_BACKGROUND, 0, 50, 50, null, fieldGame[9][7], 60, 4, 20, 60, 180, 320, 450);
        fieldGame[10][9] = new CityCell("Лонд", 0, CYAN_BACKGROUND, 0, 50, 50, null, fieldGame[9][9], 60, 2, 10, 30, 90, 160, 250);
        //---------------------------------------------Заповнення номерів клітинок---------------------------------------------------------------------

        //---------------------------------------------Заповнення клітинок інших ігрових класів---------------------------------------------------------------------

        //---------------------------------------------Заповнення країн містами---------------------------------------------------------------------
        Italy = new CityCell[3];
        Italy[0] = fieldGame[0][1];
        Italy[1] = fieldGame[0][3];
        Italy[2] = fieldGame[0][4];

        Netherlands = new CityCell[3];
        Netherlands[0] = fieldGame[0][6];
        Netherlands[1] = fieldGame[0][7];
        Netherlands[2] = fieldGame[0][9];

        Norway = new CityCell[3];
        Norway[0] = fieldGame[1][10];
        Norway[1] = fieldGame[2][10];
        Norway[2] = fieldGame[4][10];

        Ukraine = new CityCell[2];
        Ukraine[0] = fieldGame[7][10];
        Ukraine[1] = fieldGame[9][10];

        Czech = new CityCell[3];
        Czech[0] = fieldGame[1][0];
        Czech[1] = fieldGame[2][0];
        Czech[2] = fieldGame[4][0];

        Poland = new CityCell[3];
        Poland[0] = fieldGame[6][0];
        Poland[1] = fieldGame[7][0];
        Poland[2] = fieldGame[9][0];

        France = new CityCell[3];
        France[0] = fieldGame[10][1];
        France[1] = fieldGame[10][2];
        France[2] = fieldGame[10][4];

        England = new CityCell[2];
        England[0] = fieldGame[10][7];
        England[1] = fieldGame[10][9];
        //---------------------------------------------Заповнення roadGame---------------------------------------------------------------------
        roadGame = new Cell[40];
        int numbrOnRoad = 0;
        for (int i = 10; i >= 0; i--) {
            roadGame[numbrOnRoad] = fieldGame[10][i];
            numbrOnRoad++;
        }
        int numbrOnRoad1=10;
        for (int j = 10; j >= 0; j--) {
            roadGame[numbrOnRoad1] = fieldGame[j][0];
            numbrOnRoad1++;
        }
        int numbrOnRoad2=20;
        for (int i = 10; i >= 0; i++) {
            roadGame[numbrOnRoad2] = fieldGame[0][i];
            numbrOnRoad2++;
        }
        int numbrOnRoad3=30;
        for (int j = 10; j >= 0; j++){
            roadGame[numbrOnRoad3] = fieldGame[j][10];
            numbrOnRoad3++;
    }
    }
}

