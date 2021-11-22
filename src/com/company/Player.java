package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable, Print {
    //###################################################  ВОВА  ###############################################################################################
    int awayFromPrisonCell;
    String name;
    String symbol;
    int money;
    int positionOnRoad;
    static int cube1;
    static int cube2;
    ArrayList<Cell> ownership;
    boolean inPrison;
    int termPrison ;
    //###################################################  ВОВА  ###############################################################################################
    Player(String name, String symbol){
        this.name=name;
        this.symbol=symbol;
        money=1500;
        positionOnRoad=0;
        awayFromPrisonCell=0;
        ownership=new ArrayList<>();
    }
    //###################################################  ВОВА  ###############################################################################################
    void throwDice(){
        cube1 = (int) (Math.random() * 6) + 1;
        cube2 = (int) (Math.random() * 6) + 1;
    }
    //###################################################  ВОВА  ###############################################################################################
    boolean identicalCubes(){
        return  true;
    }
    //###################################################  ВОВА  ###############################################################################################
    void move(int lengthRoad){
            roadGame[player.positionOnRoad].redrawSymbolPlayer(player.symbol, " ");
        for (int i = 0; i < cube; i++) {
            if (player.positionOnRoad != 40) {
                player.positionOnRoad++;
            } else {
                player.positionOnRoad = 0;
            }
        }
        roadGame[player.positionOnRoad].action(player);
    }
    //###################################################  АНДРІЙ  ###############################################################################################
    public void printRow(int row) {

    }
    //###################################################  АНДРІЙ  ###############################################################################################
    public void printInfo() {

    }
}
