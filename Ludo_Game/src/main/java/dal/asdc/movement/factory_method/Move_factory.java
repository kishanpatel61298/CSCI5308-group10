package dal.asdc.movement.factory_method;
/**
 * @author Kishan Rakeshbhai Patel **/
import dal.asdc.movement.ICheck_Move;
import dal.asdc.movement.IMake_Move;

public abstract class Move_factory {
	
	public abstract ICheck_Move create_check_move(); 
	
	public abstract IMake_Move create_make_move();
	
}
