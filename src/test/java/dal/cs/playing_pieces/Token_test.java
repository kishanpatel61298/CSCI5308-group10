package dal.cs.playing_pieces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

class Token_test {

    @Test
    void get_token_colour_test() {
        Token token = new Token("blue");
        Assertions.assertEquals(token.get_token_colour(),"blue");
    }

    @Test
    void move_token_test() {
        Dice_mock dice_mock = new Dice_mock();
        int roll=dice_mock.roll_dice();
        Token token = new Token("blue");
        int position= token.get_position();

        Assertions.assertEquals(token.move_token(),position+roll);

    }
}