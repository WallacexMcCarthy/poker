package com.hillcrest.poker;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * represetns a deck of cards containing 52 playing cards
 */
public class Deck {

    private List<Card> deck;
    private Random rand;
    /**
     * creates instane of a deck with 52 cards
     */

    public Deck(){
        deck = new ArrayList<>();
        createDeck();
        rand = new Random();
    }

    /**
     * // adds each card to a deck
     */
    private void createDeck(){
        for(int i = 0; i < 4; i++){
            for(int j = 1; j<= 13; j++){
                deck.add(new Card(j,i));
            }
        }
    }

    /**
     * / shuffles the deck
     */
    public void shuffleDeck(){
        List<Card> shuffleDeck = new ArrayList<>();

        while(!deck.isEmpty()){
            shuffleDeck.add(deck.remove(rand.nextInt(deck.size())));
        }
        while(!shuffleDeck.isEmpty()){
            deck.add(shuffleDeck.remove(rand.nextInt(shuffleDeck.size())));
        }
    }

    /**
     * / deals card form top of deck
     * @return the top card
     */
    public Card dealCard(){
        return deck.remove(0);
    }

    /**
     * returns discarded card to deck
     * @param card the discrarded card
     */
    public void discardCard(Card card){
        deck.add(card);
    }
}
