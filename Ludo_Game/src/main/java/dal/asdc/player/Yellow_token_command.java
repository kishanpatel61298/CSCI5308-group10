package dal.asdc.player;

public class Yellow_token_command extends Player_command {

    private Player player;
    private final int[][] YELLOW_HOME_POSITION={{11,12},{11,11},{12,11},{12,12}};

    public Yellow_token_command(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.setPosition(YELLOW_HOME_POSITION);
    }
}
