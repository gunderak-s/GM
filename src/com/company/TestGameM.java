package com.company;

import java.io.*;

public class TestGameM {

    public static void main(String[] args) {
	// write your code here
        //GameM g1=new GameM();
        //g1.setField();
        //g1.setPlayers();
        //saveGame(g1);
        GameM g1=loadGame();
        g1.printField();

    }
    static void saveGame(GameM g) {
        try {
            ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("save1"));
            System.out.println("objectl: " + g);
            objOStrm.writeObject(g);
        } catch (IOException e) {
            System.out.println("помилка" + e);
        }
    }
    static GameM loadGame(){
        GameM g=null;
        try {
            ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("save1"));
            System.out.println("objectl: ");
            g= (GameM) objIStrm.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("помилка" + e);
        }
        return  g;
    }
}
