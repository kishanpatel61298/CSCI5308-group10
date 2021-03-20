package dal.asdc.player;

import dal.asdc.playing_pieces.Token;
import dal.asdc.game.*;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String colour;
    private int[][] position;
    private boolean is_turn;
    List<Token> token_list= new ArrayList<>();
    private String name;
    private int user_id;

    private int roll;

    Make_Move make_move = new Make_Move();
    Dice dice = new Dice();

    public int roll(){
        roll= dice.roll_dice();
        return roll;
    }

    public void move(int token_number){
        if(roll==6){
            make_move.make_move(get_selected_token(token_number),roll);
        }
    }

    public Token get_selected_token(int token_number){
        return token_list.get(token_number);

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
}
