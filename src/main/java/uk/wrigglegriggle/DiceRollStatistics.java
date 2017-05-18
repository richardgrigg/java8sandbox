package uk.wrigglegriggle;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DiceRollStatistics {

    private Map<Integer, Integer> statistics;


    public DiceRollStatistics(List<Integer> rolls, Dice dice) {
        statistics = new TreeMap<Integer, Integer>();

        //Initialise rolls and assume that there is an entry for every potential side of the uk.wrigglegriggle.Dice to simplify retrieval
        for(int i = 1; i <= dice.getNumberOfSides(); i++) {
            statistics.put(i,0);
        }

        calculateStatistics(rolls);
    }

    private Map<Integer,Integer> calculateStatistics(List<Integer> diceRolls) {
        for(int key: diceRolls) {
            int newKeyValue = getKeyNewValue(key);
            statistics.put(key, newKeyValue);
        }
        return statistics;
    }

    public Map<Integer,Integer> getStatistics() {
        Map<Integer, Integer> copyOfStatistics = new TreeMap<Integer, Integer>();
        copyOfStatistics.putAll(statistics);
        return copyOfStatistics;
    }


    private int getKeyNewValue(int key) {
        int oldValue = statistics.get(key);
        int newValue = oldValue + 1;
        return newValue;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        int counter = 0;
        for(Integer roll: statistics.keySet()) {
            counter += 1;
            sb.append(roll + ":" + statistics.get(roll));


            if(counter < statistics.size() ) {
                sb.append(",");
            }
        }

        return sb.toString();
    }

}
