package dal.asdc.login_register;

import org.mindrot.jbcrypt.BCrypt;

import dal.asdc.dao.Player_dao;
import dal.asdc.model.Player;

public class Register {
 public boolean Register(Player player) {
    Player_dao plyr_dao = new Player_dao();
    
    //To fetch plain password and set encrypted password
    player.setPlayer_password(generate_hash_password(player.getPlayer_password()));    
    Player fatched_player = plyr_dao.filter_by_emailid(player.getPlayer_email());
    if(fatched_player==null) {
    	plyr_dao.save_record(player);
    	return true;
    }
    else {
    	return false;
    }		 
 }
 
 //To encrypt password
 private String generate_hash_password(String plain_password){
		return BCrypt.hashpw(plain_password, BCrypt.gensalt());
	}
}