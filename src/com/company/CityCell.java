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
    CityCell[] country;

    //##################################################################################################################################################
    CityCell(String name, int rotation,  String color, int statusRenta, int priceHouse , int priceHotel, Player holder,Cell helpful,CityCell[] country, int ... rentaMas) {
        this.rotation = rotation;
        this.color = color;
        this.statusRenta = statusRenta;
        this.priceHouse = priceHouse;
        this.priceHotel = priceHotel;
        this.holder = holder;
        this.helpful = helpful;
        this.country=country;
        this.rentaMas = rentaMas;
        //---------------------------------------------------Записати статус, просто викликавши redrawStatus()-------------------------------------------------------
        drawTextIntoCell();
        //---------------------------------------------------Записати назву, аналогічно як в resetStatus()-------------------------------------------------------

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
    void drawTextIntoCell(String text, int row, boolean inHelpful){
        Cell cell;
        if (inHelpful)
            cell=helpful;
        else
            cell=this;
        if (text.length()<CONSTANTS.SIZE_CELLS);
            for (int i=0; i<4-CONSTANTS.SIZE_CELLS.length();i++)
                text=text+" ";
        String[] textInMas = text.split("");
        switch (rotation) {
            case 0:
                cell.cellsMatrix[row][0]=" ";
                for (int i=0; (i<CONSTANTS.SIZE_CELLS)&(i<textInMas.length); i++)
                    cell.cellsMatrix[row][CONSTANTS.SIZE_CELLS] = textInMas[textInMas.length];
                break;
            case 1:
                for (int i=0; (i<CONSTANTS.SIZE_CELLS)&(i<textInMas.length); i++)
                    cell.cellsMatrix[CONSTANTS.SIZE_CELLS][row] = textInMas[textInMas.length];
                break;
            case 2:
                for (int i=0; (i<CONSTANTS.SIZE_CELLS)&(i<textInMas.length); i++)
                    cell.cellsMatrix[row][CONSTANTS.SIZE_CELLS] = textInMas[textInMas.length];
                break;
            case 3:
                for (int i=0; (i<CONSTANTS.SIZE_CELLS)&(i<textInMas.length); i++)
                    cell.cellsMatrix[CONSTANTS.SIZE_CELLS][row] = textInMas[textInMas.length];
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
