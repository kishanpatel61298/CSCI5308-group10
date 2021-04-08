package dal.asdc.player;

import dal.asdc.playing_pieces.Token;

import java.util.List;

public abstract class Player {
    public abstract List<Token> play(List<Token> tokenList);
}
