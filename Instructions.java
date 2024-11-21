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
    private String instructions;
    public GreenfootImage background;
    
    public Instructions(){
      background = new GreenfootImage(300,200);
      background.setColor(Color.WHITE);
      background.fill();
      background.setColor(Color.BLUE);
      instructions= "Hello My Name is";
      background.drawString(instructions,10,20);
      
      setImage(background);
      
      
      
      
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("X")){
            getWorld().removeObject(this);
        }
    }
}
