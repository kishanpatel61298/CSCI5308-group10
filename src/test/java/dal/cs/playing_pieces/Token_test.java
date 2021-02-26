package dal.cs.playing_pieces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

class Token_test {

    @Test
    void et_token_colour_test() {
        Token token = new Token("blue");
        Assertions.assertEquals(token.get_token_colour(),"blue");
    }
}