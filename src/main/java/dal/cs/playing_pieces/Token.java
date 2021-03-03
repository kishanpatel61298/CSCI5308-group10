package dal.cs.playing_pieces;

public class Token {
    int position ;
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

    public int get_position() {
        return position;
    }

    public void set_position(int position) {
        this.position = position;
    }

    public int move_token(){

        int roll=6;


        return position+roll;
    }
}
