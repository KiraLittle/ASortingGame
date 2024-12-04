import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class Pile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pile extends Actor
{
    private String suit; 
    private List<Card> cards;
    private GreenfootImage pileImage;
    public Pile(String suit) {
        this.suit = suit;
        cards = new ArrayList<>();
         
    }
    public String getSuit(){
        return suit;
        }

    public void addCard(Card card) {
        if (card.getSuit().equals(this.suit)) {
            cards.add(card);
            Greenfoot.playSound("applause_y.wav"); 
        } else {
            Greenfoot.playSound("boo.wav"); 
        }
    }
    public boolean contains(Card card) {
        return cards.contains(card);
    }
    public List<Card> getCards() {
        return cards;
    }
}
