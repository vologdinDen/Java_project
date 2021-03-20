public class Player_Computer_Medium extends Players{
    final int[] coordinate_int;
    private String[][] field_1;

    public Player_Computer_Medium(){
        this.coordinate_int = new int[2];
        this.field_1 = new String[3][3];
    }

    public String[][] make_move(String[][] field, String choose) {
        Game_Mechanic game_Object = new Game_Mechanic();
        this.field_1 = field;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(field[i][j].equals("_")){
                    if(this.check("X", i, j, game_Object)){
                        field[i][j] = choose;
                        return field;
                    }
                    else if(this.check("0", i, j, game_Object)){
                        field[i][j] = choose;
                        return field;
                    }
                }
            }
        }
        while(true){

            this.coordinate_int[0] = (int)(Math.random() * 3);
            this.coordinate_int[1] = (int)(Math.random() * 3);


            if(field[this.coordinate_int[0]][this.coordinate_int[1]].equals("_")){
                field[this.coordinate_int[0]][this.coordinate_int[1]] = choose;
                break;
            }

        }
        return field;
    }

    private boolean check(String choose,int i, int j, Game_Mechanic game_Object){
        this.field_1[i][j] = choose;
        game_Object.set_field(this.field_1);
        if(game_Object.is_win() == 1){
            return true;
        }
        this.field_1[i][j] = "_";
        return false;
    }
}
