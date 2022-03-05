package com.hillcrest.poker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PokerTest {
    private PokerGame game;


    @BeforeEach
    public void setup(){
        game = new PokerGame();
    }
    @Test
    public void testRoyalFlush(){
        game.getPlayerHand()[0] = new Card(Card.KING, 1);
        game.getPlayerHand()[1] = new Card(Card.ACE, 1);
        game.getPlayerHand()[2] = new Card(11,1);
        game.getPlayerHand()[3] = new Card(10,1);
        game.getPlayerHand()[4] = new Card(12,1);

        int winnings = game.scoreHand();
        Assertions.assertEquals(250, winnings);
    }

    @Test
    public void testStraightFlush(){
        game.getPlayerHand()[0] = new Card(Card.KING, 1);
        game.getPlayerHand()[1] = new Card(9, 1);
        game.getPlayerHand()[2] = new Card(11,1);
        game.getPlayerHand()[3] = new Card(10,1);
        game.getPlayerHand()[4] = new Card(12,1);

        int winnings = game.scoreHand();
        Assertions.assertEquals(50, winnings);
    }
    public void flush(){
        game.getPlayerHand()[0] = new Card(Card.KING, 1);
        game.getPlayerHand()[1] = new Card(9, 1);
        game.getPlayerHand()[2] = new Card(3,1);
        game.getPlayerHand()[3] = new Card(10,1);
        game.getPlayerHand()[4] = new Card(12,1);

        int winnings = game.scoreHand();
        Assertions.assertEquals(5, winnings);
    }

    @Test
    public void testFullHouse(){
        game.getPlayerHand()[0] = new Card(Card.KING, 1);
        game.getPlayerHand()[1] = new Card(Card.KING, 2);
        game.getPlayerHand()[2] = new Card(Card.KING,3);
        game.getPlayerHand()[3] = new Card(10,1);
        game.getPlayerHand()[4] = new Card(10,2);
        int winnings = game.scoreHand();
        Assertions.assertEquals(6, winnings);
    }

    @Test
    public void testFourOfAKind(){
        game.getPlayerHand()[0] = new Card(Card.KING, 1);
        game.getPlayerHand()[1] = new Card(Card.KING, 2);
        game.getPlayerHand()[2] = new Card(Card.KING,3);
        game.getPlayerHand()[3] = new Card(Card.KING,4);
        game.getPlayerHand()[4] = new Card(10,2);
        int winnings = game.scoreHand();
        Assertions.assertEquals(25, winnings);
    }

    @Test
    public void testthreeOfAKind(){
        game.getPlayerHand()[0] = new Card(Card.ACE, 1);
        game.getPlayerHand()[1] = new Card(Card.KING, 2);
        game.getPlayerHand()[2] = new Card(Card.KING,3);
        game.getPlayerHand()[3] = new Card(Card.KING,4);
        game.getPlayerHand()[4] = new Card(10,2);
        int winnings = game.scoreHand();
        Assertions.assertEquals(3, winnings);
    }
    @Test
    public void testTwoPair(){
        game.getPlayerHand()[0] = new Card(Card.ACE, 1);
        game.getPlayerHand()[1] = new Card(Card.ACE, 2);
        game.getPlayerHand()[2] = new Card(Card.KING,3);
        game.getPlayerHand()[3] = new Card(Card.KING,4);
        game.getPlayerHand()[4] = new Card(10,2);
        int winnings = game.scoreHand();
        Assertions.assertEquals(2, winnings);
    }

    @Test
    public void testPair(){
        game.getPlayerHand()[0] = new Card(4, 1);
        game.getPlayerHand()[1] = new Card(3, 2);
        game.getPlayerHand()[2] = new Card(Card.KING,3);
        game.getPlayerHand()[3] = new Card(Card.KING,4);
        game.getPlayerHand()[4] = new Card(10,2);
        int winnings = game.scoreHand();
        Assertions.assertEquals(1, winnings);
    }

    @Test
    public void testNone(){
        game.getPlayerHand()[0] = new Card(4, 1);
        game.getPlayerHand()[1] = new Card(3, 2);
        game.getPlayerHand()[2] = new Card(2,3);
        game.getPlayerHand()[3] = new Card(Card.KING,4);
        game.getPlayerHand()[4] = new Card(10,2);
        int winnings = game.scoreHand();
        Assertions.assertEquals(0, winnings);
    }
}
