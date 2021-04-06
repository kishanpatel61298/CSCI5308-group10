package dal.asdc.player;

public abstract class Player_factory {
    public abstract Player_abstract create_aggressive_computer_player();
    public abstract Player_abstract create_easy_computer_player();
    public abstract Player_abstract create_human_player();
}
