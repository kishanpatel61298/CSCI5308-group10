package dal.cs.playing_pieces;

import java.util.*;


public class Dice_mock {
     public int roll_dice(){
         return new Random().nextInt(6)+1;
     }
}
