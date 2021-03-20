package dal.asdc.player;

public class Red_token_command extends Player_command {

    private Player player;
    private final int[][] RED_HOME_POSITION={{2,3},{3,3},{3,2},{2,2}};
    public Red_token_command(Player player) {
        this.player = player;
    }

    public void execute() {
        player.setPosition(RED_HOME_POSITION);
    }
}
