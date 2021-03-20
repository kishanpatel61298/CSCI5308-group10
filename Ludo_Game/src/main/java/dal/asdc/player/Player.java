package dal.asdc.player;

import dal.asdc.playing_pieces.Token;
import dal.asdc.game.*;

public class Player {

    private String colour;
    private int[][] position;


    private int roll;

    Make_Move make_move = new Make_Move();
    Dice dice = new Dice();

    public int roll(){
        roll= dice.roll_dice();
        return roll;
    }

    public void move(){
        if(roll==6){
            make_move.make_move();
        }
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
