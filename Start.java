import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends World
{

    /**
     * Constructor for objects of class Start.
     * 
     */
    public Start()
    {    
        super(600, 400, 1);
        GreenfootImage startScreen = new GreenfootImage("StartScreen.png");
        setBackground(startScreen);
        startScreen.scale(600,400);
    
    }
}
