package com.company;

public class PrisonCell extends Cell {
    //###############################################  МІША  ###################################################################################################
     Player visitor;
     Player offender;
     String[][] cellMatrix;

    //###############################################  МІША  ###################################################################################################
    public PrisonCell(String[][] cellMatrix, Player visitor, Player offender) {
    this.cellMatrix = cellMatrix;
    this.visitor = visitor;
    this.offender = offender;
    }
    //###############################################  МІША  ###################################################################################################
    void arest(){

    }
    //###############################################  МІША  ###################################################################################################
    boolean playerFromCell(Player player){
        redrawSymbolPlayer(player.symbol," ");
        return true;
    }
    //###############################################  МІША  ###################################################################################################
    public void playerIntoCell(Player player){

        redrawSymbolPlayer(" ",player.symbol);
    }
    //###############################################  МІША  ###################################################################################################
    void redrawSymbolPlayer(String prevChar, String newChar){
        for (int i=0;i<4;i++)
            for (int j=0;j<4;j++)
                if (cellsMatrix[i][j].equals(prevChar)) {
                    cellsMatrix[i][j] = newChar;
                    return;
                }
    }
    //###############################################  ОЛЕНА  ###################################################################################################
    void drawTextIntoCell(String text,int row, boolean helpful){

    }
    //##################################################################################################################################################
    public void printRow(int row){
        System.out.print(GameM.WHITE_BACKGROUND+cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+cellsMatrix[row][3]);
    }
}
