/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author wjorr
 */
public class Deck {
    
        public List<String> deck = new ArrayList<>();
        private final int n = 52;
        private int z = 0;
        
        private final String[] SUITS = {
            "CLUBS", "DIAMONDS", "HEARTS", "SPADES"
        };

        private final String[] RANKS = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "JACK", "QUEEN", "KING", "ACE"
        };

        public Deck() {
        // initialize deck
        for (int i = 0; i < RANKS.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                deck.add(RANKS[i] + " of " + SUITS[j]);
                z++;
              }
            }
        
        shuffle();
        
        }

        // shuffle
        public void shuffle() {
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n-i));
            String temp = deck.get(r);
            deck.set(r, deck.get(i));
            deck.set(i, temp);
            }
        }
        public String pop() {
            
            String Card = this.deck.get(0);
            
            this.deck.remove(0);
            
            return Card;
        }
        
        // print deck
        
        public void print(){
        for (int i = 0; i < n; i++) {
            System.out.println(deck.get(i));
        }
    }
    
}


