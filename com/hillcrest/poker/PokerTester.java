package com.hillcrest.poker;

import java.util.Scanner;

/**
 * calls the classes and gets a user input for if you want ot keep a card or not
 * atthe sned it will scor the hand and give you tokens etc.
 */
public class PokerTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PokerGame game = new PokerGame();
        System.out.println(game.getGameMenu());
        int option = in.nextInt();

        while(option != 2){
            game.decrementToken();
            game.deal();
            System.out.println(game.displayHand());
            for(int i = 0; i < game.getPlayerHand().length; i++){
                System.out.println(game.getCardMenu(i));
                int discard = in.nextInt();
                if(discard == 2){
                    game.discardCard(i);
                }
                System.out.println(game.displayHand());
            }
            int tokensWon = game.scoreHand();
            System.out.println("You won " + tokensWon + " tokens");
            game.payWinnings(tokensWon);
            System.out.println(game.getGameMenu());
            option = in.nextInt();
        }
    }
}
