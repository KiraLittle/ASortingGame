import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private String name;
    private String imagePic;
    private GreenfootImage pause =new GreenfootImage("Pause.png");
    private GreenfootImage play = new GreenfootImage("Play.png");
    boolean isPressed;
    private GreenfootImage frontImage;
    public Button(String name,String imagePic){
        this.name = name;
        this.imagePic = imagePic;
        buttonImage();
        scaleButton(300,200);
    }
    public void act()
    {
       if(Greenfoot.mouseClicked(this)){
           World world = getWorld();
           if(name.equals("Start")){
               Greenfoot.setWorld(new MainGame());

            }else if(name.equals("Instructions")){
                Instructions instructions = new Instructions();
                world.addObject(instructions, world.getWidth()/2,world.getHeight()/2);

        
           
            }else if (name.equals("Reset")){
                Greenfoot.setWorld(new StartScreen());
            }//else if (name.equals("Done?")){
                //Greenfoot.setWorld(new Levels()); 
                
            //}
            else if (name.equals("Musicicon")){
                Music icon = new Music(); 
           
            
            }
        } 
    }
    private void buttonImage(){
        GreenfootImage image = new GreenfootImage(imagePic);
        setImage(image);
        
        
    }
    public String getName() {
        return name;
    }
    
    public void scaleButton(int width,int height){
        GreenfootImage image = getImage();
        image.scale(width,height);
        setImage(image);
    }
}
