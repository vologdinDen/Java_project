public class Player_Computer_Hard extends Players{

    final int[] coordinate_int;

    private String good_choose;
    private String bad_choose;

    public Player_Computer_Hard(){
        this.coordinate_int = new int[2];

    }

    public String[][] make_move(String[][] field, String choose) {
        int score;
        int best_score = -99999;
        Game_Mechanic game_Object = new Game_Mechanic();
        String[][] field_1 = new String[3][3];
        for (int i = 0; i < 3; i++){
            System.arraycopy(field[i], 0, field_1[i], 0, 3);
        }

        if(choose.equals("X")){
            this.good_choose = "X";
            this.bad_choose = "0";
        }
        else{
            this.good_choose = "0";
            this.bad_choose = "X";
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(field[i][j].equals("_")){
                    field[i][j] = this.good_choose;
                    score = minimax(field, game_Object, 0, false);
                    field[i][j] = "_";
                    if(score > best_score){
                        best_score = score;
                        this.coordinate_int[0] = i;
                        this.coordinate_int[1] = j;
                    }
                }

            }

        }

        field_1[this.coordinate_int[0]][this.coordinate_int[1]] = this.good_choose;
        return field_1;
    }

    private int minimax(String[][] field, Game_Mechanic game_Object, int depth, boolean isMaximazing) {

        game_Object.set_field(field);
        if(game_Object.is_win() == 1 && !isMaximazing){
            return 1;
        }else if(game_Object.is_win() == 1 && isMaximazing){
            return -1;
        }else if(game_Object.is_win() == 0){
            return 0;
        }
        int best_score;
        if(isMaximazing){
            best_score = -999999999;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (field[i][j].equals("_")) {
                        field[i][j] = this.good_choose;
                        int score = minimax(field, game_Object, depth + 1, false);
                        field[i][j] = "_";
                        if (score > best_score) {
                            best_score = score;

                        }
                    }
                }
            }
        }
        else{
            best_score = 999999999;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (field[i][j].equals("_")) {
                        field[i][j] = this.bad_choose;
                        int score = minimax(field, game_Object, depth + 1, true);
                        field[i][j] = "_";
                        if (score < best_score) {
                            best_score = score;

                        }
                    }
                }
            }
        }
        return best_score;

    }

}
