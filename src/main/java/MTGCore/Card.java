package MTGCore;

/**
 * Created by rayna on 11/24/2016.
 */
public class Card
{
    public int cardID;
    public boolean isTimeShifted;
    public boolean isStarter;

    public String borderType;
    public String artistName;
    public String cardRarity;
    public String flavourText;
    public String cardNumber;

    public CardInformation cardInformation;
    public CardSet cardSet;

    public Card()
    {
        cardID = -1;
        isTimeShifted = false;
        isStarter = false;

        borderType = "black";
        cardRarity = "";
        artistName = "";
        flavourText = "";
        cardNumber = "";

        cardInformation = null;
        cardSet = null;
    }

    public Constants.STATUS compareObjects(Card newCard)
    {
        int newer = 0;
        int older = 0;

        if(this.cardID == -1 && newCard.cardID != -1)
            newer++;
        else if(this.cardID != -1 && newCard.cardID == -1)
            older++;
        else if(this.cardID != newCard.cardID)
            return Constants.STATUS.MISMATCH;

        if(this.isTimeShifted == false && newCard.isTimeShifted == true)
            newer++;

        if(this.isStarter == false && newCard.isStarter == true)
            newer++;

        if(borderType.equals("black") && !borderType.equals("black"))
            newer++;;

        if(this.cardNumber.equals("") && !newCard.cardNumber.equals(""))
            newer++;
        else if(!this.cardNumber.equals("") && newCard.cardNumber.equals(""))
            older++;
        else if(!this.cardNumber.equals(newCard.cardNumber))
            return Constants.STATUS.MISMATCH;

        if(this.cardRarity.equals("") && !newCard.cardRarity.equals(""))
            newer++;
        else if(!this.cardRarity.equals("") && newCard.cardRarity.equals(""))
            older++;
        else if(!this.cardRarity.equals(newCard.cardRarity))
            return Constants.STATUS.MISMATCH;

        if(this.artistName.equals("") && !newCard.artistName.equals(""))
            newer++;
        else if(!this.artistName.equals("") && newCard.artistName.equals(""))
            older++;
        else if(!this.artistName.equals(newCard.artistName))
            return Constants.STATUS.MISMATCH;

        if(this.flavourText.equals("") && !newCard.flavourText.equals(""))
            newer++;
        else if(!this.flavourText.equals("") && newCard.flavourText.equals(""))
            older++;
        else if(!this.flavourText.equals(newCard.flavourText))
            return Constants.STATUS.MISMATCH;

        if(this.cardInformation == null && newCard.cardInformation != null)
            newer++;
        else if(this.cardInformation != null && newCard.cardInformation == null)
            older++;
        else if (this.cardInformation != newCard.cardInformation)
            return Constants.STATUS.MISMATCH;

        if(this.cardSet == null && newCard.cardSet != null)
            newer++;
        else if(this.cardSet != null && newCard.cardSet == null)
            older++;
        else if (this.cardSet != newCard.cardSet)
            return Constants.STATUS.MISMATCH;

        if(newer > older)
            return Constants.STATUS.NEWER;
        else if(newer < older)
            return Constants.STATUS.OLDER;
        else
            return Constants.STATUS.SAME;
    }

    public boolean updateInformation(Card otherCard)
    {
        if(this.cardID == -1)
            this.cardID = otherCard.cardID;

        if(this.isTimeShifted != otherCard.isTimeShifted)
            this.isTimeShifted = otherCard.isTimeShifted;

        if(this.isStarter != otherCard.isStarter)
            this.isStarter = otherCard.isStarter;

        if(!this.borderType.equals(otherCard.borderType))
            this.borderType = otherCard.borderType;

        if(this.cardRarity.equals(""))
            this.cardRarity = otherCard.cardRarity;

        if(this.artistName.equals(""))
            this.artistName = otherCard.artistName;

        if(this.flavourText.equals(""))
            this.flavourText = otherCard.flavourText;

        if(this.cardInformation == null)
            this.cardInformation = otherCard.cardInformation;

        if(this.cardSet == null)
            this.cardSet = otherCard.cardSet;

        return true;
    }
}
