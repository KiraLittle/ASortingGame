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
    public String suits[];
    public String ranks[];
    private List<Card> cards;
    
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
        shuffle();
    }
      private String[] generateCardDeck() {
        suits = new String[]{"butterfly", "bird", "gate", "key"};
        ranks = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "ace", "jack", "queen", "king"};
        List<String> deck = new ArrayList<>();

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(suit + rank);
            }
        }

        return deck.toArray(new String[0]);
    }

    //private void populateDeck(){
    //    for (String cardData : cardDeck) {
    //        String suit = getSuitFromCardName(cardData);
    //        String rank = getRankFromCardName(cardData);
    //        Card card = new Card(rank, suit);
     //       cards.add(card);
       // }
    //}

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
     private String getRankFromCardName(String cardName) {
       
        if (cardName.endsWith("1")){
            return "1";
        }else if (cardName.endsWith("2")){
            return "2";
        }else if (cardName.endsWith("3")){ 
            return "3";
        }else if (cardName.endsWith("4")){
            return "4";
        }else if (cardName.endsWith("5")){
            return "5";
        }else if (cardName.endsWith("6")){
            return "6";
        }else if (cardName.endsWith("7")){ 
            return "7";
        }else if (cardName.endsWith("8")){
            return "8";
        }else if (cardName.endsWith("9")){
            return "9";
        }else if (cardName.endsWith("10")){ 
            return "10";
        }else if (cardName.endsWith("queen")){
            return "queen";
        }else if (cardName.endsWith("king")){
            return "king";
        }else if (cardName.endsWith("ace")){
            return "ace";
        }else if (cardName.endsWith("jack")){ 
            return "jack";
        }
        
        return "unknown";
    }

    @Override
    public void act(){
        
    }
}

