package com.company;

import java.io.Serializable;

public class PortCell extends Cell implements CONSTANTS{
    //##################################################################################################################################################
    int rotation;   // 0-знизу, 1-зліва, 2-згори, 3-справа
    int statusRenta;
    final int[] rentaMas;
    Player holder;
    Cell helpful;
    PortCell[] port;
    //##################################################################################################################################################
    public PortCell(String[][] matrix,int rotation, int statusRenta,  Cell helpful , Player holder, PortCell[] port, int... rentaMas) {
        cellsMatrix=matrix;
        this.rotation = rotation;
        this.statusRenta = statusRenta;
        this.holder = holder;
        this.helpful = helpful;
        this.port=port;
        this.rentaMas = rentaMas;
        drawTextIntoCell(String.valueOf(rentaMas[0]), 3, false);
    }
    //##################################################################################################################################################
    boolean playerFromCell(Player player){
        redrawSymbolPlayer(player.symbol," ");
        return true;
    }
    //##################################################################################################################################################
    void playerIntoCell(Player player){
        if (statusRenta!=0) {
            player.money-= rentaMas[statusRenta];
            holder.money+= rentaMas[statusRenta];
        }
        redrawSymbolPlayer(" ",player.symbol);
    }
    //##################################################################################################################################################
    void redrawSymbolPlayer(String prevChar, String newChar){
        switch (rotation) {
            case 0:
                for (int i=0; i<4; i++)
                    if (cellsMatrix[2][i].equals(prevChar)) {
                        cellsMatrix[2][i]=newChar;
                        return;
                    }
            case 1:
                for (int i=0; i<4; i++)
                    if (cellsMatrix[i][1].equals(prevChar)) {
                        cellsMatrix[i][1] = newChar;
                        return;
                    }
            case 2:
                for (int i=0; i<4; i++)
                    if (cellsMatrix[1][i].equals(prevChar)) {
                        cellsMatrix[1][i] = newChar;
                        return;
                    }
            case 3:
                for (int i=0; i<4; i++)
                    if (cellsMatrix[i][2].equals(prevChar)) {
                        cellsMatrix[i][2] = newChar;
                        return;
                    }
        }
    }
    //##############################################  МІША  ####################################################################################################
    void purchase(Player player, int numberCell){
    }
    //##################################################################################################################################################
    void setHolder(Player holder){
        this.holder=holder;
        holder.ownership.add(this);
        switch (rotation) {
            case 0:
                cellsMatrix[1][3] = holder.symbol;;
                break;
            case 1:
                cellsMatrix[3][2] = holder.symbol;
                break;
            case 2:
                cellsMatrix[2][3] = holder.symbol;
                break;
            case 3:
                cellsMatrix[3][1] = holder.symbol;
                break;
        }
    }
    //##################################################################################################################################################
    void drawTextIntoCell(String text,int row, boolean helpful){
        Cell cell;
        if (helpful)
            cell=this.helpful;
        else
            cell = this;
        if (text.length()<4)
            for (int i=0; i<CONSTANTS.SIZE_CELLS-text.length(); i++)
                text = text + " ";
        String[] textInMas = text.split("");
        switch (rotation) {
            case 0:
                for (int i=0; (i<CONSTANTS.SIZE_CELLS)&(i<text.length()); i++)
                    cell.cellsMatrix[row][i] = textInMas[i];
                break;
            case 1:
                for (int i=0; (i<CONSTANTS.SIZE_CELLS)&(i<text.length()); i++)
                    cell.cellsMatrix[i][SIZE_CELLS-1-row] = textInMas[i];
                break;
            case 2:
                for (int i=0; (i<CONSTANTS.SIZE_CELLS)&(i<text.length()); i++)
                    cell.cellsMatrix[SIZE_CELLS-1-row][i] = textInMas[i];
                break;
            case 3:
                for (int i=0; (i<CONSTANTS.SIZE_CELLS)&(i<text.length()); i++)
                    cell.cellsMatrix[i][row] = textInMas[i];
                break;
        }
    }
    //##############################################  ВОВА  ####################################################################################################
    float getPrice(){
        return  0;
    }
    //##################################################################################################################################################
    public void printRow(int row){
        System.out.print(cellsMatrix[row][0] + cellsMatrix[row][1] + cellsMatrix[row][2] + cellsMatrix[row][3]);
    }
    //##################################################  АНДРІЙ  ################################################################################################
    public void printInfo() {

    }
}
