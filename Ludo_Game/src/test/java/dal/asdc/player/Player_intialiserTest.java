package dal.asdc.player;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Player_intialiserTest {
    @Test
    void intialise_test() {
        Player_intialiser player_intialiser = new Player_intialiser();
        player_intialiser.intialise(4);

        Map<String, Player> player_list= new HashMap<>();
        player_list = player_intialiser.getPlayer_list();

        for (int i=0;i<player_list.size();i++){
            System.out.println(player_list.get(String.valueOf(i)).getColour());
        }

        Player red_player = player_list.get("0");
        int [][] position = red_player.getPosition();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(position[i][j]);
            }

        }
    }
}