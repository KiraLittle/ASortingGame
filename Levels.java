import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
//shuffle
//import java.util.Collections;
/**
 * Write a description of class Levels here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Levels extends World
{

    
    private Deck deck;
    private List<Card> deckOfCards;
    
    private int totalCards = 52; 
    private int cardsPlaced = 0; 
    private GreenfootImage Image;
    private int rank;
    private static int level = 0;
    private static int max = 4;
    private int rankValue;
    
    private final int[][] boundingBoxCoordinates = {
    {15, 176}, {60, 145}, {103, 176}, {147, 198},
    {191, 168}, {233, 141}, {278, 174}, {323, 200},
    {366, 174}, {407, 146}, {451, 175}, {495, 206},
    {539, 179}, 
    };
 
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
        
        
        populateDeckForLevel(level);   
        addCardsToWorld();
        
        
        //check button
        Button done = new Button("Done??", "Done?.png");
        done.scaleButton(220,220);
        addObject(done, 76, 365);
        
        //music button
        Button Musicicon = new Button("Musicicon", "Play.png");
        Musicicon.scaleButton(60,60);
        addObject(Musicicon, 30, 20);
        
        
        //addObject(new Pile("Butterfly"), 76, 114);
        //addObject(new Pile("Bird"), 220, 114);
        //addObject(new Pile("Gate"), 372, 114);
        //addObject(new Pile("Key"), 524, 114);
    }
    


        
     
    private void populateDeckForLevel(int level) {
        deckOfCards = new ArrayList<>();
        
        String suit;
        if (level == 0) {
            suit = "butterfly";
        } else if (level == 1) {
            suit = "bird";
        } else if (level == 2) {
            suit = "gate";
        } else if(level ==3)  {
            suit = "key";
        }else{
            throw new IllegalStateException("Unexpected level: " + level);
        }
        
         for (int i = 2; i <= 14; i++) { 
            String rank;
            if (i == 11) {
                rank = "jack";
            } else if (i == 12) {
                rank = "queen";
            } else if (i == 13) {
                rank = "king";
            } else if (i == 14) {
                rank = "ace";
            } else {
                rank = String.valueOf(i);
            }
            Card card = new Card(rank, suit);
            deckOfCards.add(card);
        }
        
        //shuffle
        //Collections.shuffle(deckOfCards);
        for (Card card : deckOfCards) {
            System.out.println("Generated card: " + card.getSuit() + " " + card.getRank());
        }

    }
    private void addCardsToWorld() {
        for (int i = 0; i < deckOfCards.size() && i < boundingBoxCoordinates.length; i++) {
            Card card = deckOfCards.get(i);
            int x = boundingBoxCoordinates[i][0];
            int y = boundingBoxCoordinates[i][1];
            addObject(card, x, y);
    
            // Debugging output
            System.out.println("Placed card: " + card.getSuit() + " " + card.getRank() + " at (" + x + ", " + y + ")");
        }
    }
    public static void nextLevel() {
        level++; 
        if (level < max) {
            Greenfoot.setWorld(new Levels());
        } else if (level == max) {
            Greenfoot.setWorld(new EndScreen()); 
        }

        
    }
    

    private boolean validatePlacement() {
        List<Card> placedCards = getObjects(Card.class);
        boolean Correct = true;
        //user must reset entirly if order is wrong 
        placedCards.sort((c1, c2) -> Integer.compare(c1.getX(), c2.getX()));

        for (int i = 0; i < placedCards.size(); i++){
            Card card = placedCards.get(i);
            int[] expectedBox = boundingBoxCoordinates[i];
            int expectedX = expectedBox[0];
            int expectedY = expectedBox[1];
    
            
            int cardX = card.getX();
            int cardY = card.getY();
    
            if ((cardX < expectedX) || (cardX > expectedX) ) {
                System.out.println("Card " + card.getSuit() + card.getRank() + " is not in the correct box.");
                Correct = false ; 
            }
        }
    
        System.out.println("cards are correct");
        return Correct ;
    }
    
    private int getRankValue(String rank) {
        if(rank.equals("jack")){
            rankValue = 11;
            
        }else if (rank.equals("queen")){
            rankValue = 12;
            
        }else if (rank.equals("king")){
            rankValue = 13;
            
        }else if (rank.equals("ace")){ 
            rankValue = 14;
            
        }else {
            rankValue = Integer.parseInt(rank);
        }
        return rankValue;
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
        
        if (Greenfoot.mouseClicked(null)) {
            Actor clicked = Greenfoot.getMouseInfo().getActor();

            if (clicked instanceof Button) {
                Button button = (Button) clicked;
                if (button.getName().equals("Done??")) {
                    boolean isCorrect = validatePlacement();
                    if (isCorrect == true ) {
                        Greenfoot.playSound("applause_y.wav");
                        Levels.nextLevel(); 
                    } else {
                        Greenfoot.playSound("boo.wav");
                        System.out.println("not correct.");
                        }
                    }
            }
        }
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
