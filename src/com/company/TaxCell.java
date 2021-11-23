package com.company;

public class TaxCell extends  Cell{
    //#################################################  ВОВА  #################################################################################################

    //#################################################  ВОВА  #################################################################################################
    public TaxCell() {

    }
    //##################################################################################################################################################
    boolean playerFromCell(Player player){
        redrawSymbolPlayer(player.symbol," ");
        return true;
    }
    //#################################################  ВОВА  #################################################################################################
    public void playerIntoCell(Player player){
        redrawSymbolPlayer(" ",player.symbol);
    }
    //##################################################################################################################################################
    void redrawSymbolPlayer(String prevChar, String newChar){
        for (int i=0;i<4;i++)
            for (int j=0;j<4;j++)
                if (cellsMatrix[i][j].equals(prevChar)) {
                    cellsMatrix[i][j] = newChar;
                    return;
                }
    }
    //##################################################################################################################################################
    public void printRow(int row){
        System.out.print(GameM.WHITE_BACKGROUND+cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+cellsMatrix[row][3]);
    }

}
