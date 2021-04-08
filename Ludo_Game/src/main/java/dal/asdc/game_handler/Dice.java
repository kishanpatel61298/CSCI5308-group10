package dal.asdc.game_handler;
/**
 * @author Kishan Rakeshbhai Patel **/
import java.util.Random;

public class Dice implements IDice{

	public int roll_dice(){
	        Random random = new Random();
	        int number = random.nextInt(6)+1;
	        return number;
	    }
}
