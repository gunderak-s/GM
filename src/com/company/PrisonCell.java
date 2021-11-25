package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class PrisonCell extends Cell {
    //###############################################  ОЛЕНА  ###################################################################################################
    Player player;
    ArrayList<Offender> offender;
    ArrayList<Integer> timePrison;
    String[][] cellMatrix;
    int prisonPositionOnRoad;

    //###############################################  ОЛЕНА  ###################################################################################################
    public PrisonCell(String[][] cellMatrix, int prisonPositionOnRoad, ArrayList<Offender> offender, ArrayList<Integer> timePrison) {
    this.cellMatrix = cellMatrix;
    this.prisonPositionOnRoad=prisonPositionOnRoad;
    this.offender=new ArrayList<>();
    this.timePrison=new ArrayList<>();
    }
    //###############################################  ОЛЕНА  ###################################################################################################
    void arest(Player player){
        player.positionOnRoad=prisonPositionOnRoad;
        offender.add(new Offender(player,3));
        redrawSymbolPlayer(player.symbol, "+");
    }
    //###############################################  ОЛЕНА  ###################################################################################################
    boolean playerFromCell(Player player){
      for(Offender offender:offender) {
          if(player == offender.player){
              if(player.identicalCubes()){
                  redrawSymbolPlayer(player.symbol, " ");
                  offender.remove(offender);
                  return true;
              }
          if(offender.timePrison==0){
              player.money-=50;
              redrawSymbolPlayer(player.symbol, " ");
              offender.remove(offender);
              return true;
          }
          if(player.money<50){
             System.out.println("У вас замало коштів!");
             offender.timePrison--;
             return false;
          }
          System.out.println("Натисніть 0 для виходу з тюрми за 50, або 1, щоб залишитись!");
              Scanner scanner = new Scanner(System.in);
              if(scanner.hasNextInt()){
                  if(scanner.nextInt()==1){
                      offender.timePrison--;
                      return false;
                  }
              }
          player.money-=50;
          offender.remove(offender);
          redrawSymbolPlayer(player.symbol, " ");
          return true;
          }
      }

        redrawSymbolPlayer(player.symbol," ");
        return true;
    }
    //##################################################################################################################################################
    public void playerIntoCell(Player player){

        redrawSymbolPlayer(" ",player.symbol);
    }
    //##################################################################################################################################################
    public void printRow(int row){
        System.out.print(GameM.WHITE_BACKGROUND+cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+cellsMatrix[row][3]);
    }
}
