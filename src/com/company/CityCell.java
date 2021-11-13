package com.company;

public class CityCell extends Cell {
    int rotation;   // 0-знизу, 1-зліва, 2-згори, 3-справа
    String color;
    int statusRenta;
    int priceHouse;
    int priceHotel;
    final int[] rentaMas;
    Player holder;
    Cell helpful;
    //##################################################################################################################################################
    CityCell(String name, int rotation,  String color, int statusRenta, int priceHouse , int priceHotel, Player holder,Cell helpful, int ... rentaMas) {
        this.rotation = rotation;
        this.color = color;
        this.statusRenta = statusRenta;
        this.priceHouse = priceHouse;
        this.priceHotel = priceHotel;
        this.holder = holder;
        this.helpful = helpful;
        this.rentaMas = rentaMas;
        //---------------------------------------------------Записати статус, просто викликавши redrawStatus()-------------------------------------------------------

        //---------------------------------------------------Записати назву, аналогічно як в redrawStatus()-------------------------------------------------------

            String[] n = name.split("");

            switch (rotation) {
                case 0:
                    for (int i = 0; i < 4; i++) {
                        cellsMatrix[1][i] = n.toString();
                        return;
                    }
                    break;

                case 1:
                    for (int j = 0; j < 4; j++) {
                        cellsMatrix[j][2] = n.toString();
                        return;
                    }
                    break;


                case 2:
                    for (int i = 0; i < 4; i++) {
                        cellsMatrix[2][i] = n.toString();
                        return;
                    }
                    break;

                case 3:
                    for (int j = 0; j < 4; j++) {
                        cellsMatrix[j][1] = n.toString();
                        return;
                    }
                    break;
            }

        }

    //##################################################################################################################################################
    void action(Player player){
        if (statusRenta!=0){
            player.money =player.money -rentaMas[statusRenta];

        }
        redrawSymbolPlayer(" ",player.symbol);
    }
    //##################################################################################################################################################
    void redrawSymbolPlayer(String prevChar,String newChar){

    }
    //##################################################################################################################################################
    void  setHolder(Player holder){

    }
    //##################################################################################################################################################
    void  resetStatus(){
        //--------------------------------------------------Зміна ренти-------------------------------------------------------------------------------

        //--------------------------------------------------Запис нової ренти-------------------------------------------------------------------------------
        int price =rentaMas[statusRenta];
        String s=String.valueOf(price);
        String[] masS=s.split("");
        //int lengthMas=masC.length;

        switch (rotation) {
            case 0:
                for (int i = 0; i < 4; i++){
                    cellsMatrix[3][i] = masS[i];
                return;
                }
                break;

            case 1:
                for (int j = 0; j < 4; j++){
                    cellsMatrix[j][0] = masS[j];
                return;
                }
                break;

            case 2:
                for (int i = 0; i < 4; i++){
                    cellsMatrix[0][i] = masC.toString();
                return;
                }
                break;

            case 3:
                for (int j = 0; j < 4; j++){
                    cellsMatrix[j][3] = masC.toString();
                return;
                }
                break;
        }
    }
    //##################################################################################################################################################
    void printMatrix(int row){
        switch (rotation) {
            case 0:
                switch (row) {
                    case 0:
                        System.out.print(color+cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+cellsMatrix[row][3]);
                        break;
                    default:
                        System.out.print(GameM.WHITE_BACKGROUND+cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+cellsMatrix[row][3]);
                }
            break;
            case 1:
                System.out.print(GameM.WHITE_BACKGROUND+cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+color+cellsMatrix[row][3]);
            break;

            case 2:
                switch (row) {
                    case 3:
                        System.out.print(color+cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+cellsMatrix[row][3]);
                    break;
                    default:
                        System.out.print(GameM.WHITE_BACKGROUND + cellsMatrix[row][0] + cellsMatrix[row][1] + cellsMatrix[row][2] + cellsMatrix[row][3]);
                }
            break;
            case 3:
                System.out.print(color + cellsMatrix[row][0] +GameM.WHITE_BACKGROUND+ cellsMatrix[row][1] + cellsMatrix[row][2] + cellsMatrix[row][3]);
            break;
        }
    }
}
