package dal.asdc.movement;

public abstract class Dice_user {
    private static Dice_user unique_instace = null;

    public static Dice_user instance(){
        if( null == unique_instace){
            unique_instace = new Dice();
        }

        return unique_instace;
    }

    public abstract int roll_dice();
}

