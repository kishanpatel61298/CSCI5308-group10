package dal.asdc.game;

import java.util.Random;

public class Dice {
	 public int roll_dice(){
	        Random random = new Random();
	        int number = random.nextInt(6)+1;
	        return number;
	    }
}
