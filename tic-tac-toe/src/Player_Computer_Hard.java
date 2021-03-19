public class Player_Computer_Hard extends Players{

    private int[] coordinate_int;

    private String good_choose;
    private String bad_choose;
    private int number_move = 1;
    private int[][] array_move;

    public Player_Computer_Hard(){
        this.coordinate_int = new int[2];
        this.array_move = new int[3][3];
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.array_move[i][j] = 0;
            }
        }
    }

    public String[][] make_move(String[][] field, String choose) {
        int score;
        int best_score = -99999;
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.array_move[i][j] = 0;
            }
        }
        Game_Mechanic game_Object = new Game_Mechanic();
        String[][] field_1 = new String[3][3];
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                field_1[i][j] = field[i][j];
            }
        }

        if(choose.equals("X")){
            this.good_choose = "X";
            this.bad_choose = "0";
        }
        else{
            this.good_choose = "0";
            this.bad_choose = "X";
        }
        int coordinate_x = -1, coordinate_y = -1;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(field[i][j].equals("_")){
                    field[i][j] = this.good_choose;
                    score = minimax(field, game_Object, 0, false);
                    field[i][j] = "_";
                    if(score > best_score){
                        best_score = score;
                        coordinate_x = i;
                        coordinate_y = j;
                    }
                }

            }

        }

        field_1[coordinate_x][coordinate_y] = this.good_choose;
        System.out.println("Компъютер сделал ход");
        return field_1;
    }

    private int minimax(String[][] field, Game_Mechanic game_Object, int depth, boolean isMaximazing) {

        String[][] field_2 = field;

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
                    if (field_2[i][j].equals("_")) {
                        field_2[i][j] = this.good_choose;
                        int score = minimax(field_2, game_Object, depth + 1, false);
                        field_2[i][j] = "_";
                        if (score > best_score) {
                            best_score = score;

                        }
                    }
                }
            }
            return best_score;
        }
        else{
            best_score = 999999999;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (field_2[i][j].equals("_")) {
                        field_2[i][j] = this.bad_choose;
                        int score = minimax(field_2, game_Object, depth + 1, true);
                        field_2[i][j] = "_";
                        if (score < best_score) {
                            best_score = score;

                        }
                    }
                }
            }
            return best_score;
        }

    }

}
