package MTGCore;

import java.util.HashMap;

/**
 * Created by rayna on 27/11/2016.
 * Purpose of this class is to create a HashMap for all colour combinations, rarities and border types.
 * This functions is used to keep the code seperate from other files and also to save time pulling this information
 * from the database. These tables are static and never altered (For the forseeable future)
 */
public class AutoGenerate
{
    private static HashMap<String, Integer> colorCombinations = null;
    private static HashMap<String, Integer> colorCombinationsCoded = null;
    private static HashMap<String, Integer> rarities = null;
    private static HashMap<String, Integer> borderTypes = null;
    private static HashMap<String, Integer> setTypes = null;

    public static HashMap<String, Integer> GenerateColourCombinationCodedMap()
    {
        if(colorCombinationsCoded == null || colorCombinationsCoded.size() < Constants.NUM_COLOUR_COMBINATIONS)
        {
            colorCombinationsCoded = new HashMap<>();

            colorCombinationsCoded.put("{W}", 1);
            colorCombinationsCoded.put("{U}", 2);
            colorCombinationsCoded.put("{B}", 3);
            colorCombinationsCoded.put("{R}", 4);
            colorCombinationsCoded.put("{G}", 5);
            colorCombinationsCoded.put("{W},{G}", 6);
            colorCombinationsCoded.put("{W},{B}", 7);
            colorCombinationsCoded.put("{W},{R}", 8);
            colorCombinationsCoded.put("{W},{U}", 9);
            colorCombinationsCoded.put("{U},{B}", 10);
            colorCombinationsCoded.put("{B},{R}", 11);
            colorCombinationsCoded.put("{B},{G}", 12);
            colorCombinationsCoded.put("{U},{R}", 13);
            colorCombinationsCoded.put("{U},{G}", 14);
            colorCombinationsCoded.put("{R},{G}", 15);
            colorCombinationsCoded.put("{W},{R},{G}", 16);
            colorCombinationsCoded.put("{W},{U},{B}", 17);
            colorCombinationsCoded.put("{U},{B},{R}", 18);
            colorCombinationsCoded.put("{B},{R},{G}", 19);
            colorCombinationsCoded.put("{W},{U},{G}", 20);
            colorCombinationsCoded.put("{W},{B},{G}", 21);
            colorCombinationsCoded.put("{U},{R},{G}", 22);
            colorCombinationsCoded.put("{W},{U},{R}", 23);
            colorCombinationsCoded.put("{W},{B},{R}", 24);
            colorCombinationsCoded.put("{U},{B},{G}", 25);
            colorCombinationsCoded.put("{W},{U},{B},{R}", 26);
            colorCombinationsCoded.put("{U},{B},{R},{G}", 27);
            colorCombinationsCoded.put("{B},{R},{G},{W}", 28);
            colorCombinationsCoded.put("{R},{G},{W},{U}", 29);
            colorCombinationsCoded.put("{G},{W},{U},{B}", 30);
            colorCombinationsCoded.put("{W},{U},{B},{R},{G}", 31);
            colorCombinationsCoded.put("", 33);

        }

        return colorCombinationsCoded;
    }

    public static HashMap<String, Integer> GenerateColourCombinationMap()
    {
        if(colorCombinations == null || colorCombinations.size() < Constants.NUM_COLOUR_COMBINATIONS)
        {
            colorCombinations = new HashMap<>();

            colorCombinations.put("White", 1);
            colorCombinations.put("Blue", 2);
            colorCombinations.put("Black", 3);
            colorCombinations.put("Red", 4);
            colorCombinations.put("Green", 5);
            colorCombinations.put("Selesnya", 6);
            colorCombinations.put("Orzhov", 7);
            colorCombinations.put("Boros", 8);
            colorCombinations.put("Azorius", 9);
            colorCombinations.put("Dimir", 10);
            colorCombinations.put("Rakdos", 11);
            colorCombinations.put("Golgari", 12);
            colorCombinations.put("Izzet", 13);
            colorCombinations.put("Simic", 14);
            colorCombinations.put("Gruul", 15);
            colorCombinations.put("Naya", 16);
            colorCombinations.put("Esper", 17);
            colorCombinations.put("Grixis", 18);
            colorCombinations.put("Jund", 19);
            colorCombinations.put("Bant", 20);
            colorCombinations.put("Abzan", 21);
            colorCombinations.put("Temur", 22);
            colorCombinations.put("Jeskai", 23);
            colorCombinations.put("Mardu", 24);
            colorCombinations.put("Sultai", 25);
            colorCombinations.put("Artifice", 26);
            colorCombinations.put("Chaos", 27);
            colorCombinations.put("Agression", 28);
            colorCombinations.put("Altruism", 29);
            colorCombinations.put("Growth", 30);
            colorCombinations.put("WUBRG", 31);
            colorCombinations.put("Colorless", 32);
            colorCombinations.put("", 33);
        }

        return colorCombinations;
    }

    public static HashMap<String, Integer> GenerateRarities()
    {
        if(rarities == null || rarities.size() < Constants.NUM_RARITIES)
        {
            rarities = new HashMap<>();

            rarities.put("Common", 1);
            rarities.put("Uncommon", 2);
            rarities.put("Rare", 3);
            rarities.put("Mythic Rare", 4);
            rarities.put("Special", 5);
            rarities.put("Basic Land", 6);
        }

        return rarities;
    }

    public static HashMap<String, Integer> GenerateBorderTypes()
    {
        if(borderTypes == null || borderTypes.size() < Constants.NUM_BORDERTYPES)
        {
            borderTypes = new HashMap<>();

            borderTypes.put("white", 1);
            borderTypes.put("black", 2);
            borderTypes.put("silver", 3);
        }

        return borderTypes;
    }

    public static HashMap<String, Integer> GenerateSetTypes()
    {
        if(setTypes == null || setTypes.size() < Constants.NUM_SETTYPES)
        {
            setTypes = new HashMap<>();

            setTypes.put("core",1);
            setTypes.put("expansion",2);
            setTypes.put("reprint",3);
            setTypes.put("box",4);
            setTypes.put("un",5);
            setTypes.put("from the vault",6);
            setTypes.put("premium deck",7);
            setTypes.put("duel deck",8);
            setTypes.put("starter",9);
            setTypes.put("commander",10);
            setTypes.put("planechase",11);
            setTypes.put("archenemy",12);
            setTypes.put("promo",13);
            setTypes.put("vanguard",14);
            setTypes.put("masters",15);
            setTypes.put("conspiracy",16);
        }

        return setTypes;
    }
}
