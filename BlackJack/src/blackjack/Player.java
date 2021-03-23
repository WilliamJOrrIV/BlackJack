/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.ArrayList;
import java.util.List;
import java.util.*;


/**
 *
 * @author wjorr
 */
public class Player {
    private String PlayerName;
    private int PlayerScore;
    public List<String> playerCards = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    public boolean Busted = false;
    public int playerBet;
    public int playerChips;
    public boolean doubled = false;
    
    public Player(String Name , int chips) {
       PlayerName = Name;
       PlayerScore = 0;
       playerChips = chips;
    }
    
    public void addCard(String Card) {
        this.playerCards.add(Card);
        
    }
    
    public int getScore() {
        PlayerScore = 0;
        for(int i = 0; i < playerCards.size(); i++){
            PlayerScore += convertCard(playerCards.get(i));
        }
        
        return PlayerScore;
    }
    
    public void getBet() {
    
        System.out.println("How much would you like to bet?");
        playerBet = Integer.parseInt(scan.nextLine());
        if(playerBet > playerChips) {
            System.out.println("You do not have the chips for that bet!");
            getBet();
        }
        else if(playerBet <= 0) {
            System.out.println("Bet can not be negative or zero");
            getBet();
    }
        else
            playerChips -= playerBet;
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
    
    public void show() {
        for(int i = 0; i < playerCards.size(); i++) {
            System.out.println(playerCards.get(i));
        }
    
    }
    
    public void clearScore() {
        PlayerScore = 0;
        doubled = false;
        playerCards.clear();
    }
    
    public String CanDouble(String DealerCard , int score) {
    
        if(playerBet > playerChips) {
            System.out.println("You do not have the chips to bet this amount!");
            decision(DealerCard , score);
            return "stay";
        }
        else 
            playerBet += playerBet;
            return "hit";
    }
    
    public boolean checkBlackJack(int score) {
        if(score == 21)
            return true;
        else 
            return false;
    }
    
    public String decision(String DealersShownCard , int score) {
        
        if(score > 21) {
            System.out.println("You have Busted!");
            Busted = true;
            return "stay";
        }
        
        if(doubled == true) {
            System.out.println("Your score after doubling is " + score);
            return "stay";
        }
        System.out.println("Dealer is showing " + DealersShownCard + " and your score is " + score);
        System.out.println("If you would like to hit, enter hit. If you would like to stay enter stay. If you would like to double down enter double.");
        
        String input = scan.nextLine();
        
        if(input.contains("hit")) 
            return "hit";
        else if(input.contains("double")) {
            return CanDouble(DealersShownCard, score);
        }
        else if(input.contains("stay"))
            return "stay";
        else 
            System.out.println("Invalid option");
            decision(DealersShownCard , score);
        
        return "hit";
    }
    
    public void payOut() {
    
        System.out.println("You have won " + playerBet + " chips");
        playerChips += (playerBet*2);
        
        
    }
    
    public void tie() {
        playerChips += playerBet;
        System.out.println("You have pushed with the dealer! Bet has been returned.");
    }
       
}
