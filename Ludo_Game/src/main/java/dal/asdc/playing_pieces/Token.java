package dal.asdc.playing_pieces;

public class Token {
    int x_coordinate_position;
    int y_coordinate_position;

    boolean is_token_base=true;
    String token_colour;

    public Token(String token_colour) {
        this.token_colour = token_colour;
    }

    public String get_token_colour() {
        return token_colour;
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
}
