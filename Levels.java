import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;


/**
 * Write a description of class Levels here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Levels extends World
{


    /**

    private int level = 0;
    Deck deck;
    private List<Card> deckOfCards;
     /**

     * Constructor for objects of class Levels.
     * 
     */
    public Levels()
    {    


        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

        super(600, 400, 1);  
        GreenfootImage background1 = new GreenfootImage("background2.png");
        background1.scale(600,400);
        setBackground(background1);

        
        Button instructions = new Button("instructions", "instructions.png");
        instructions.scaleButton(220,220);
        addObject(instructions, 525, 365);
        deck = new Deck();
        populateDeck();   
        addCardsToWorld();
        
    }
    private void populateDeck() {
        deckOfCards = new ArrayList<>();
        
        for (String imageName : deck.cardDeck){
            Card card = new Card(imageName); 
            deckOfCards.add(card);          
        }
    }
    private void addCardsToWorld() {
        int x = 295;
        int y = 325;
        ///int spacing = 40; 
        
        for (Card card : deckOfCards) {
           addObject(card, x, y); 
            ///x += spacing;
            ///if (x > getWidth() - spacing) { 
                ///x = 50; 
                ///y += spacing; 
           /// }
        }
        

    }
}
