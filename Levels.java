import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class Levels here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Levels extends World
{

    
    Deck deck;
    private List<Card> deckOfCards;
    
    private int totalCards = 52; 
    private int cardsPlaced = 0; 
    private GreenfootImage Image;
    private int rank;
    
 
    public Levels()
    {    
        super(600, 400, 1);  
        GreenfootImage background1 = new GreenfootImage("background2.png");
        background1.scale(600,400);
        setBackground(background1);

        
        
        //instructions button
        Button instructions = new Button("instructions", "instructions.png");
        instructions.scaleButton(220,220);
        addObject(instructions, 525, 365);
        
        // deck
        deck = new Deck();
        deck.shuffle();
        
        
        populateDeck();   
        addCardsToWorld();
        Card drawnCard = deck.drawCard();
        if (drawnCard != null) {
            addObject(drawnCard, 100, 100);
        }
        
        //check button
        Button done = new Button("Done??", "Done?.png");
        done.scaleButton(220,220);
        addObject(done, 76, 365);
        
        //music button
        Button Musicicon = new Button("", "Play.png");
        Musicicon.scaleButton(60,60);
        addObject(Musicicon, 30, 20);
        
        
        //addObject(new Pile("Butterfly"), 76, 114);
        //addObject(new Pile("Bird"), 220, 114);
        //addObject(new Pile("Gate"), 372, 114);
        //addObject(new Pile("Key"), 524, 114);
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
        drawBoundingBox("butterfly2.png", 15, 176); // 1
        drawBoundingBox("bird2.png", 60, 145);    // 2
        drawBoundingBox("gate2.png", 103, 176);    // 3
        drawBoundingBox("key2.png", 147, 198);  // 4
        drawBoundingBox("butterfly2.png", 191, 168); // 5
        drawBoundingBox("bird2.png", 233, 141);    // 6
        drawBoundingBox("gate2.png", 278, 174);    // 7
        drawBoundingBox("key2.png", 323, 200);// 8
        drawBoundingBox("butterfly2.png", 366, 174); //9
        drawBoundingBox("bird2.png", 407, 146);    // 10
        drawBoundingBox("gate2.png", 451, 175);    // 11
        drawBoundingBox("key2.png", 495, 206);// 12
        drawBoundingBox("bird2.png", 539, 179);    // 13
        drawBoundingBox("gate2.png", 583, 148);    // 14
        
        
        
        }
    
    public void drawBoundingBox(String imageFileName, int x, int y) {
        GreenfootImage image = getBackground();
        GreenfootImage overlay = new GreenfootImage(imageFileName);
        int width = 42;
        int height = 74;
    
        image.setColor(Color.RED); // Bounding box color
        image.drawRect(x - width / 2, y - height / 2, width, height); // Draw the rectangle
        
        setBackground(image);

    }
}
