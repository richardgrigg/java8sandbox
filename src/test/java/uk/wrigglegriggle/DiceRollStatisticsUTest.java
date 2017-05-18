package uk.wrigglegriggle;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class DiceRollStatisticsUTest {

    @Test
    public void testMultipleRollsOfTheSameNumber() throws Exception {
        List<Integer> rolls = Arrays.asList(1,1,3,3,4,4,4,5,5,5,5,6);

        DiceRollStatistics stats = new DiceRollStatistics(rolls, new Dice(6) );

        Map<Integer, Integer> expected = new TreeMap<Integer,Integer>();
        expected.put(1,2);
        expected.put(2,0); //Was never rolled
        expected.put(3,2);
        expected.put(4,3);
        expected.put(5,4);
        expected.put(6,1);

        Map<Integer, Integer> actual = stats.getStatistics();

        assertEquals(expected.get(1), actual.get(1));
        assertEquals(expected.get(2), actual.get(2));
        assertEquals(expected.get(3), actual.get(3));
        assertEquals(expected.get(4), actual.get(4));
        assertEquals(expected.get(5), actual.get(5));
        assertEquals(expected.get(6), actual.get(6));

    }

    @Test
    public void testStatsHaveRowForEverySideOfTheDiceUsedToRoll() {
        List<Integer> rolls = Arrays.asList(1); //uk.wrigglegriggle.Dice only rolled once
        DiceRollStatistics stats = new DiceRollStatistics(rolls, new Dice(10) );
        Assert.assertEquals("Size of stats is incorrect", 10, stats.getStatistics().size() );
    }

}