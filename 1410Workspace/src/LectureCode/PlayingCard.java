import java.awt.*;

@SuppressWarnings("unused")
public class PlayingCard {

	
	private int suit;
	private int cardID; 
	private boolean isFaceUp;

    PlayingCard(int suit, int cardID, boolean b){
    	this.suit = suit;
    	this.cardID = cardID;
    	this.isFaceUp = b;
    	
    }
    PlayingCard(int suit, int cardID){
    	this(suit,cardID,false);
    }
    PlayingCard(){
    	this(1,1,false);
    }

    public int getCardSuit(){ //returns 1-4
    	return suit;
    }
    public int getCardValue(){ //returns 1-13, (i.e. Ace = 1)
    	return cardID;
    }
    public void setCardSuit(int suit){ //bogus suits should return false
    	this.suit = suit;
    }
    public void setCardValue(int cardID){ //bogus id's should return false
    	this.cardID = cardID;
    }
    
    public void setIsFaceUp(boolean b){
    	this.isFaceUp = b;
    }
    public boolean getIsFaceUp(){ //tells if the cards value and suit can be seen - initially the cards values cannot be seen
    	return isFaceUp;
    }
	
}



