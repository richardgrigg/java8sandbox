package uk.wrigglegriggle;

import org.junit.Test;

import java.util.List;

public class DiceRollingITest {

    @Test
    public void test() {
        //New 20 sided dice
        Dice dice = new Dice(20);
        DiceRoller roller = new DiceRoller();

        List<Integer> rolls = roller.roll(dice, 5);
        DiceRollStatistics stats = new DiceRollStatistics(rolls, dice);
        roller.print();
        System.out.println();
        stats.getStatistics();
        System.out.println( stats.toString() );

    }


}
