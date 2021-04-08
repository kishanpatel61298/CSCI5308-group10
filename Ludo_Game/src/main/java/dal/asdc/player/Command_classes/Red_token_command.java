package dal.asdc.player.Command_classes;
import dal.asdc.player.Human_player;
import dal.asdc.player.Player_command;
import dal.asdc.playing_pieces.*;

public class Red_token_command extends Player_command {

    private Human_player player;
    private final int[][] RED_HOME_POSITION={{2,3},{3,3},{3,2},{2,2}};
    public Red_token_command(Human_player player) {
        this.player = player;
    }

    public void execute() {
        player.setPosition(RED_HOME_POSITION);

        for(int i=0;i<4;i++){
            Token token = new Red_Token(i);
            player.set_selected_token(token);
        }
    }
}
