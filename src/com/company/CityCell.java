package com.company;

public class CityCell extends Cell {
    int rotation;   // 0-знизу, 1-зліва, 2-згори, 3-справа
    String color;
    int statusRenta;
    int priceHouse;
    int priceHotel;
    int[] rentaMas;
    Player holder;
    //-----------------------------Константи кольорів рядків-------------------------------------------------------------------------------------------
    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";
    //##################################################################################################################################################
    CityCell(int sttRnt, int prcHus, int prcHtl, int rntMs, Player hld) {

    }
    //##################################################################################################################################################
    void move(Player player){
        if (statusRenta==0){



        }
        else {
            player.money =player.money -rentaMas[statusRenta];
        }
    }
    //##################################################################################################################################################
    void print(int row){
        switch (rotation) {
            case 0:
                switch (row) {
                    case 0:
                        System.out.print(color+cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+cellsMatrix[row][3]);
                        break;
                    default:
                        System.out.print(WHITE_BACKGROUND+cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+cellsMatrix[row][3]);
                }

            case 1:
                System.out.print(WHITE_BACKGROUND+cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+color+cellsMatrix[row][3]);


            case 2:
                switch (row) {
                    case 3:
                        System.out.print(color+cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+cellsMatrix[row][3]);
                    break;
                    default:
                        System.out.print(WHITE_BACKGROUND + cellsMatrix[row][0] + cellsMatrix[row][1] + cellsMatrix[row][2] + cellsMatrix[row][3]);
                }
            case 3:
                System.out.print(color + cellsMatrix[row][0] +WHITE_BACKGROUND+ cellsMatrix[row][1] + cellsMatrix[row][2] + cellsMatrix[row][3]);

        }
    }
}
