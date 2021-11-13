package com.company;

public class PortCell extends Cell{
    int rotation;   // 0-знизу, 1-зліва, 2-згори, 3-справа
    String symbol;
    int statusRenta;
    int priceCompany;
    final int[] rentaMas;
    Player holder;
    Cell helpful;

    public PortCell(int rotation, String symbol, int statusRenta, int priceCompany,  Cell helpful , Player holder, int... rentaMas) {
        this.rotation = rotation;
        this.symbol = symbol;
        this.statusRenta = statusRenta;
        this.priceCompany = priceCompany;
        this.rentaMas = rentaMas;
        this.holder = holder;
        this.helpful = helpful;
    }

    void action(Player player){
        if (statusRenta!=0){
            player.money =player.money -rentaMas[statusRenta];

        }

    }
    //##################################################################################################################################################
    void redrawSymbolPlayer(String oldChar, String newChar){
        /*0-знизу, 1-зліва, 2-згори, 3-справа*/
        switch (rotation){
            case 2:
                for (int i = 0; i <cellsMatrix.length ; i++) {
                    if (cellsMatrix[2][i] == oldChar) cellsMatrix[2][i] = newChar;
                    break; }
            case 3:
                for (int i = 0; i <cellsMatrix.length ; i++) {
                    if (cellsMatrix[i][1]==oldChar) cellsMatrix[i][1]=newChar;
                }
            case 0:
                for (int i = 0; i <cellsMatrix.length ; i++) {
                    if (cellsMatrix[1][i]==oldChar) cellsMatrix[1][i]=newChar;
                }
            case 1:
                for (int i = 0; i <cellsMatrix.length ; i++) {
                    if (cellsMatrix[i][2]==oldChar) cellsMatrix[i][2]=newChar;
                }
        }
    }
    //##################################################################################################################################################
    void  redrawStatus(char holderChar){
        //--------------------------------------------------Запис власника-------------------------------------------------------------------------------

        //--------------------------------------------------Зміна ренти-------------------------------------------------------------------------------
        /*не розумію що тут має робитись*/
        /*int price =rentaMas[statusRenta];
        String s=String.valueOf(price);
        char[] masC=s.toCharArray();
        int lengthMas=masC.length;*/

        //masC[0]=2
        //masC[1]=8
        //masC[2]=0
    }
    //##################################################################################################################################################
    void printInfo(){

    }
    //##################################################################################################################################################
    void printMatrix(int row){
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
}
