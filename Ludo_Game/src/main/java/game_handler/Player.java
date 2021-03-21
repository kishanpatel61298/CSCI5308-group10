package game_handler;

import java.util.ArrayList;
import java.util.List;

import dal.asdc.game.Dice;
import dal.asdc.game.Make_Move;
import dal.asdc.playing_pieces.Blue_Token;
import dal.asdc.playing_pieces.Green_Token;
import dal.asdc.playing_pieces.Red_Token;
import dal.asdc.playing_pieces.Token;
import dal.asdc.playing_pieces.Yellow_Token;

public class Player {
	private String colour;
    private int[][] position;
    private boolean is_turn;
    List<Token> token_list= new ArrayList<>();
    private String name;
    private int user_id;

    private int roll;

    //Make_Move make_move = new Make_Move();
    Dice dice = new Dice();
    
    public Player(String token_colour) {
    	colour = token_colour;
		if(colour.equals("RED")) {
	    	for(int token_number = 0 ; token_number < 4 ; token_number++) {
	    		Token token = new Red_Token(token_number);
	    		token_list.add(token);
	    	}
		}else if(colour.equals("GREEN")) {
			for(int token_number = 0 ; token_number < 4 ; token_number++) {
	    		Token token = new Green_Token(token_number);
	    		token_list.add(token);
	    	}
    	}else if(colour.equals("BLUE")) {
    		for(int token_number = 0 ; token_number < 4 ; token_number++) {
	    		Token token = new Blue_Token(token_number);
	    		token_list.add(token);
	    	}
    	}else if(colour.equals("YELLOW")) {
    		for(int token_number = 0 ; token_number < 4 ; token_number++) {
	    		Token token = new Yellow_Token(token_number);
	    		token_list.add(token);
	    	}
    	}
    }

    public int roll(){
        roll= dice.roll_dice();
        return roll;
    }
    
    public List<Token> get_all_tokens(){
    	return token_list;
    }

    /*public void move(int token_number){
        if(roll==6){
            make_move.make_move(get_selected_token(token_number),roll);
        }
    }*/

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
