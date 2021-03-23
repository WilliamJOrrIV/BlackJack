/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Scanner;

/**
 *
 * @author wjorr
 */
public class BlackJack {
    
    Scanner scan = new Scanner(System.in);
    
    public boolean GameDecision(int playerChips) {
        
           if(playerChips < 1) {
               System.out.println("You do not have the minimum balance to play");
               return false;
           }
        
           System.out.println("Would you like to play again? Yes or No");
            
           String again = scan.nextLine();
                
            if(again.contains("yes"))
                return true;
            else if(again.contains("no"))
                return false;
            else
                System.out.println("Invalid Response");
                GameDecision(playerChips);
    
            return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BlackJack jack = new BlackJack();
        boolean PlayGame = true;
        
        Player player1 = new Player("Billy" , 10000); 
        Dealer dealer = new Dealer();
        
        
        
        while(PlayGame == true) {
            
            Deck test = new Deck();
            System.out.println(player1.playerChips + " available to bet");
            player1.getBet();
        
            for(int i = 0; i < 2; i++) {
                player1.addCard(test.pop());
                dealer.addCard(test.pop());
        
            }
        
            if(player1.checkBlackJack(player1.getScore()) == true) {
                System.out.println("BLACKJACK!!");
            }
            else if(dealer.checkBlackJack(dealer.getScore()) == true)
                System.out.println("Dealer wins with blackjack");
            else {
                while(player1.decision(dealer.showCard(), player1.getScore()) != "stay") {
                player1.addCard(test.pop());
                }
       
                while(dealer.dealerDecision() != "stay") {
                    if(player1.Busted == true)
                    break;
                else
                    System.out.println("Dealer has " + dealer.getScore());
                    dealer.addCard(test.pop());
                    String card = dealer.dealerCards.get(dealer.dealerCards.size() - 1);
                    System.out.println(card);
                }
            }
    
            if(player1.Busted == true) 
                ;
            else if(dealer.Busted == true) {
                System.out.println("Dealer has busted! You have won!");
                player1.payOut();
            }
            else if(player1.getScore() == dealer.getScore())
                player1.tie();
            else 
                if(dealer.getScore() > player1.getScore())
                    System.out.println("Dealer has won with " + dealer.getScore());
                else if (dealer.getScore() == player1.getScore()) 
                    System.out.println("You have pushed with the dealer");
                else {
                    System.out.println("You have beat the dealer with " + player1.getScore());
                    player1.payOut();
                }
            
        int chips = player1.playerChips;
        player1.clearScore();
        dealer.clearScore();
        PlayGame = jack.GameDecision(chips);           
        }
        
    }
}
