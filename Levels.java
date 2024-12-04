import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Levels here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Levels extends World
{

    /**
     * Constructor for objects of class Levels.
     * 
     */
    public Levels()
    {    
        super(600, 400, 1);  
        GreenfootImage background1 = new GreenfootImage("background2.png");
        background1.scale(600,400);
        setBackground(background1);
    }
}
