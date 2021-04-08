package dal.asdc.login_register.interfaces;

import dal.asdc.model.Player;
import dal.asdc.model.interfaces.IPlayer;

public interface ILogin {
	public Player login(IPlayer player);
}
