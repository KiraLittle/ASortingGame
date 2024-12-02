import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{
    private String name;
    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage startScreen = new GreenfootImage("StartScreen.png");
        startScreen.scale(600,400);
        setBackground(startScreen);
        
        Button Start = new Button("Start", "Start.png");
        Start.scaleButton(350,250);
        addObject(Start, 284, 332);
        
        Button instructions = new Button("instructions", "instructions.png");
        instructions.scaleButton(220,220);
        addObject(instructions, 525, 365);
        

    }
}