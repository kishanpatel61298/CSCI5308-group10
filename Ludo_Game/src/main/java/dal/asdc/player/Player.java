package dal.asdc.player;

import dal.asdc.playing_pieces.Blue_Token;
import dal.asdc.playing_pieces.Green_Token;
import dal.asdc.playing_pieces.Red_Token;
import dal.asdc.playing_pieces.Token;
import dal.asdc.playing_pieces.Yellow_Token;
import dal.asdc.game.*;


import java.util.ArrayList;
import java.util.List;

public class Player {

    private String colour;
    private int[][] position;
    private boolean is_turn;
    List<Token> token_list= new ArrayList<>();
    private String name;
    private int user_id;
    private boolean is_done = false;
    private int roll;
    IMake_Move make_move = new Make_Move();
    Dice dice = new Dice();

    public Player() {
    	
    }
    
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

}
