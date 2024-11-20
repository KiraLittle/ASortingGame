import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class done here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class done extends World
{

    /**
     * Constructor for objects of class done.
     * 
     */
    public done()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        GreenfootImage FinishGame = new GreenfootImage("FinishGame.png");
        setBackground(FinishGame);
        FinishGame.scale(600,400);
        
    }
}
