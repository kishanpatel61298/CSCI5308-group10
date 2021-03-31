package dal.asdc.game;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import dal.asdc.token_movement.Dice;

public class DiceTest {

	@Test
    public void roll_dice_test(){
        Dice dice = new Dice();
        int number_test = dice.roll_dice();
        assertTrue(number_test>=0 && number_test<=6);

    }
}
