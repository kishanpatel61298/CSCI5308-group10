package dal.asdc.player;

import java.util.Map;

public interface IPlayer_intialiser {
    void intialise(int number_of_players);
    Map<String, Human_player> getPlayer_list();
}
