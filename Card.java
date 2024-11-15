import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card extends Actor
{
    private int rank;
    private Suit suit;
    private GreenfootImage backImage;
    
    public Card(int rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
        
        backImage = new GreenfootImage(suit.getName()+rank+".png");
        backImage.scale(200,300);
        setImage(backImage);
    }
    /**
     * Act - do whatever the Card wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
