package Core;

import java.util.ArrayList;

/**
 * Created by rayna on 11/24/2016.
 */
public class CardSet
{
    public int setID;
    public String setCode;
    public String setName;
    public String releaseDate;
    public String setType;
    public String blockName;
    public String iconFileName;

    public ArrayList<Card> cardList;

    public CardSet()
    {
        setID = -1;
        setCode = "";
        setName = "";
        releaseDate = "";
        setType = "expansion";
        blockName = "";
        iconFileName = "";          // TO:DO Give a default file

        cardList = new ArrayList<Card>();
    }

    /*
        Compare this set with a new set provided.
        A set can be incomplete so there are multiple options
        If the older set does not have a release date, setType, blockName or fileName
        and the new set does then return NEWER. Same reversed except return OLDER.
        If both sets have values but they are different return MISMATCH
        Else return SAME
     */
    public Constants.STATUS compareObjects(CardSet newSet)
    {
        int newer = 0;
        int older = 0;

        if(this.setID == -1 && newSet.setID != -1)
            newer++;
        else if(this.setID != -1 && newSet.setID == -1)
            older++;
        else if(this.setID != newSet.setID)
            return Constants.STATUS.MISMATCH;

        if(this.setCode.equals("") && !newSet.setCode.equals(""))
            newer++;
        else if(!this.setCode.equals("") && newSet.setCode.equals(""))
            older++;
        else if(!this.setCode.equals(newSet.setCode))
            return Constants.STATUS.MISMATCH;

        if(this.setName.equals("") && !newSet.setName.equals(""))
            newer++;
        else if(!this.setName.equals("") && newSet.setName.equals(""))
            older++;
        else if(!this.setName.equals(newSet.setName))
            return Constants.STATUS.MISMATCH;

        if(this.releaseDate.equals("") && !newSet.releaseDate.equals(""))
            newer++;
        else if(!this.releaseDate.equals("") && newSet.releaseDate.equals(""))
            older++;
        else if(!this.releaseDate.equals(newSet.releaseDate))
            return Constants.STATUS.MISMATCH;

        if(this.setType.equals("") && !newSet.setType.equals(""))
            newer++;
        else if(!this.setType.equals("") && newSet.setType.equals(""))
            older++;
        else if(!this.setType.equals(newSet.setType))
            return Constants.STATUS.MISMATCH;

        if(this.blockName.equals("") && !newSet.blockName.equals(""))
            newer++;
        else if(!this.blockName.equals("") && newSet.blockName.equals(""))
            older++;
        else if(!this.blockName.equals(newSet.blockName))
            return Constants.STATUS.MISMATCH;

        if(this.iconFileName.equals("") && !newSet.iconFileName.equals(""))
            newer++;
        else if(!this.iconFileName.equals("") && newSet.iconFileName.equals(""))
            older++;
        else if(!this.iconFileName.equals(newSet.iconFileName))
            return Constants.STATUS.MISMATCH;

        if(this.cardList.size() < newSet.cardList.size())
            newer++;
        else if(this.cardList.size() > newSet.cardList.size())
            older++;

        if(newer > older)
            return Constants.STATUS.NEWER;
        else if(newer < older)
            return Constants.STATUS.OLDER;
        else
            return Constants.STATUS.SAME;
    }

    public boolean updateInformation(CardSet newObject)
    {
        if(this.setID == -1)
            this.setID = newObject.setID;

        if(this.setName.equals(""))
            this.setName = newObject.setName;

        if(this.setCode.equals(""))
            this.setCode = newObject.setCode;

        if(this.releaseDate.equals(""))
            this.releaseDate = newObject.releaseDate;

        if(this.setType.equals(""))
            this.setType = newObject.setType;

        if(this.blockName.equals(""))
            this.blockName = newObject.blockName;

        if(this.iconFileName.equals(""))
            this.iconFileName = newObject.iconFileName;

        for(Card newCard : newObject.cardList)
        {
            if(!this.cardList.contains(newCard))
                this.cardList.add(newCard);
        }

        return true;
    }
}
