package dal.asdc.player;

public class Player_factory_normal extends Player_factory{
    @Override
    public Player_abstract create_aggressive_computer_player() {
        return new Aggressive_computer_player();
    }

    @Override
    public Player_abstract create_easy_computer_player() {
        return new Easy_computer_player();
    }

    @Override
    public Player_abstract create_human_player() {
        return new Player();
    }

    @Override
    public IPlayer_intialiser create_player_intialiser() {
        return new Player_intialiser();
    }
}
