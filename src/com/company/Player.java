package com.company;

public class Player {
    String name;
    char symbol;
    int money;
    int positionOnRoad;
    {positionOnRoad=0;}

    void setPositionOnRoad(int cube){
        for (int i = 0; i < cube; i++) {
            if (positionOnRoad!=40){
            positionOnRoad++;}
            else {
                positionOnRoad=0;
            }
        }
    }

}
