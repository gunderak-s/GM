package com.company;

import java.io.Serializable;

public class PortCell extends Cell{
    //#################################################  ОЛЕНА  #################################################################################################
    int rotation;   // 0-знизу, 1-зліва, 2-згори, 3-справа
    String symbol;
    int statusRenta;
    int priceCompany;
    final int[] rentaMas;
    Player holder;
    Cell helpful;
    //#################################################  ОЛЕНА  #################################################################################################
    public PortCell(int rotation, String symbol, int statusRenta, int priceCompany,  Cell helpful , Player holder, int... rentaMas) {
        this.rotation = rotation;
        this.symbol = symbol;
        this.statusRenta = statusRenta;
        this.priceCompany = priceCompany;
        this.rentaMas = rentaMas;
        this.holder = holder;
        this.helpful = helpful;
    }
    //#################################################  ОЛЕНА  #################################################################################################
    boolean playerFromCell(Player player){
        redrawSymbolPlayer(player.symbol," ");
        return true;
    }
    //#################################################  ОЛЕНА  #################################################################################################
    void playerIntoCell(Player player){
        redrawSymbolPlayer(" ",player.symbol);
    }
    //#################################################  ОЛЕНА  #################################################################################################
    void redrawSymbolPlayer(String oldChar, String newChar){
        /*0-знизу, 1-зліва, 2-згори, 3-справа*/
        switch (rotation){
            case 2:
                for (int i = 0; i <cellsMatrix.length ; i++) {
                    if (cellsMatrix[2][i] == oldChar) {
                        cellsMatrix[2][i] = newChar;
                    return;}
                    break; }
            case 3:
                for (int i = 0; i <cellsMatrix.length ; i++) {
                    if (cellsMatrix[i][1]==oldChar) {
                        cellsMatrix[i][1]=newChar;
                    return;}
               break; }
            case 0:
                for (int i = 0; i <cellsMatrix.length ; i++) {
                    if (cellsMatrix[1][i]==oldChar) {
                        cellsMatrix[1][i]=newChar;
                    return;}
                break;}
            case 1:
                for (int i = 0; i <cellsMatrix.length ; i++) {
                    if (cellsMatrix[i][2]==oldChar) {
                        cellsMatrix[i][2]=newChar;
                    return;}
                break;}
        }
    }
    //##############################################  МІША  ####################################################################################################
    void purchase(Player player, int numberCell){
    }
    //##############################################  ОЛЕНА  ####################################################################################################
    void setHolder(Player player){

    }
    //##############################################  ОЛЕНА  ####################################################################################################
    void drawTextIntoCell(String text,int row, boolean helpful){

    }
    //##############################################  ВОВА  ####################################################################################################
    float getPrice(){
        return  0;
    }
    //##################################################################################################################################################
    public void printRow(int row){
        switch (rotation) {
            case 0:
                switch (row) {
                    case 0:
                        System.out.print(symbol +cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+cellsMatrix[row][3]);
                        break;
                    default:
                        System.out.print(cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+cellsMatrix[row][3]);
                }
                break;
            case 1:
                System.out.print(cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+ symbol +cellsMatrix[row][3]);
                break;

            case 2:
                switch (row) {
                    case 3:
                        System.out.print(symbol +cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+cellsMatrix[row][3]);
                        break;
                    default:
                        System.out.print( cellsMatrix[row][0] + cellsMatrix[row][1] + cellsMatrix[row][2] + cellsMatrix[row][3]);
                }
                break;
            case 3:
                System.out.print(symbol + cellsMatrix[row][0] + cellsMatrix[row][1] + cellsMatrix[row][2] + cellsMatrix[row][3]);
                break;
        }
    }
    //##################################################  АНДРІЙ  ################################################################################################
    public void printInfo() {

    }
}
