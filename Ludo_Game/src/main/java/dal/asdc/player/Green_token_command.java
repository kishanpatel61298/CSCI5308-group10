package dal.asdc.player;

public class Green_token_command extends Player_command{
    private Player player;
    private final int[][] GREEN_HOME_POSITION={{11,3},{12,3},{12,2},{11,2}};

    public Green_token_command(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.setPosition(GREEN_HOME_POSITION);
    }
}
