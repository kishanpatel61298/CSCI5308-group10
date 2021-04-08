package dal.asdc.player.Command_classes;

import dal.asdc.player.Human_player;
import dal.asdc.player.Player_command;
import dal.asdc.playing_pieces.*;

public class Yellow_token_command extends Player_command {

    private Human_player player;
    private final int[][] YELLOW_HOME_POSITION={{11,12},{11,11},{12,11},{12,12}};

    public Yellow_token_command(Human_player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.setPosition(YELLOW_HOME_POSITION);

        for(int i=0;i<4;i++){
            Token token = new Yellow_Token(i);
            player.set_selected_token(token);
        }
    }
}
