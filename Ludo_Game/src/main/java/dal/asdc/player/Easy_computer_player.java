package dal.asdc.player;

import dal.asdc.movement.Dice_user;
import dal.asdc.movement.IMake_Move;
import dal.asdc.movement.Make_Move;
import dal.asdc.playing_pieces.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Easy_computer_player extends Player_abstract{

    private String colour;
    private Token token;
    private int roll;
    private int[][] token_path;
    private int[][] safe_box;
    private int[][] token_position;
    private int  token_index_on_path;
    private int[][] home_position;
    IMake_Move iMake_move;
    Dice_user dice_user = Dice_user.instance();

    List<Token> token_list= new ArrayList<>();
    List<Token> all_tokens = new ArrayList<>();
    List<Player> all_players = new ArrayList<>();

    public List<Token> play(List<Token> token_list){
        iMake_move = new Make_Move();
        roll = dice_user.roll_dice();
        Random random = new Random();

        int number = random.nextInt(4)+1;

        if( number == 1 ){
            for ( int i=0 ; i < 4 ; i++){
                if(token_list.get(i).is_home() && 6 == roll ){
                    token=check_if_home(iMake_move ,token_list.get(i));
                    iMake_move.move_token_out_of_home(token);
                    return token_list;
                }
            }
        }
        else {
            for (int i = 0; i < 4; i++) {
                if(is_move_possible(token_list.get(i) , roll , iMake_move )) {
                    token_path = token_list.get(i).get_token_path();
                    safe_box = token_list.get(i).get_safe_boxes();
                    token_index_on_path = -1;
                    token_position = token_list.get(i).get_coordinate_position();
                    token_index_on_path = iMake_move.get_index_of_token_on_path(token_position,token_path);

                    all_tokens = iMake_move.add_all_tokens_other_than_selected_into_list(token_list.get(i),all_players);

                    if((token_index_on_path+roll) < token_path.length){
                        int[][] after_move_position = {{token_path[token_index_on_path+roll][0],token_path[token_index_on_path+roll][1]}};
                        boolean is_defeat = iMake_move.is_defeat_move_or_not(after_move_position,token_list.get(i),all_tokens);
                        boolean is_safe = iMake_move.is_move_into_safe_box_or_not(after_move_position,safe_box);

                        if ( number ==2 ){
                            if(token_index_on_path+roll == token_path.length){
                               token_list =  iMake_move.move_token_in_winning_square(token_list.get(i));
                                return token_list;
                            }
                        }
                        else if ( number == 3){
                            if(is_defeat && !is_safe){
                                 token_list = iMake_move.move_token_to_defeat_opponent(token_list.get(i),after_move_position);
                                 return token_list;
                            }
                        }
                        else{
                            token_list = iMake_move.move_token_on_normal_path(token_list.get(i),after_move_position);
                            return token_list;
                        }
                    }
                }

            }


        }

    return null;

    }

    private Token check_if_home(IMake_Move iMake_move,Token token){
        List<Token> temp_return = new ArrayList<>();
        temp_return= iMake_move.move_token_out_of_home(token);
        token = temp_return.get(0);
        return token;

    }

    private Boolean is_move_possible(Token token,int roll,IMake_Move iMake_move){
        return iMake_move.check_moving_path(token,roll);

    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setHome_position(int[][] home_position) {
        this.home_position = home_position;
    }
}