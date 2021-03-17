package dal.asdc.playing_pieces;

public class Token {
    int x_coordinate_position;
    int y_coordinate_position;
    private boolean takenOut;

    boolean is_token_base=true;
    String token_colour;

    public Token(String token_colour) {
        this.token_colour = token_colour;
    }

    public String get_token_colour() {
        return token_colour;
    }

    public boolean isTakenOut() {
        return takenOut;
    }

    public void setTakenOut(boolean takenOut) {
        this.takenOut = takenOut;
    }

    public void set_token_colour(String token_colour) {
        this.token_colour = token_colour;
    }

    public int getX_coordinate_position() {
        return x_coordinate_position;
    }

    public void setX_coordinate_position(int x_coordinate_position) {
        this.x_coordinate_position = x_coordinate_position;
    }

    public int getY_coordinate_position() {
        return y_coordinate_position;
    }

    public void setY_coordinate_position(int y_coordinate_position) {
        this.y_coordinate_position = y_coordinate_position;
    }

    public int move_token_x_coordinate(int roll){
        x_coordinate_position=x_coordinate_position+roll;

        return x_coordinate_position;
    }

    public int move_token_y_coordinate(int roll){
        y_coordinate_position=y_coordinate_position+roll;

        return y_coordinate_position;
    }

    public boolean is_move_possible(int roll){
        if(roll==6){
            for (int i=0;i<4;i++){
                if(takenOut){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean take_piece_out(){
        if(takenOut==false){
            return false;
        }

        takenOut=true;
        return true;
    }

    public boolean can_piece_take_out(){
        if (takenOut){
            return false;
        }

        return false;
    }
}
