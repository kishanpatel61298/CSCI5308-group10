package dal.asdc.movement;
/**
 * @author Kishan Rakeshbhai Patel **/
import java.util.Random;

public class Dice extends Dice_user{



	public int roll_dice(){
	        Random random = new Random();
	        int number = random.nextInt(6)+1;
	        return number;
	    }
}
