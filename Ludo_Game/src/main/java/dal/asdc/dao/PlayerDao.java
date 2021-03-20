package dal.asdc.dao;

import org.springframework.data.repository.CrudRepository;

import dal.asdc.model.Player;

public interface PlayerDao extends CrudRepository<Player,Integer>{
	
}
