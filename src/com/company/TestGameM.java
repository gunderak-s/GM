package com.company;

import java.io.*;
import java.util.Scanner;

public class TestGameM {
    //##################################################################################################################
    public static void main(String[] args) {
	    //--------------------------------------Ініціалізація-----------------------------------------------------------
        String fileName=null;
        File file;
        Scanner scanner=new Scanner(System.in);
        GameM g1=null;
        //--------------------------------------Діалог старту гри-------------------------------------------------------
        System.out.println("Нова гра -0, завантажити -1");
        if (scanner.hasNextInt())
            if (scanner.nextInt()==0) {
                g1 = new GameM();
                g1.game(true);
            }
            else {
                 do {
                     System.out.println("введіть назву файлу");
                     if (scanner.hasNext())
                         fileName = scanner.next();
                     g1=loadGame(fileName);
                 }
                 while (g1==null);
                 g1.game(false);
            }
        // тут будем після виходу із гри
        //-------------------------------------Діалог завершення гри----------------------------------------------------
        System.out.println("Зберегти гру? 0-ні 1-так");
        if (scanner.hasNextInt())
            if (scanner.nextInt()==1){
                while(true) {
                    System.out.println("введіть назву файлу");
                    if (scanner.hasNext())
                        fileName = scanner.next();
                    file = new File(fileName);
                    if (file.exists())
                        System.out.println("файл вже існує");
                    else
                        break;
                }
                saveGame(g1,fileName);
            }
        scanner.close();
    }
    //##################################################################################################################
    static void saveGame(GameM g,String fileName) {
        try {
            ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("save\\"+fileName));
            System.out.println("objectl: " + g);
            objOStrm.writeObject(g);
        } catch (IOException e) {
            System.out.println("помилка" + e);
        }
    }
    //##################################################################################################################
    static GameM loadGame(String fileName){
        GameM g;
        try {
            ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("save\\"+fileName));
            System.out.println("objectl: ");
            g= (GameM) objIStrm.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("помилка" + e);
            return  null;
        }
        return  g;
    }
}
