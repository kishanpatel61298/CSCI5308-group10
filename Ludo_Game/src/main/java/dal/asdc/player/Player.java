package dal.asdc.player;

import dal.asdc.movement.*;
import dal.asdc.playing_pieces.Token;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player extends Player_abstract{

    private String colour;
    private int[][] position;
    private boolean is_turn;
    List<Token> token_list= new ArrayList<>();
    private String name;
    private int user_id;
    private boolean is_done = false;
    private int roll;
    IMake_Move make_move = new Make_Move();
    Dice_user dice_user = Dice_user.instance();
    List<Player> all_player_list = new ArrayList<>();
    Player_intialiser intialiser;
    Map<String, Player> player_list= new HashMap<>();

    public Player(){

    }
    public Player(String colour){
        this.colour=colour;
    }
    public int roll(){
        roll= dice_user.roll_dice();
        return roll;
    }
    public List<Token> play(List<Token> token_list){

        player_list = intialiser.getPlayer_list();

        for (int i = 0; i < 4; i++) {
            all_player_list.add(player_list.get(i));
        }

        for (int i = 0; i < 4; i++) {
            make_move.play_move(token_list.get(i), roll() ,all_player_list);
        }

        return token_list;
    }
    public List<Token> get_all_tokens(){
    	return token_list;
    }

    public Token get_selected_token(int token_number){
        return token_list.get(token_number);
    }

    public void set_selected_token(Token token){
        token_list.add(token);
    }
    
    public void set_tokens(List<Token> four_tokens) {
    	token_list = four_tokens;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setPosition(int[][] position) {
        this.position = position;
    }

    public boolean get_is_done(){
        return is_done;
    }

    public void set_is_done(boolean is_done) {
        this.is_done = is_done;
    }

    public int[][] getPosition() {
        return position;
    }
}
