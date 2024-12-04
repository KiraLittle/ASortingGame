import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card extends Actor
{
    private String rank;
    private String suit;
    private GreenfootImage backImage;
    private String imageFileName;
    public Card(String rank, String suit){
        this.rank = rank;
        this.suit = suit;
        
        
        backImage = new GreenfootImage("images/backimage0.png");
        backImage.scale(120,180);
        //setImage("backimage0.png");
        
    }
    
    public Card(String suit){
        String rank = ""+suit.charAt(suit.length()-1);
        this.rank = rank;
        this.suit = suit;
        
        
        backImage = new GreenfootImage("images/backimage0.png");
        backImage.scale(85,140);
        setImage(backImage);
        
        
    }
    public String getSuit(){
        return suit;
    }
    public String getRank(){
        return rank;
    }
    
    public void flip(){
        //backImage.scale(20,80);
        setImage("images/"+suit+".png");
    }
    /**
     * Act - do whatever the Card wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    //public Card(String imageFileName) {
    //    this.imageFileName = imageFileName; 
    //}

    /*@Override
    public void addedToWorld(World world) {
        setImage(imageFileName); 
    }*/
}
