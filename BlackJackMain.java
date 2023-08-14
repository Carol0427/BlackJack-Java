/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author carol
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */ 
    public static void main(String[] args) {
        // TODO code application logic here
        //BLACKJACK
        Scanner in = new Scanner(System.in);
        
        Card[] Deck = CreateDeck();
        /*for(int i=0;i<Deck.length;i++){
            System.out.println(Deck[i].getNumber()+" of "+Deck[i].getSign());
        }*/
        Card[] player = new Card[10];
        int totalPoints = 0;
        int hit_or_bust;
        int deck_index = 0;
        int player_index = 0;
        System.out.println("Welcome to BlackJack!");
        System.out.println("You are going to draw cards until you get 21, if you get past 21 then you lose");
        int tries =0;
        int[] prev_nums = new int[52];
        int prev_index = 0;
        do {
            if (tries > 0){
                System.out.println("Your Hand: ");
                for (int i =0;i<player_index;i++){
                    System.out.print(player[i].getName()+", ");
                }
            }
        System.out.println("\nHit or Bust?\n1.Hit\n2.Bust");
        hit_or_bust = in.nextInt();
        int rand_num = RandomCard(prev_nums);
        prev_nums[prev_index] = rand_num;
        prev_index++;
        if (hit_or_bust == 1){
            player[player_index] = Deck[rand_num];
            System.out.println("Your Card: "+player[player_index].getName());
            //System.out.println("Points: "+player[player_index].getPoints(player[player_index].getNumber()));
            totalPoints += player[player_index].getPoints(player[player_index].getNumber());
            System.out.println("Total Points: "+totalPoints);
            if (totalPoints == 21){
                System.out.println("You win!");
            }
            else if (totalPoints > 21){
                System.out.println("You lost :<");
            }
            player_index++;
            deck_index++;
        }
        else if (hit_or_bust == 2){
            deck_index++;
        }
        tries++;
        }while(totalPoints < 21);
    }
    public static int RandomCard(int[] prev_nums){
        Random rand = new Random();
        int upbound = 53;
        int rand_num = rand.nextInt(upbound);
        for (int i =0;i<prev_nums.length;i++){
             while(rand_num == prev_nums[i]){
                 rand_num = rand.nextInt(upbound);
             }
        }
        return rand_num;
    }
    public static Card[] CreateDeck() {
        String sign, number;
        String[] signs = {"hearts", "clubs", "spades", "diamonds"};
        String[] numbers = {"Ace","2","3","4","5","6","7","8","9","10", "Jack", "Queen", "King"};
        Card[] Deck = new Card[52];
        int index = 0;
        for (int i = 0;i<numbers.length;i++){
            for (int a =0;a<signs.length;a++){
                number = numbers[i];
                sign = signs[a];
                Card card = new Card(sign, number);
                Deck[index] = card;
                index++;
            }
        }      
        return Deck;
    }
}
