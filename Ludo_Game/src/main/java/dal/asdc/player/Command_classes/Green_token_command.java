package dal.asdc.player.Command_classes;


import dal.asdc.player.Human_player;
import dal.asdc.player.Player_command;
import dal.asdc.playing_pieces.*;

public class Green_token_command extends Player_command {
    private Human_player player;
    private final int[][] GREEN_HOME_POSITION={{11,3},{12,3},{12,2},{11,2}};

    public Green_token_command(Human_player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.setPosition(GREEN_HOME_POSITION);

        for(int i=0;i<4;i++){
            Token token = new Green_Token(i);
            player.set_selected_token(token);
        }
    }
}
