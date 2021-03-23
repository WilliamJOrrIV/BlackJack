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
public class Dealer{
    
    private int DealerScore;
    public List<String> dealerCards = new ArrayList<>();
    public boolean Busted = false;
    
    public Dealer(){
        DealerScore = 0;
    }
    
    public void clearScore() {
        DealerScore = 0;
        dealerCards.clear();
    }
    
    public void addCard(String Card) {
        this.dealerCards.add(Card);
    }
    
    public int convertCard(String card) {
        
        if(card.contains("ACE"))
            return 11;
        else if(card.contains("2")) 
            return 2;
        else if(card.contains("3")) 
            return 3;
        else if(card.contains("4")) 
            return 4;
        else if(card.contains("5")) 
            return 5;
        else if(card.contains("6")) 
            return 6;
        else if(card.contains("7")) 
            return 7;
        else if(card.contains("8")) 
            return 8;
        else if(card.contains("9")) 
            return 9;
        else if(card.contains("10")) 
            return 10;
        else if(card.contains("JACK")) 
            return 10;
        else if(card.contains("QUEEN")) 
            return 10;
        else if(card.contains("KING")) 
            return 10;
        return 0;
    }
    
    public String showCard() {
        return this.dealerCards.get(0);
    }
    
     public boolean checkBlackJack(int score) {
        if(score == 21)
            return true;
        else 
            return false;
    }
    
    private String ValidateSoft17() {
        if(DealerScore == 17) {
            if(dealerCards.size() > 2) 
                return "stay";
            else 
                for(int i = 0; i < dealerCards.size(); i++) {
                    String card = dealerCards.get(i);
                    if(card.contains("ACE"))
                        return "hit";
                }
            return "stay";  
        }
        
        return "stay";
    }
    
    public int getScore() {
        DealerScore = 0;
        for (int i = 0; i < dealerCards.size(); i++) {
            DealerScore += convertCard(dealerCards.get(i));
        }
        
        return DealerScore;
    }
    
    public String dealerDecision() {
        
        int score = getScore();
        
        if(score < 17)
            return "hit";
        else if(score == 17)
            return ValidateSoft17();
        else if(score > 21) {
            Busted = true;
            return "stay";
        }
        else
            return "stay";
     }
 
    
}
