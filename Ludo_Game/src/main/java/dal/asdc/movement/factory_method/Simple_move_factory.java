package dal.asdc.movement.factory_method;
/**
 * @author Kishan Rakeshbhai Patel **/

import dal.asdc.movement.Check_Move;
import dal.asdc.movement.ICheck_Move;
import dal.asdc.movement.IMake_Move;
import dal.asdc.movement.Make_Move;

public class Simple_move_factory extends Move_factory {
	
	public ICheck_Move create_check_move() {
		return new Check_Move();
	}
	
	public IMake_Move create_make_move() {
		return new Make_Move();
	}
}
