/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;
import java.util.Random;
/**
 *
 * @author carol
 */
public class Card {
    private String sign;
    private String number;
    private int points;
    public Card(String s, String n) {
        this.sign = s;
        this.number = n;
    }
    String getSign(){
        return sign;
    }
    String getNumber(){
        return number;
    }
    int getPoints(String number){
        if (null != number)switch (number) {
            case "Ace" -> points = 1;
            case "2" -> points = 2;
            case "3" -> points = 3;
            case "4" -> points = 4;
            case "5" -> points = 5;
            case "6" -> points = 6;
            case "7" -> points = 7;
            case "8" -> points = 8;
            case "9" -> points = 9;
            case "10" -> points = 10;
            case "Jack" -> points = 11;
            case "Queen" -> points = 12;
            case "King" -> points = 13;
            default -> {
            }
        }
        return points;
    }
    String getName(){
        return number+" of "+sign;
    }
}
