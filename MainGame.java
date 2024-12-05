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
    private Deck deck;
    private List<Card> deckOfCards;
    private int totalCards = 52; 
    private int cardsPlaced = 0; 
    private GreenfootImage Image;
    public String cardDeck[];
    private List<Card> cards;
    private String rank;
    private String suit;
    
    
    
    
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
        Button instructions = new Button("instructions", "instructions.png");
        instructions.scaleButton(220,220);
        addObject(instructions, 525, 365);
        

         //deck

        deck = new Deck();
        deck.shuffle();
        
        populateDeck();   
        addCardsToWorld();

        
        
        //check button
        Button done = new Button("Done?", "Done?.png");
        done.scaleButton(220,220);
        addObject(done, 76, 365);
        
        //music button
        Button Musicicon = new Button("", "Play.png");
        Musicicon.scaleButton(60,60);
        addObject(Musicicon, 30, 20);
        
        
        
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
    //public void cardPlaced() {
    //    cardsPlaced++;
    //    if (cardsPlaced == totalCards) {
    //        validatePlacement();
    //    }
    //}

    private boolean validatePlacement( ) {
        List<Card> cards = getObjects(Card.class); 
        boolean allCorrect= true ;
         
        if (cards.isEmpty()) {
            System.out.println("No cards found in the world.");
            return false;
        }
        for (Card card : cards) {
            String suit = card.getSuit(); 
            int x = card.getX();
            int y = card.getY();
            System.out.println("Checking card: Suit=" + suit + ", X=" + x);
            if (suit.equals("butterfly") && (x < 49 || x > 189)) {
                
                System.out.println("Butterfly card is NOT in the correct position.");
                allCorrect = false;
                
            } else if (suit.equals("bird") && (x < 193 || x > 333)) {
                
                System.out.println("Bird card is NOT in the correct position.");
                allCorrect = false;
                
            } else if (suit.equals("gate") && (x < 346 || x > 486)) {
                
                System.out.println("Gate card is NOT in the correct position.");
                allCorrect = false;
                
            } else if (suit.equals("key") && (x < 497 || x > 637)) {
                
                System.out.println("Key card is NOT in the correct position.");
                allCorrect = false;
                
            } 
            if (x == 295 && y == 290) {
                System.out.println("No cards found in the world.");
                return false; 
            }
            
        }
    
        return allCorrect;
        //Greenfoot.playSound("success.wav");
        //Greenfoot.playSound("boo.wav"); 
        //Greenfoot.setWorld(new Levels()); 
        
        
        
    }
    
    public void act(){
        drawBoundingBox("butterfly2.png", 76, 114); // Far left
        drawBoundingBox("bird2.png", 220, 114);    // Middle left
        drawBoundingBox("gate2.png", 372, 114);    // Middle right
        drawBoundingBox("key2.png", 524, 114);  // Far right
        if (Greenfoot.mouseClicked(null)) {
            Actor clicked = Greenfoot.getMouseInfo().getActor(); 

            if (clicked instanceof Button) { 
                Button button = (Button) clicked;

                if (button.getName().equals("Done?")) { 
                    boolean isCorrect = validatePlacement();
                    if (isCorrect== true) {
                        Greenfoot.playSound("applause_y.wav");
                        Greenfoot.setWorld(new Levels());
                    } else {
                        //cards are in the wrong position"
                        Greenfoot.playSound("boo.wav");
                    }
                }
            }
        }
       
    }
    
    
    public void drawBoundingBox( String imageFileName,int x, int y) {

        GreenfootImage image = getBackground();
        //GreenfootImage overlay = new GreenfootImage(imageFileName);
        int width = 85;
        int height = 140;
        
        image.setColor(Color.BLACK); // Bounding box color
        image.drawRect(x - width / 2, y - height / 2, width, height); // Draw the rectangle
        setBackground(image);
    }
}

