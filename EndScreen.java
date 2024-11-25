import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends World
{

    
    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
         GreenfootImage FinishGame = new GreenfootImage("FinishGame.png");
        FinishGame.scale(600,400);
        setBackground(FinishGame);
        
        Button reset = new Button("Reset", "reset.png");
        addObject(reset, 303, 334);
        
        Button instructions = new Button("instructions", "instructions.png");
        instructions.scaleButton(220,220);
        addObject(instructions, 525, 365);
        
    }
}
