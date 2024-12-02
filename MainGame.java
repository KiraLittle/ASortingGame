import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainGame extends World
{
private int level = 0;



    /**
     * Constructor for objects of class MainGame.
     * 
     */
    public MainGame()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);  
        GreenfootImage background1 = new GreenfootImage("background1.png");
        background1.scale(600,400);
        setBackground(background1);
        
        Button instructions = new Button("instructions", "instructions.png");
         instructions.scaleButton(220,220);
        addObject(instructions, 525, 365);
        
    }
}
