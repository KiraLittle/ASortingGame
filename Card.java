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
    private GreenfootImage frontImage;
    boolean isFlipped = false;
    public Card(String rank, String suit){
        this.rank = rank; 
        this.suit = suit;
        
        
        
        frontImage = new GreenfootImage("images/"+suit+rank+".png");
        frontImage.scale(85,140);
        //backImage = new GreenfootImage("images/backimage0.png");
        //backImage.scale(120,180);
        setImage(frontImage);
        
    }
    
    public Card(String suit){
        String rank = ""+suit.charAt(suit.length()-1);
        this.rank = rank;
        this.suit = suit;
        
        
        frontImage = new GreenfootImage("images/"+suit+".png");
        frontImage.scale(85,140);
        setImage(frontImage);
        
        
    }
    public String getSuit(){
        return suit;
        }
    public String getRank(){
        return rank;
    }
    
    
    /**
     * Act - do whatever the Card wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.mouseDragEnded(this)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX(), mouse.getY());
        }else if(Greenfoot.mouseDragEnded(this)) {
            checkPlacement();
        }
    }
    private void checkPlacement() {
        World world = getWorld();
        for (Pile pile : world.getObjects(Pile.class)) {
            
            if (isOverlapping(this, pile)) {
                
                if (pile.getSuit().equals(this.suit)) {
                    Greenfoot.playSound("correct.wav"); 
                    return; 
                } else {
                    Greenfoot.playSound("error.wav"); 
                    resetPosition(); 
                    return; 
                    }
                }
            }
        resetPosition();
        }
    private boolean isOverlapping(Actor card, Actor pile) {
        
        int cardLeft = card.getX() - card.getImage().getWidth() / 2;
        int cardRight = card.getX() + card.getImage().getWidth() / 2;
        int cardTop = card.getY() - card.getImage().getHeight() / 2;
        int cardBottom = card.getY() + card.getImage().getHeight() / 2;
    
        int pileLeft = pile.getX() - pile.getImage().getWidth() / 2;
        int pileRight = pile.getX() + pile.getImage().getWidth() / 2;
        int pileTop = pile.getY() - pile.getImage().getHeight() / 2;
        int pileBottom = pile.getY() + pile.getImage().getHeight() / 2;
    
        
        return cardRight > pileLeft && cardLeft < pileRight && cardBottom > pileTop && cardTop < pileBottom;
        }
    private void resetPosition() {
        setLocation(getX(), getY()); 
    }
}
