package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class GameM {
    Cell[][] fieldGame;
    Cell[] roadGame;
    final static int SIZE_GAME = 11;
    final static char HOUSE = 8962;
    ArrayList<Player> players;
    Cell[] Italy;
    //##################################################################################################################################################
    GameM() {

    }

    //##################################################################################################################################################
    void game() {
        //---------------------------------------------------Ініціалізація значень і запуск цикла-------------------------------------------------------
        setField();
        setPlayers();
        int turn = 0;
        int cube1;
        int cube2;
        int playerGoToBank;
        int numberOnRoad =0;
        Scanner scanner=new Scanner(System.in);
        while (players.size() > 1) {
            //--------------------------------------------------Діалог----------------------------------------------------------------------------------
            System.out.print("Натисніть 0, щоб"+players.get(turn).name+"кинув кубики, або ");
            for (int i=0;i<players.size();i++)
                System.out.print((i+1)+"- щоб"+players.get(i).name+"зайшов в банк, ");
            if (scanner.hasNextInt()) {
                playerGoToBank=scanner.nextInt();
                switch (playerGoToBank) {
                    case 0:
                        break;
                    case 1, 2, 3, 4:
                        System.out.println(players.get(playerGoToBank - 1).name + " яку клітинку хочете купити? Введіть її номер на дорозі гри");
                        if (scanner.hasNextInt())
                            numberOnRoad =scanner.nextInt();
                        if (!checkShopping(numberOnRoad,players.get(playerGoToBank)))
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

            move(players.get(turn),cube1 + cube2);

            //--------------------------------------------------Видалення банкротів-------------------------------------------------------------------------------

            //--------------------------------------------------Передача ходу-------------------------------------------------------------------------------
            turn++;
            if (turn > players.size() - 1)
                turn = 0;
        }
        //--------------------------------------------------Після циклу - оголошення переможця----------------------------------------------------------

    }
    //##################################################################################################################################################
    void move(Player player, int cube){
        roadGame[player.positionOnRoad].redrawSymbol(player.symbol,' ');
        for (int i = 0; i < cube; i++) {
            if (player.positionOnRoad!=40){
                player.positionOnRoad++;}
            else {
                player.positionOnRoad=0;
            }
        }
        roadGame[player.positionOnRoad].action(player);
    }
    //##################################################################################################################################################
    boolean checkShopping(int numberOnRoad, Player player) {

        return true;
    }
    //##################################################################################################################################################
    void setPlayers() {

    }

    //##################################################################################################################################################
    void Print() {
        for (int rowCells = 0; rowCells < SIZE_GAME; rowCells++)
            for (int i = 0; i < Cell.SIZE_CELLS; i++) {
                for (int j = 0; j < SIZE_GAME; j++)
                    fieldGame[rowCells][j].print(i);
                System.out.println(CityCell.BLACK_BACKGROUND);
            }
    }

    //##################################################################################################################################################
    public void setField() {
        //---------------------------------------------Заповнення всього поля Cell клітинками-----------------------------------------------------------
        fieldGame = new Cell[SIZE_GAME][SIZE_GAME];
        for (int i = 0; i <= 10; i++)
            for (int j = 0; j <= 10; j++) {

                fieldGame[i][j] = new Cell();
                fieldGame[i][j].cellsMatrix = new char[][]{{' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' '}
                };
            }
        //---------------------------------------------Заповнення CityCell клітинок---------------------------------------------------------------------
        fieldGame[0][1] = new CityCell(2, CityCell.RED_BACKGROUND, 0, 150, 150, 220, null);
        fieldGame[0][1].cellsMatrix = new char[][]{{' ', '2', '2', '0'},
                {' ', ' ', ' ', ' '},
                {'В', 'е', 'н', 'е'},
                {' ', ' ', ' ', ' '}};

        fieldGame[0][3] = new CityCell(2, CityCell.RED_BACKGROUND, 0, 150, 150, 220, null);
        fieldGame[0][3].cellsMatrix = new char[][]{{' ', '2', '2', '0'},
                {' ', ' ', ' ', ' '},
                {'М', 'і', 'л', 'а'},
                {' ', ' ', ' ', ' '}};

        fieldGame[0][4] = new CityCell(2, CityCell.RED_BACKGROUND, 0, 150, 150, 240, null);
        fieldGame[0][4].cellsMatrix = new char[][]{{' ', '2', '4', '0'},
                {' ', ' ', ' ', ' '},
                {'Б', 'а', 'р', 'і'},
                {' ', ' ', ' ', ' '}};

        fieldGame[0][6] = new CityCell(2, CityCell.PURPLE_BACKGROUND, 0, 150, 150, 260, null);
        fieldGame[0][6].cellsMatrix = new char[][]{{' ', '2', '6', '0'},
                {' ', ' ', ' ', ' '},
                {'А', 'м', 'с', 'т'},
                {' ', ' ', ' ', ' '}};

        fieldGame[0][7] = new CityCell(2, CityCell.PURPLE_BACKGROUND, 0, 150, 150, 260, null);
        fieldGame[0][7].cellsMatrix = new char[][]{{' ', '2', '6', '0'},
                {' ', ' ', ' ', ' '},
                {'Г', 'о', 'р', 'н'},
                {' ', ' ', ' ', ' '}};

        fieldGame[0][9] = new CityCell(2, CityCell.PURPLE_BACKGROUND, 0, 150, 150, 280, null);
        fieldGame[0][9].cellsMatrix = new char[][]{{' ', '2', '8', '0'},
                {' ', ' ', ' ', ' '},
                {'Л', 'і', 'с', 'е'},
                {' ', ' ', ' ', ' '}};

        fieldGame[1][10] = new CityCell(3, CityCell.BLUE_BACKGROUND, 0, 200, 200, 300, null);
        fieldGame[1][10].cellsMatrix = new char[][]{{' ', 'К', ' ', ' '},
                {' ', 'р', ' ', '3'},
                {' ', 'і', ' ', '0'},
                {' ', 'с', ' ', '0'}};

        fieldGame[2][10] = new CityCell(3, CityCell.BLUE_BACKGROUND, 0, 200, 200, 300, null);
        fieldGame[2][10].cellsMatrix = new char[][]{{' ', 'Ш', ' ', ' '},
                {' ', 'і', ' ', '3'},
                {' ', 'є', ' ', '0'},
                {' ', 'н', ' ', '0'}};

        fieldGame[4][10] = new CityCell(3, CityCell.BLUE_BACKGROUND, 0, 200, 200, 320, null);
        fieldGame[4][10].cellsMatrix = new char[][]{{' ', 'О', ' ', ' '},
                {' ', 'с', ' ', '3'},
                {' ', 'л', ' ', '2'},
                {' ', 'о', ' ', '0'}};

        fieldGame[7][10] = new CityCell(3, CityCell.CYAN_BACKGROUND, 0, 200, 200, 350, null);
        fieldGame[7][10].cellsMatrix = new char[][]{{' ', 'Л', ' ', ' '},
                {' ', 'ь', ' ', '3'},
                {' ', 'в', ' ', '5'},
                {' ', 'і', ' ', '0'}};

        fieldGame[9][10] = new CityCell(3, CityCell.CYAN_BACKGROUND, 0, 200, 200, 400, null);
        fieldGame[9][10].cellsMatrix = new char[][]{{' ', 'К', ' ', ' '},
                {' ', 'и', ' ', '4'},
                {' ', 'ї', ' ', '0'},
                {' ', 'в', ' ', '0'}};

        fieldGame[1][0] = new CityCell(1, CityCell.GREEN_BACKGROUND, 0, 100, 100, 200, null);
        fieldGame[1][0].cellsMatrix = new char[][]{{' ', ' ', 'П', ' '},
                {'2', ' ', 'р', ' '},
                {'0', ' ', 'а', ' '},
                {'0', ' ', 'г', ' '}};

        fieldGame[2][0] = new CityCell(1, CityCell.GREEN_BACKGROUND, 0, 100, 100, 180, null);
        fieldGame[2][0].cellsMatrix = new char[][]{{' ', ' ', 'З', ' '},
                {'1', ' ', 'л', ' '},
                {'8', ' ', 'і', ' '},
                {'0', ' ', 'н', ' '}};


        fieldGame[4][0] = new CityCell(1, CityCell.GREEN_BACKGROUND, 0, 100, 100, 180, null);
        fieldGame[4][0].cellsMatrix = new char[][]{{' ', ' ', 'Б', ' '},
                {'1', ' ', 'р', ' '},
                {'8', ' ', 'н', ' '},
                {'0', ' ', 'о', ' '}};


        fieldGame[6][0] = new CityCell(1, CityCell.GREEN_BACKGROUND, 0, 100, 100, 160, null);
        fieldGame[6][0].cellsMatrix = new char[][]{{' ', ' ', 'К', ' '},
                {'1', ' ', 'а', ' '},
                {'6', ' ', 'т', ' '},
                {'0', ' ', 'о', ' '}};

        fieldGame[7][0] = new CityCell(1, CityCell.GREEN_BACKGROUND, 0, 100, 100, 140, null);
        fieldGame[7][0].cellsMatrix = new char[][]{{' ', ' ', 'О', ' '},
                {'1', ' ', 'п', ' '},
                {'4', ' ', 'о', ' '},
                {'0', ' ', 'л', ' '}};


        fieldGame[9][0] = new CityCell(1, CityCell.GREEN_BACKGROUND, 0, 100, 100, 140, null);
        fieldGame[9][0].cellsMatrix = new char[][]{{' ', ' ', 'В', ' '},
                {'1', ' ', 'р', ' '},
                {'4', ' ', 'о', ' '},
                {'0', ' ', 'ц', ' '}};

        fieldGame[10][1] = new CityCell(0, CityCell.YELLOW_BACKGROUND, 0, 50, 50, 120, null);
        fieldGame[10][1].cellsMatrix = new char[][]{{' ', ' ', ' ', ' '},
                {'Н', 'а', 'н', 'т'},
                {' ', ' ', ' ', ' '},
                {' ', '1', '2', '0'}};

        fieldGame[10][2] = new CityCell(0, CityCell.YELLOW_BACKGROUND, 0, 50, 50, 100, null);
        fieldGame[10][2].cellsMatrix = new char[][]{{' ', ' ', ' ', ' '},
                {'П', 'а', 'р', 'ж'},
                {' ', ' ', ' ', ' '},
                {' ', '1', '0', '0'}};

        fieldGame[10][4] = new CityCell(0, CityCell.YELLOW_BACKGROUND, 0, 50, 50, 100, null);
        fieldGame[10][4].cellsMatrix = new char[][]{{' ', ' ', ' ', ' '},
                {'Л', 'і', 'о', 'н'},
                {' ', ' ', ' ', ' '},
                {' ', '1', '0', '0'}};

        fieldGame[10][7] = new CityCell(0, CityCell.YELLOW_BACKGROUND, 0, 50, 50, 60, null);
        fieldGame[10][7].cellsMatrix = new char[][]{{' ', ' ', ' ', ' '},
                {'М', 'а', 'н', 'ч'},
                {' ', ' ', ' ', ' '},
                {' ', ' ', '6', '0'}};

        fieldGame[10][9] = new CityCell(0, CityCell.YELLOW_BACKGROUND, 0, 50, 50, 60, null);
        fieldGame[10][9].cellsMatrix = new char[][]{{' ', ' ', ' ', ' '},
                {'Л', 'о', 'н', 'д'},
                {' ', ' ', ' ', ' '},
                {' ', ' ', '6', '0'}};
        //---------------------------------------------Заповнення країн містами---------------------------------------------------------------------
        Italy=new CityCell[3];
        Italy[0]= fieldGame[0][1];
        //---------------------------------------------Заповнення roadGame---------------------------------------------------------------------
    }
}

