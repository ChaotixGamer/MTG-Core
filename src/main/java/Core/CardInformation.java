package Core;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by rayna on 11/24/2016.
 */
public class CardInformation
{
    public int cardInfoID;
    public boolean isReserved;

    public String cardName;
    public String cardColours;
    public String colourIdentity;
    public String manaCost;
    public String cardPower;
    public String cardToughness;
    public String cardType;
    public String cardText;
    public String convertedManaCost;
    public String cardLoyalty;

    public ArrayList<String> cardTypeList;
    public ArrayList<String> cardSuperTypes;
    public ArrayList<String> cardSubTypes;
    public ArrayList<Card> cardInstances;

    public HashMap<String, String> cardRulings;
    public HashMap<String, String> cardLegality;

    public CardInformation()
    {
        cardInfoID = -1;
        isReserved = false;
        cardName = "";
        cardColours = "";
        colourIdentity = "";
        manaCost = "";
        cardPower = "";
        cardToughness = "";
        cardType = "";
        cardText = "";
        convertedManaCost = "";
        cardLoyalty = "";

        cardTypeList = new ArrayList<String>();
        cardSuperTypes = new ArrayList<String>();
        cardSubTypes = new ArrayList<String>();
        cardInstances = new ArrayList<Card>();

        cardRulings = new HashMap<String, String>();
        cardLegality = new HashMap<String, String>();
    }

    public Constants.STATUS compareObjects(CardInformation newInfo)
    {
        int older = 0;
        int newer = 0;

        if(this.cardInfoID == -1 && newInfo.cardInfoID != -1)
            newer++;
        else if(this.cardInfoID != -1 && newInfo.cardInfoID == -1)
            older++;
        else if(this.cardInfoID != newInfo.cardInfoID)
            return Constants.STATUS.MISMATCH;

        if(this.cardColours.equals("") && !newInfo.cardColours.equals(""))
            newer++;
        else if(!this.cardColours.equals("") && newInfo.cardColours.equals(""))
            older++;
        else if(!this.cardColours.equals(newInfo.cardColours))
            return Constants.STATUS.MISMATCH;

        if(this.colourIdentity.equals("") && !newInfo.colourIdentity.equals(""))
            newer++;
        else if(!this.colourIdentity.equals("") && newInfo.colourIdentity.equals(""))
            older++;
        else if(!this.colourIdentity.equals(newInfo.colourIdentity))
            return Constants.STATUS.MISMATCH;

        if(this.manaCost.equals("") && !newInfo.manaCost.equals(""))
            newer++;
        else if(!this.manaCost.equals("") && newInfo.manaCost.equals(""))
            older++;
        else if(!this.manaCost.equals(newInfo.manaCost))
            return Constants.STATUS.MISMATCH;

        if(this.cardPower.equals("") && !newInfo.cardPower.equals(""))
            newer++;
        else if(!this.cardPower.equals("") && newInfo.cardPower.equals(""))
            older++;
        else if(!this.cardPower.equals(newInfo.cardPower))
            return Constants.STATUS.MISMATCH;

        if(this.cardToughness.equals("") && !newInfo.cardToughness.equals(""))
            newer++;
        else if(!this.cardToughness.equals("") && newInfo.cardToughness.equals(""))
            older++;
        else if(!this.cardToughness.equals(newInfo.cardToughness))
            return Constants.STATUS.MISMATCH;

        if(this.cardType.equals("") && !newInfo.cardType.equals(""))
            newer++;
        else if(!this.cardType.equals("") && newInfo.cardType.equals(""))
            older++;
        else if(!this.cardType.equals(newInfo.cardType))
            return Constants.STATUS.MISMATCH;

        if(this.cardText.equals("") && !newInfo.cardText.equals(""))
            newer++;
        else if(!this.cardText.equals("") && newInfo.cardText.equals(""))
            older++;
        else if(!this.cardText.equals(newInfo.cardText))
            return Constants.STATUS.MISMATCH;

        if(this.convertedManaCost.equals("") && !newInfo.convertedManaCost.equals(""))
            newer++;
        else if(!this.convertedManaCost.equals("") && newInfo.convertedManaCost.equals(""))
            older++;
        else if(!this.convertedManaCost.equals(newInfo.convertedManaCost))
            return Constants.STATUS.MISMATCH;

        if(this.cardLoyalty.equals("") && !newInfo.cardLoyalty.equals(""))
            newer++;
        else if(!this.cardLoyalty.equals("") && newInfo.cardLoyalty.equals(""))
            older++;
        else if(!this.cardLoyalty.equals(newInfo.cardLoyalty))
            return Constants.STATUS.MISMATCH;

        if(this.cardTypeList.size() < newInfo.cardTypeList.size())
            newer++;
        else if(this.cardTypeList.size() > newInfo.cardTypeList.size())
            older++;

        if(this.cardSuperTypes.size() < newInfo.cardSuperTypes.size())
            newer++;
        else if(this.cardSuperTypes.size() > newInfo.cardSuperTypes.size())
            older++;

        if(this.cardSubTypes.size() < newInfo.cardSubTypes.size())
            newer++;
        else if(this.cardSubTypes.size() > newInfo.cardSubTypes.size())
            older++;

        if(this.cardInstances.size() < newInfo.cardInstances.size())
            newer++;
        else if(this.cardInstances.size() > newInfo.cardInstances.size())
            older++;

        if(this.cardRulings.size() < newInfo.cardRulings.size())
            newer++;
        else if(this.cardRulings.size() > newInfo.cardRulings.size())
            older++;

        if(this.cardLegality.size() < newInfo.cardLegality.size())
            newer++;
        else if(this.cardLegality.size() > newInfo.cardLegality.size())
            older++;

        if(newer > older)
            return Constants.STATUS.NEWER;
        else if(newer < older)
            return Constants.STATUS.OLDER;
        else
            return Constants.STATUS.SAME;
    }

    public boolean updateInformation(CardInformation newObject)
    {
        // If the new object has an ID of something other than -1 then update it
        if(this.cardInfoID == -1 && !(newObject.cardInfoID == -1))
        {
            this.cardInfoID = newObject.cardInfoID;
        }

        if(this.cardName.equals(""))
            this.cardName = newObject.cardName;

        if(this.cardColours.equals(""))
            this.cardColours = newObject.cardColours;

        if(this.colourIdentity.equals(""))
            this.colourIdentity = newObject.colourIdentity;

        if(this.manaCost.equals(""))
            this.manaCost = newObject.manaCost;

        if(this.cardPower.equals(""))
            this.cardPower = newObject.cardPower;

        if(this.cardToughness.equals(""))
            this.cardToughness = newObject.cardToughness;

        if(this.cardType.equals(""))
            this.cardType = newObject.cardType;

        if(this.cardText.equals(""))
            this.cardText = newObject.cardText;

        if(this.convertedManaCost.equals(""))
            this.convertedManaCost = newObject.convertedManaCost;

        if(this.cardLoyalty.equals(""))
            this.cardLoyalty = newObject.cardLoyalty;

        for(String newType : newObject.cardTypeList)
        {
            if(!this.cardTypeList.contains(newType))
            {
                this.cardTypeList.add(newType);
            }
        }

        for(String newType : newObject.cardSuperTypes)
        {
            if(!this.cardSuperTypes.contains(newType))
            {
                this.cardSuperTypes.add(newType);
            }
        }

        for(String newType : newObject.cardSubTypes)
        {
            if(!this.cardSubTypes.contains(newType))
            {
                this.cardSubTypes.add(newType);
            }
        }

        for(Card newCard : newObject.cardInstances)
        {
            // If the card does not exist in the instances list then add it
            if(!this.cardInstances.contains(newCard))
            {
                this.cardInstances.add(newCard);
            }
        }

        return true;
    }


}