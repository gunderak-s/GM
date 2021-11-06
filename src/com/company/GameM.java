package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class GameM {
    //---------------------------------------------------Костанти-------------------------------------------------------
    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";
    public static final String GRAY_BACKGROUND = "\u001B[100m";
    public static final String BRIGHT_RED_BACKGROUND = "\u001B[101m";
    public static final String BRIGHT_GREEN_BACKGROUND = "\u001B[102m";
    public static final String BRIGHT_YELLOW_BACKGROUND = "\u001B[103m";
    public static final String BRIGHT_BLUE_BACKGROUND = "\u001B[104m";
    public static final String BRIGHT_PURPLE_BACKGROUND = "\u001B[105m";
    public static final String BRIGHT_CYAN_BACKGROUND = "\u001B[106m";
    public static final String BRIGHT_WHITE_BACKGROUND = "\u001B[107m";
    final static char HOUSE = 8962; // домик
    //---------------------------------------------------Поля-------------------------------------------------------
    final static int SIZE_GAME = 11;
    Cell[][] fieldGame;
    Cell[] roadGame;
    int numberOfHouses;
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
        int selectedNumber;
        int numberOnRoad =0;
        Scanner scanner=new Scanner(System.in);
        while (players.size() > 1) {
            //--------------------------------------------------Діалог----------------------------------------------------------------------------------
            System.out.print("Натисніть 0, щоб"+players.get(turn).name+"кинув кубики, або ");
            for (int i=0;i<players.size();i++)
                System.out.print((i+1)+"- щоб"+players.get(i).name+"зайшов в банк, ");
            if (scanner.hasNextInt()) {
                selectedNumber =scanner.nextInt();
                switch (selectedNumber) {
                    case 0:
                        break;
                    case 1, 2, 3, 4:
                        System.out.println(players.get(selectedNumber - 1).name + " яку клітинку хочете купити? Введіть її номер на дорозі гри");
                        if (scanner.hasNextInt())
                            numberOnRoad =scanner.nextInt();
                        if (checkAndShopping(numberOnRoad,players.get(selectedNumber-1)))
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
            move(players.get(turn),cube1 + cube2);
            //--------------------------------------------------Видалення поточного гравця, якщо став банкротом---------------------------------------------

            //--------------------------------------------------Передача ходу-------------------------------------------------------------------------------
            turn++;
            if (turn > players.size() - 1)
                turn = 0;
        }
        //--------------------------------------------------Після циклу - оголошення переможця----------------------------------------------------------
        //players.get(0).name;
    }
    //##################################################################################################################################################
    void move(Player player, int cube){
        roadGame[player.positionOnRoad].redrawSymbolPlayer(player.symbol,' ');
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
    boolean checkAndShopping(int numberOnRoad, Player player) {

        return true;
    }
    //##################################################################################################################################################
    void setPlayers() {
        players=new ArrayList<Player>();
        players.add(new Player("Федір",'$'));
        players.add(new Player("Галина",'&'));
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
            for (int j = 0; j <= 10; j++) {

                fieldGame[i][j] = new Cell();
                fieldGame[i][j].cellsMatrix = new char[][]{{' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' '}
                };
            }
        //---------------------------------------------Заповнення CityCell клітинок---------------------------------------------------------------------
        fieldGame[0][1] = new CityCell(2, RED_BACKGROUND, 0, 150, 150, null, 220);
        fieldGame[0][1].cellsMatrix = new char[][]{{' ', '2', '2', '0'},
                {' ', ' ', ' ', ' '},
                {'В', 'е', 'н', 'е'},
                {' ', ' ', ' ', ' '}};

        fieldGame[0][3] = new CityCell(2, RED_BACKGROUND, 0, 150, 150, null, 220);
        fieldGame[0][3].cellsMatrix = new char[][]{{' ', '2', '2', '0'},
                {' ', ' ', ' ', ' '},
                {'М', 'і', 'л', 'а'},
                {' ', ' ', ' ', ' '}};

        fieldGame[0][4] = new CityCell(2, GameM.RED_BACKGROUND, 0, 150, 150, null, 240);
        fieldGame[0][4].cellsMatrix = new char[][]{{' ', '2', '4', '0'},
                {' ', ' ', ' ', ' '},
                {'Б', 'а', 'р', 'і'},
                {' ', ' ', ' ', ' '}};

        fieldGame[0][6] = new CityCell(2, GameM.PURPLE_BACKGROUND, 0, 150, 150, null, 260);
        fieldGame[0][6].cellsMatrix = new char[][]{{' ', '2', '6', '0'},
                {' ', ' ', ' ', ' '},
                {'А', 'м', 'с', 'т'},
                {' ', ' ', ' ', ' '}};

        fieldGame[0][7] = new CityCell(2, GameM.PURPLE_BACKGROUND, 0, 150, 150, null, 260);
        fieldGame[0][7].cellsMatrix = new char[][]{{' ', '2', '6', '0'},
                {' ', ' ', ' ', ' '},
                {'Г', 'о', 'р', 'н'},
                {' ', ' ', ' ', ' '}};

        fieldGame[0][9] = new CityCell(2, GameM.PURPLE_BACKGROUND, 0, 150, 150, null, 280);
        fieldGame[0][9].cellsMatrix = new char[][]{{' ', '2', '8', '0'},
                {' ', ' ', ' ', ' '},
                {'Л', 'і', 'с', 'е'},
                {' ', ' ', ' ', ' '}};

        fieldGame[1][10] = new CityCell(3, GameM.BLUE_BACKGROUND, 0, 200, 200, null, 300);
        fieldGame[1][10].cellsMatrix = new char[][]{{' ', 'К', ' ', ' '},
                {' ', 'р', ' ', '3'},
                {' ', 'і', ' ', '0'},
                {' ', 'с', ' ', '0'}};

        fieldGame[2][10] = new CityCell(3, GameM.BLUE_BACKGROUND, 0, 200, 200, null, 300);
        fieldGame[2][10].cellsMatrix = new char[][]{{' ', 'Ш', ' ', ' '},
                {' ', 'і', ' ', '3'},
                {' ', 'є', ' ', '0'},
                {' ', 'н', ' ', '0'}};

        fieldGame[4][10] = new CityCell(3, GameM.BLUE_BACKGROUND, 0, 200, 200, null, 320);
        fieldGame[4][10].cellsMatrix = new char[][]{{' ', 'О', ' ', ' '},
                {' ', 'с', ' ', '3'},
                {' ', 'л', ' ', '2'},
                {' ', 'о', ' ', '0'}};

        fieldGame[7][10] = new CityCell(3, GameM.GRAY_BACKGROUND, 0, 200, 200, null, 350);
        fieldGame[7][10].cellsMatrix = new char[][]{{' ', 'Л', ' ', ' '},
                {' ', 'ь', ' ', '3'},
                {' ', 'в', ' ', '5'},
                {' ', 'і', ' ', '0'}};

        fieldGame[9][10] = new CityCell(3, GameM.GRAY_BACKGROUND, 0, 200, 200, null, 400);
        fieldGame[9][10].cellsMatrix = new char[][]{{' ', 'К', ' ', ' '},
                {' ', 'и', ' ', '4'},
                {' ', 'ї', ' ', '0'},
                {' ', 'в', ' ', '0'}};

        fieldGame[1][0] = new CityCell(1, GameM.GREEN_BACKGROUND, 0, 100, 100, null, 200);
        fieldGame[1][0].cellsMatrix = new char[][]{{' ', ' ', 'П', ' '},
                {'2', ' ', 'р', ' '},
                {'0', ' ', 'а', ' '},
                {'0', ' ', 'г', ' '}};

        fieldGame[2][0] = new CityCell(1, GameM.GREEN_BACKGROUND, 0, 100, 100, null, 180);
        fieldGame[2][0].cellsMatrix = new char[][]{{' ', ' ', 'З', ' '},
                {'1', ' ', 'л', ' '},
                {'8', ' ', 'і', ' '},
                {'0', ' ', 'н', ' '}};


        fieldGame[4][0] = new CityCell(1, GameM.GREEN_BACKGROUND, 0, 100, 100, null, 180);
        fieldGame[4][0].cellsMatrix = new char[][]{{' ', ' ', 'Б', ' '},
                {'1', ' ', 'р', ' '},
                {'8', ' ', 'н', ' '},
                {'0', ' ', 'о', ' '}};


        fieldGame[6][0] = new CityCell(1, GameM.GREEN_BACKGROUND, 0, 100, 100, null, 160);
        fieldGame[6][0].cellsMatrix = new char[][]{{' ', ' ', 'К', ' '},
                {'1', ' ', 'а', ' '},
                {'6', ' ', 'т', ' '},
                {'0', ' ', 'о', ' '}};

        fieldGame[7][0] = new CityCell(1, GameM.GREEN_BACKGROUND, 0, 100, 100, null, 140);
        fieldGame[7][0].cellsMatrix = new char[][]{{' ', ' ', 'О', ' '},
                {'1', ' ', 'п', ' '},
                {'4', ' ', 'о', ' '},
                {'0', ' ', 'л', ' '}};


        fieldGame[9][0] = new CityCell(1, GameM.GREEN_BACKGROUND, 0, 100, 100, null, 140);
        fieldGame[9][0].cellsMatrix = new char[][]{{' ', ' ', 'В', ' '},
                {'1', ' ', 'р', ' '},
                {'4', ' ', 'о', ' '},
                {'0', ' ', 'ц', ' '}};

        fieldGame[10][1] = new CityCell(0, GameM.YELLOW_BACKGROUND, 0, 50, 50, null, 120);
        fieldGame[10][1].cellsMatrix = new char[][]{{' ', ' ', ' ', ' '},
                {'Н', 'а', 'н', 'т'},
                {' ', ' ', ' ', ' '},
                {' ', '1', '2', '0'}};

        fieldGame[10][2] = new CityCell(0, GameM.YELLOW_BACKGROUND, 0, 50, 50, null, 100);
        fieldGame[10][2].cellsMatrix = new char[][]{{' ', ' ', ' ', ' '},
                {'П', 'а', 'р', 'ж'},
                {' ', ' ', ' ', ' '},
                {' ', '1', '0', '0'}};

        fieldGame[10][4] = new CityCell(0, GameM.YELLOW_BACKGROUND, 0, 50, 50, null, 100);
        fieldGame[10][4].cellsMatrix = new char[][]{{' ', ' ', ' ', ' '},
                {'Л', 'і', 'о', 'н'},
                {' ', ' ', ' ', ' '},
                {' ', '1', '0', '0'}};

        fieldGame[10][7] = new CityCell(0, GameM.CYAN_BACKGROUND, 0, 50, 50, null, 60);
        fieldGame[10][7].cellsMatrix = new char[][]{{' ', ' ', ' ', ' '},
                {'М', 'а', 'н', 'ч'},
                {' ', ' ', ' ', ' '},
                {' ', ' ', '6', '0'}};
        fieldGame[10][9] = new CityCell(0, CYAN_BACKGROUND, 0, 50, 50, null, fieldGame[9][9],2,10,30,90,160,250);
        fieldGame[10][9].cellsMatrix = new char[][]{{' ', ' ', ' ', ' '},
                {'Л', 'о', 'н', 'д'},
                {' ', ' ', ' ', ' '},
                {' ', ' ', '6', '0'}};
        //---------------------------------------------Заповнення номерів клітинок---------------------------------------------------------------------

        //---------------------------------------------Заповнення клітинок інших ігрових класів---------------------------------------------------------------------

        //---------------------------------------------Заповнення країн містами---------------------------------------------------------------------
        Italy=new CityCell[3];
        Italy[0]= fieldGame[0][1];
        //---------------------------------------------Заповнення roadGame---------------------------------------------------------------------
    }
}

