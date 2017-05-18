package uk.wrigglegriggle;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;


public class DiceRoller {
    private SecureRandom randomNumbers;
    private List<Integer> diceRolls;

    public DiceRoller() {
        diceRolls = new ArrayList<Integer>();
        randomNumbers = new SecureRandom();
    }

    public List<Integer> roll(Dice dice, int times) {
        if(times < 1) {
            throw new IllegalArgumentException("Cannot throw a dice less than once");
        }

        for(int i = 1; i <= times; i++) {
            int random  = randomNumbers.nextInt(dice.getNumberOfSides() ); // returns numbers in a range of 0 - (sides -1)
            int diceRoll = random +1;
            diceRolls.add(diceRoll);
        }
        return diceRolls;
    }

    public List<Integer> getRolls() {
        List<Integer> copyOfRolls = new ArrayList<Integer>();
        copyOfRolls.addAll(diceRolls);
        return copyOfRolls;
    }

    public void print() {
        int counter = 0;
        for(Integer roll: diceRolls) {
            counter += 1;
            System.out.print(roll);

            if(counter < diceRolls.size() ) {
                System.out.println(",");
            }
        }

    }

}
