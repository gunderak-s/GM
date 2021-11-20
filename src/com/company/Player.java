package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    String name;
    String symbol;
    int money;
    int positionOnRoad;
    static int cube1;
    static int cube2;
    ArrayList<Cell> ownership;
    boolean inPrison;
    int termPrison ;
    //##################################################################################################################################################
    Player(String name, String symbol){
        this.name=name;
        this.symbol=symbol;
        money=1500;
        positionOnRoad=0;
        ownership=new ArrayList<>();
    }
    //##################################################################################################################################################
    void throwDice(){
        cube1 = (int) (Math.random() * 6) + 1;
        cube2 = (int) (Math.random() * 6) + 1;
    }
    //##################################################################################################################################################
    boolean identicalCubes(){
        return  true;
    }
    //##################################################################################################################################################
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
    //##################################################################################################################################################
    public void printInfo() {

    }
}
