package dal.asdc.player;

public class Blue_token_command extends Player_command {
    private Player player;
    private final int[][] BLUE_HOME_POSITION={{2,12},{2,11},{3,12},{3,11}};

    public Blue_token_command(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.setPosition(BLUE_HOME_POSITION);
    }
}
