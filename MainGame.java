import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class MainGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainGame extends World
{
    private int level = 0;
    Deck deck;
    private List<Card> deckOfCards;
    private int totalCards = 52; 
    private int cardsPlaced = 0; 
    private GreenfootImage Image;
     /**
     * Constructor for objects of class MainGame.
     * 
     */
    public MainGame()
    {    
        
        super(600, 400, 1);  
        GreenfootImage background1 = new GreenfootImage("background1.png");
        background1.scale(600,400);
        setBackground(background1);
        

        //instructions button
        //Button instructions = new Button("instructions", "instructions.png");
        //instructions.scaleButton(220,220);
        //addObject(instructions, 525, 365);
        
        // deck

        Button instructions = new Button("Instructions", "instructions.png");

        instructions.scaleButton(220,220);
        addObject(instructions, 525, 365);
        deck = new Deck();
        deck.shuffle();
        addObject(deck, 50, 50);
        populateDeck();   
        addCardsToWorld();
        Card drawnCard = deck.drawCard();
        
        if (drawnCard != null) {
            addObject(drawnCard, 100, 100);
        }
        
        addObject(new Pile("Butterfly"), 76, 114);
        addObject(new Pile("Bird"), 220, 114);
        addObject(new Pile("Gate"), 372, 114);
        addObject(new Pile("Key"), 524, 114);
    }
    private void populateDeck() {
        deckOfCards = new ArrayList<>();
        
        for (String imageName : deck.cardDeck){
            Card card = new Card(imageName); 
            deckOfCards.add(card);          
        }
    }
    private void addCardsToWorld() {
        int x = 295;
        int y = 290;
        
        for (Card card : deckOfCards) {
           addObject(card, x, y); 
            
        }
        
    }
    public void cardPlaced() {
        cardsPlaced++;
        if (cardsPlaced == totalCards) {
            validatePlacement();
        }
    }

    private void validatePlacement() {
        for (Card card : getObjects(Card.class)) {
            String suit = card.getSuit();
            Pile correctPile = findPileForSuit(suit);

            
            if (correctPile == null || !isOverlapping(card, correctPile)){
                Greenfoot.playSound("boo.wav"); 
                return; 
            }else if(correctPile != null || isOverlapping(card, correctPile)){
                Greenfoot.playSound("applause_y.wav");
                Greenfoot.setWorld(new Levels()); 

            }
        }
        //Greenfoot.playSound("success.wav");
        //Greenfoot.setWorld(new Levels()); 
        
        
        
    }
    private Pile findPileForSuit(String suit) {
        for (Pile pile : getObjects(Pile.class)) {
            if (pile.getSuit().equals(suit)) {
                return pile; 
            }
        }
        return null; 
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
    
    public void act(){
        drawFLBoundingBox();// far left
        drawMLBoundingBox();//middle left
        drawMRBoundingBox();//middle right
        drawFRBoundingBox();//far right
    }
    
    public void drawFLBoundingBox() {
        GreenfootImage image = new GreenfootImage("butterfly2.png");
        int width = image.getWidth();
        int height = image.getHeight();
        int x = 76;
        int y =114;
        //image.setColor(Color.BLACK);
        //image.drawRect(x, y, width , height );
        //image.drawImage(image, x, y);
    }
    public void drawMLBoundingBox() {
        GreenfootImage image = new GreenfootImage("bird2.png");
        int width = image.getWidth();
        int height = image.getHeight();
        int x = 220;
        int y =114;
    }
    public void drawMRBoundingBox() {
        GreenfootImage image = new GreenfootImage("gate2.png");
        int width = image.getWidth();
        int height = image.getHeight();
        int x = 372;
        int y =114;
    }
    public void drawFRBoundingBox() {
        GreenfootImage image = new GreenfootImage("key2.png");
        int width = image.getWidth();
        int height = image.getHeight();
        int x = 524;
        int y =114;
    }
}
