import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import (name of file)
/**
 * Write a description of class Music here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Music extends Actor
{
    private GreenfootImage pause =new GreenfootImage("Pause");
    private GreenfootImage play = new GreenfootImage("Play");
    boolean isPressed;
    public void button(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        isPressed = false;
    }
    /**
     * music options:
     * 509126__freesamplemelodies__trap-melody.wav
     * 580835__northboi__shes-gone-rb-loop-126bpm-by-northboi.wav
     * 664888__yellowtree__rb-clean-guitar.wav
     */
    public void act()
    {
        GreenfootSound music = new GreenfootSound("664888__yellowtree__rb-clean-guitar.wav");
        music.playLoop();
        setImage(play);
        if(!isPressed && Greenfoot.mouseClicked(play)){
            setImage("Pause");
            music.stop();
        }else if(isPressed && Greenfoot.mouseClicked(pause)){
            setImage("Play");
            music.playLoop();
        }
        
    }
}
