import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends Actor
{
    private String instructionsText;
    public GreenfootImage background;

    public Instructions(){
        instructionsText = "Welcome to the Card Sorting Game!\n\n" +
        "Objective:\n" +
        "Sort the cards by suit and then by rank.\n\n" +
        "How to Play:\n" +
        "1. Click 'Start' to begin.\n" +
        "2. Sort the cards into 4 piles based on their suit.\n" +
        "3. Then, sort each suit from highest to lowest rank.\n\n" +
        "Controls:\n" +
        "Click and drag cards to sort them.\n\n" +
        "Game Over:\n" +
        "The game ends when all suits are sorted in order from highest to lowest rank.\n\n" +
        "To Exit Instructions:\n" +
        "Press the 'X' key to close the instructions screen.\n\n" +
        "Good Luck and Have Fun!\n\n" +
        "We hope you enjoy the game and learn about sorting algorithms!\n";
        createInstrutions();

    }

    public void createInstrutions()
    {
        background = new GreenfootImage(500,400);
        background.setColor(Color.WHITE);
        background.fill();
        background.setColor(Color.BLACK);

        background.drawString(instructionsText,10,20);

        setImage(background);

      
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("X")){
            getWorld().removeObject(this);
        }
    }
}
