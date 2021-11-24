package com.company;

import java.io.Serializable;

public class CompanyCell extends Cell{
    //################################################  ОЛЕНА  ##################################################################################################
    int rotation;   // 0-знизу, 1-зліва, 2-згори, 3-справа
    int statusRenta;
    final int[] rentaMas;
    Player holder;
    Cell helpful;
    CompanyCell[] company;
    //################################################  ОЛЕНА  ##################################################################################################
    public CompanyCell(String[][] cellsMatrix, int rotation,  int statusRenta, Cell helpful, Player holder, CompanyCell[] company, int... rentaMas) {
        this.cellsMatrix=cellsMatrix;
        this.rotation = rotation;
        this.statusRenta = statusRenta;
        this.helpful = helpful;
        this.holder = holder;
        this.company=company;
        this.rentaMas = rentaMas;
        drawTextIntoCell(String.valueOf(rentaMas[2]), 3, false);

    }
    //################################################  ОЛЕНА  ##################################################################################################
    boolean playerFromCell(Player player){
        redrawSymbolPlayer(player.symbol," ");
        return true;
    }
    //################################################  ОЛЕНА  ##################################################################################################
    void playerIntoCell(Player player){
        if (statusRenta!=0) {
            player.money-= rentaMas[statusRenta];
            holder.money+= rentaMas[statusRenta];
        }
        redrawSymbolPlayer(" ",player.symbol);
    }
    //################################################  ОЛЕНА  ##################################################################################################
    void redrawSymbolPlayer(String prevChar, String newChar) {
        /*0-знизу, 1-зліва, 2-згори, 3-справа*/
        switch (rotation) {
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
        }
    }
    //###############################################  МІША  ###################################################################################################
    void purchase(Player player, int numberCell){
    }
    //###############################################  ОЛЕНА  ###################################################################################################
    void  setHolder(Player holder){
        this.holder=holder;
        holder.ownership.add(this);
        switch (rotation) {
            case 1:
                cellsMatrix[3][2] = holder.symbol;
                break;
            case 2:
                cellsMatrix[2][3] = holder.symbol;
                break;
        }
    }
    //###############################################  ОЛЕНА  ###################################################################################################
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
                for (int i = 0; i < CONSTANTS.SIZE_CELLS; i++){
                    cell.cellsMatrix[row][0] = " ";
                }
                for (int i=0; (i<CONSTANTS.SIZE_CELLS)&(i<text.length()); i++)
                    cell.cellsMatrix[row][i] = textInMas[i];
                break;
            case 1:
                for (int i=0; (i<CONSTANTS.SIZE_CELLS)&(i<text.length()); i++)
                    cell.cellsMatrix[i][CONSTANTS.SIZE_CELLS-1-row] = textInMas[i];
                break;
            case 2:
                for (int i=0; (i<CONSTANTS.SIZE_CELLS)&(i<text.length()); i++)
                    cell.cellsMatrix[CONSTANTS.SIZE_CELLS-1-row][i] = textInMas[i];
                break;
            case 3:
                for (int i=0; (i<CONSTANTS.SIZE_CELLS)&(i<text.length()); i++)
                    cell.cellsMatrix[i][row] = textInMas[i];
                break;
        }
    }
    //###############################################  ВОВА  ###################################################################################################
    float getPrice(){
        return  0;
    }
    //##################################################################################################################################################
    public void printRow(int row) {
                System.out.print(cellsMatrix[row][0] + cellsMatrix[row][1] + cellsMatrix[row][2] + cellsMatrix[row][3]);
    }
    //##############################################  АНДРІЙ  ####################################################################################################
    public void printInfo() {

    }
}

