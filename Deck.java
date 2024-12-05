import greenfoot.*;  
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Write a description of class Deck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Deck extends Actor
{
    public String cardDeck[];
    private List<Card> cards;
    public String suits[];
    public String ranks[];
    
    public Deck(){
        cardDeck = new String[]{"butterfly2","bird2”,”gate2","key2","key3","gate3", "bird3","butterfly3","butterfly4","bird4", "gate4","key4", 
        "key5","gate5","bird5", "butterfly5","butterfly6","bird6", "gate6","key6","key7", "key8", "gate7", "gate8","bird7", "bird8","butterfly7", 
        "butterfly8","butterfly9", "butterfly10", "butterflyace","bird9", "bird10","gate9", "gate10","key9", "key10", "birdace", "gateace", 
        "keyace","keyjack", "keyqueen", "keyking","gatejack","birdjack",   "butterflyjack","butterflyqueen","birdqueen","gatequeen", 
        "butterflyking", "gateking", "birdking"
        };
         
        
        cardDeck = generateCardDeck(); 
        cards = new ArrayList<>();
        //populateDeck();
        //shuffle();
    }
    public String[] generateCardDeck() {
        suits = new String[]{"butterfly", "bird", "gate", "key"};
        ranks = new String[]{"2","3","4","5","6","7","8","9","10","jack","queen","king","ace"};
        List<String> deck = new ArrayList<>();
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(suit + rank);
            }
        }
        

        return deck.toArray(new String[0]);
    }



    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    public void shuffle(){
        Collections.shuffle(cards); 
    }

    public Card drawCard(){
        if (!cards.isEmpty()){
            return cards.remove(0); 
        } 
        ///else the deck is empty
        return null; 
    }
    public void resetDeck() {
        cards.clear();
        //populateDeck();
        shuffle();
    }
    private String getSuitFromCardName(String cardName) {
        
        if (cardName.startsWith("butterfly")){
            return "butterfly";
        }else if (cardName.startsWith("bird")){
            return "bird";
        }else if (cardName.startsWith("gate")){ 
            return "gate";
        }else if (cardName.startsWith("key")){
            return "key";
        }
        return "Unknown";
    }
     

    @Override
    public void act(){
        
    }
}

