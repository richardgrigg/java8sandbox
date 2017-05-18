package uk.wrigglegriggle;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class DiceRollerUTest {

    private DiceRoller testObj = new DiceRoller();

    @Test
    public void testRollerRecordsEachRoll() throws Exception {
        int rolls = 40;
        testObj.roll( new Dice(10), rolls);
        Assert.assertEquals("Expected 40 rolls", rolls, testObj.getRolls().size() );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNumberOfSidesZeroProducesZeroRolls() {
        int sides = 0;
        testObj.roll(new Dice(sides), 40);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNumberOfSidesNegative() {
        int sides = -1;
        testObj.roll(new Dice(sides), 40);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNumberOfRollsLessThanOnce() {

        int rolls = 0;
        testObj.roll(new Dice(1), rolls);
    }


}