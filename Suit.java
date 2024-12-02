/**
 * Write a description of class Suit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public enum Suit  
{
    KEY("key"), BIRD("bird"), GATE("gate"), BUTTERFLY("butterfly");
    
    private String name;
    
    private Suit(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
}
