package Core;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by rayna on 11/25/2016.
 */
public class CardDataManager
{
    // Set Code is used for map
    private HashMap<String, CardSet> setMap;

    // Core.Card name is used for map
    private HashMap<String, CardInformation> cardInformationMap;

    // SetCode_CardName is used for map
    private HashMap<String, Card> cardMap;

    /*
        List of currently loaded in card types.
        Every new card loaded in fill these (If loaded from DB will include ID)
        Integer will default to -1 unless its been loaded from the DB
     */
    private HashMap<String, Integer> cardTypes;
    private HashMap<String, Integer> cardSuperTypes;
    private HashMap<String, Integer> cardSubTypes;
    private HashMap<String, Integer> setBlocks;
    private HashMap<String, Integer> artists;
    private HashMap<String, Integer> colourCombinations;
    private HashMap<String, Integer> colourCombinationsCoded;
    private HashMap<String, Integer> rarities;
    private HashMap<String, Integer> borderTypes;
    private HashMap<String, Integer> setTypes;

    public CardDataManager()
    {
        setMap = new HashMap<>();
        cardInformationMap = new HashMap<>();
        cardMap = new HashMap<>();

        setBlocks = new HashMap<>();
        cardTypes = new HashMap<>();
        cardSuperTypes = new HashMap<>();
        cardSubTypes = new HashMap<>();
        artists = new HashMap<>();

        colourCombinations = AutoGenerate.GenerateColourCombinationMap();
        colourCombinationsCoded = AutoGenerate.GenerateColourCombinationCodedMap();
        rarities = AutoGenerate.GenerateRarities();
        borderTypes = AutoGenerate.GenerateBorderTypes();
        setTypes = AutoGenerate.GenerateSetTypes();
    }

    public boolean doesSetBlockExist(String type, Integer id)
    {
        // Check to see if card type exists
        if(setBlocks.containsKey(type))
        {
            // If the entered ID is -1 then we do not care if its been loaded from DB
            // In this case return true immediately
            if(id.equals(-1))
            {
                return true;
            }
            // If ID is not -1 then compare it to map. Return true if they match
            else if(id.equals(setBlocks.get(type)))
            {
                return true;
            }
            // Core.Card type does exist but IDs do not match. Return false
            else
            {
                return false;
            }
        }

        return false;
    }

    public boolean doesTypeExist(String type, Integer id)
    {
        // Check to see if card type exists
        if(cardTypes.containsKey(type))
        {
            // If the entered ID is -1 then we do not care if its been loaded from DB
            // In this case return true immediately
            if(id.equals(-1))
            {
                return true;
            }
            // If ID is not -1 then compare it to map. Return true if they match
            else if(id.equals(cardTypes.get(type)))
            {
                return true;
            }
            // Core.Card type does exist but IDs do not match. Return false
            else
            {
                return false;
            }
        }

        // Core.Card type does not exist
        return false;
    }

    public boolean doesSuperTypeExist(String type, Integer id)
    {
        // Check to see if card type exists
        if(cardSuperTypes.containsKey(type))
        {
            // If the entered ID is -1 then we do not care if its been loaded from DB
            // In this case return true immediately
            if(id.equals(-1))
            {
                return true;
            }
            // If ID is not -1 then compare it to map. Return true if they match
            else if(id.equals(cardSuperTypes.get(type)))
            {
                return true;
            }
            // Core.Card type does exist but IDs do not match. Return false
            else
            {
                return false;
            }
        }

        // Core.Card type does not exist
        return false;
    }

    public boolean doesSubTypeExist(String type, Integer id)
    {
        // Check to see if card type exists
        if(cardSubTypes.containsKey(type))
        {
            // If the entered ID is -1 then we do not care if its been loaded from DB
            // In this case return true immediately
            if(id.equals(-1))
            {
                return true;
            }
            // If ID is not -1 then compare it to map. Return true if they match
            else if(id.equals(cardSubTypes.get(type)))
            {
                return true;
            }
            // Core.Card type does exist but IDs do not match. Return false
            else
            {
                return false;
            }
        }

        // Core.Card type does not exist
        return false;
    }

    public boolean doesArtistExist(String name, Integer id)
    {
        // Check to see if artist exists
        if(artists.containsKey(name))
        {
            // If the entered ID is -1 then we do not care if its been loaded from DB
            // In this case return true immediately
            if(id.equals(-1))
            {
                return true;
            }
            // If ID is not -1 then compare it to map. Return true if they match
            else if(id.equals(artists.get(name)))
            {
                return true;
            }
            // Core.Card type does exist but IDs do not match. Return false
            else
            {
                return false;
            }
        }

        // Core.Card type does not exist
        return false;
    }


    public boolean doesSetExist(String setCode)
    {
        // Check if setCode is present in map at all
        if(setMap.containsKey(setCode))
        {
            return true;
        }

        // Return 0 if does not exist
        return false;
    }

    public boolean doesCardDataExist(String cardName) { return cardInformationMap.containsKey(cardName); }
    public boolean doesCardExist(String setCode, String cardName) { return cardMap.containsKey((setCode + "_" + cardName)); }

    public boolean doesColourComboExist(String colours) { return colourCombinations.containsKey(colours); }
    public boolean doesColourComboCodedExist(String colours) { return colourCombinationsCoded.containsKey(colours); }
    public boolean doesRarityExist(String rarity) { return rarities.containsKey(rarity); }
    public boolean doesBorderExist(String type) { return borderTypes.containsKey(type); }

    public CardSet getCardSet(String setCode) { return setMap.getOrDefault(setCode, null); }
    public int getCardSetSize() { return setMap.size(); }
    public ArrayList<CardSet> getAllCardSets() { return new ArrayList<>(setMap.values());}

    public CardInformation getCardInformation(String cardName) { return cardInformationMap.getOrDefault(cardName, null); }
    public int getCardInformationSize() { return cardInformationMap.size(); }
    public ArrayList<CardInformation> getAllCardInformations() { return new ArrayList<>(cardInformationMap.values()); }

    public Card getCard(String setCode, String cardName) { return cardMap.getOrDefault((setCode + "_" + cardName), null); }
    public int getCardListSize() { return cardMap.size(); }
    public ArrayList<Card> getAllCards() { return new ArrayList<>(cardMap.values()); }

    public int getBlockID(String type) { return setBlocks.getOrDefault(type, -1); }
    public int getBlockListSize() { return setBlocks.size(); }
    public ArrayList<String> getAllBlockNames() { return new ArrayList<>(setBlocks.keySet());}
    public ArrayList<Integer> getAllBlockIDs() { return new ArrayList<>(setBlocks.values()); }
    public HashMap<String, Integer> getBlockNameMap() { return setBlocks; }

    public int getCardTypeID(String type) { return cardTypes.getOrDefault(type, -1); }
    public int getCardTypeListSize() { return cardTypes.size(); }
    public ArrayList<String> getAllCardTypes() { return new ArrayList<>(cardTypes.keySet());}
    public ArrayList<Integer> getAllCardTypeIDs() { return new ArrayList<>(cardTypes.values()); }
    public HashMap<String, Integer> getCardTypeMap() { return cardTypes; }

    public int getCardSuperTypeID(String type) { return cardSuperTypes.getOrDefault(type, -1); }
    public int getCardSuperTypeListSize() { return cardSuperTypes.size(); }
    public ArrayList<String> getAllCardSuperTypes() { return new ArrayList<>(cardSuperTypes.keySet()); }
    public ArrayList<Integer> getAllCardSuperTypeIDs() { return new ArrayList<>(cardSuperTypes.values()); }
    public HashMap<String, Integer> getCardSuperTypeMap() { return cardSuperTypes; }

    public int getCardSubTypeID(String type) { return cardSubTypes.getOrDefault(type, -1); }
    public int getCardSubTypeListSize() { return cardSubTypes.size(); }
    public ArrayList<String> getAllCardSubTypes() { return new ArrayList<>(cardSubTypes.keySet()); }
    public ArrayList<Integer> getAllCardSubTypeIDs() { return new ArrayList<>(cardSubTypes.values()); }
    public HashMap<String, Integer> getCardSubTypeMap() { return cardSubTypes; }

    public int getArtistID(String name) { return artists.getOrDefault(name, -1); }
    public int getArtistListSize() { return artists.size(); }
    public ArrayList<String> getAllArtists() { return new ArrayList<>(artists.keySet()); }
    public ArrayList<Integer> getAllArtistIDs() { return new ArrayList<>(artists.values()); }
    public HashMap<String, Integer> getArtistMap() { return artists; }

    public int getColourCombinationID(String colours) { return colourCombinations.getOrDefault(colours, -1); }
    public ArrayList<String> getAllColourCombinations() { return new ArrayList<>(colourCombinations.keySet());}
    public ArrayList<Integer> getAllColourCombinationIDs() { return new ArrayList<>(colourCombinations.values()); }
    public HashMap<String, Integer> getColourCombinationMap() { return colourCombinations; }

    public int getColourCombinationCodedID(String colours) { return colourCombinationsCoded.getOrDefault(colours, -1); }
    public ArrayList<String> getAllColourCombinationsCoded() { return new ArrayList<>(colourCombinationsCoded.keySet());}
    public ArrayList<Integer> getAllColourCombinationCodedIDs() { return new ArrayList<>(colourCombinationsCoded.values()); }
    public HashMap<String, Integer> getColourCombinationCodedMap() { return colourCombinationsCoded; }

    public int getRarityID(String rarity) { return rarities.getOrDefault(rarity, -1); }
    public ArrayList<String> getAllRarities() { return new ArrayList<>(rarities.keySet()); }
    public ArrayList<Integer> getAllRartityIDs() { return new ArrayList<>(rarities.values()); }
    public HashMap<String, Integer> getRarityMap() { return rarities; }

    public int getBorderTypeID(String border) { return borderTypes.getOrDefault(border, -1); }
    public ArrayList<String> getAllBorderTypes() { return new ArrayList<>(borderTypes.keySet()); }
    public ArrayList<Integer> getAllBorderTypeIDs() { return new ArrayList<>(borderTypes.values()); }
    public HashMap<String, Integer> getBorderTypeMap() { return borderTypes; }

    public int getSetTypeID(String setType) { return setTypes.getOrDefault(setType, -1); }
    public ArrayList<String> getAllSetTypes() { return new ArrayList<>(setTypes.keySet()); }
    public ArrayList<Integer> getAllSetTypeIDs() { return new ArrayList<>(setTypes.values()); }
    public HashMap<String, Integer> getSetTypeMap() { return setTypes; }

    public boolean addSet(CardSet newSet)
    {
        if(doesSetExist(newSet.setCode))
        {
            CardSet oldSet = setMap.get(newSet.setCode);

            Constants.STATUS status = oldSet.compareObjects(newSet);

            if(status == Constants.STATUS.OLDER)
            {
                oldSet.updateInformation(newSet);
                newSet = oldSet;
            }
            else if(status == Constants.STATUS.NEWER)
            {
                newSet.updateInformation(oldSet);
            }
            else if(status == Constants.STATUS.MISMATCH)
                return false;
        }

        addSetBlock(newSet.blockName, -1);

        for(Card newCard : newSet.cardList)
        {
            addCard(newCard, newCard.cardInformation.cardName, newSet.setCode);
        }

        setMap.put(newSet.setCode, newSet);

        return true;
    }

    public boolean addCardInfo(CardInformation newCard)
    {
        // Try and add all types to maps
        for(String type : newCard.cardTypeList)
        {
            addCardType(type, -1);
        }

        // Try and add all super types to maps
        for(String type : newCard.cardSuperTypes)
        {
            addCardSuperType(type, -1);
        }

        // Try and add all sub types to maps
        for(String type : newCard.cardSubTypes)
        {
            addCardSubType(type, -1);
        }

        if(doesCardDataExist(newCard.cardName))
        {
            CardInformation oldCard = cardInformationMap.get(newCard.cardName);

            Constants.STATUS status = oldCard.compareObjects(newCard);

            if(status == Constants.STATUS.OLDER)
            {
                oldCard.updateInformation(newCard);
                cardInformationMap.put(oldCard.cardName, oldCard);
            }
            else if(status == Constants.STATUS.NEWER)
            {
                newCard.updateInformation(oldCard);
                cardInformationMap.put(newCard.cardName, newCard);
            }
            else if(status == Constants.STATUS.MISMATCH)
                return false;
        }
        else
        {
            cardInformationMap.put(newCard.cardName, newCard);
        }

        return true;
    }

    public boolean addCard(Card newCard, String cardName, String setCode)
    {
        // If card exists already then do not add it
        if(doesCardExist(setCode, cardName))
        {
            Card oldCard = getCard(setCode, cardName);

            Constants.STATUS status = oldCard.compareObjects(newCard);

            if(status == Constants.STATUS.OLDER)
            {
                oldCard.updateInformation(newCard);
                newCard = oldCard;
            }
            else if(status == Constants.STATUS.NEWER)
            {
                newCard.updateInformation(oldCard);
            }
            else if(status == Constants.STATUS.MISMATCH)
            {
                /*
                    We can have a mismatch if the card has multiple card numbers (i.e land or alternate art).
                    If the card number is different then we can add it to the card map with its card number
                */
                if(!newCard.cardNumber.equals(oldCard.cardNumber))
                {
                    // Add card information first
                    addCardInfo(newCard.cardInformation);

                    // Add artist to map
                    addArtist(newCard.artistName, -1);

                    cardMap.put((setCode + "_" + cardName + "_" + newCard.cardNumber), newCard);

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }

        // Add card information first
        addCardInfo(newCard.cardInformation);

        // Add artist to map
        addArtist(newCard.artistName, -1);

        // Put card into map
        cardMap.put((setCode + "_" + cardName), newCard);
        return true;
    }

    public boolean addSetBlock(String block, int id)
    {
        // If type already exists then do not add it return false
        if(doesSetBlockExist(block,id))
            return false;
        else
        {
            setBlocks.put(block,id);
            return true;
        }
    }

    public boolean addCardType(String type, int id)
    {
        // If type already exists then do not add it return false
        if(doesTypeExist(type,id))
            return false;
        else
        {
            cardTypes.put(type,id);
            return true;
        }
    }

    public boolean addCardSuperType(String type, int id)
    {
        if(doesSuperTypeExist(type, id))
            return false;
        else
        {
            cardSuperTypes.put(type, id);
            return true;
        }
    }

    public boolean addCardSubType(String type, int id)
    {
        if(doesSubTypeExist(type, id))
            return false;
        else
        {
            cardSubTypes.put(type, id);
            return true;
        }
    }

    public boolean addArtist(String name, int id)
    {
        if(doesArtistExist(name, id))
            return false;
        else
        {
            artists.put(name,id);
            return true;
        }
    }
}
