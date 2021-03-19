import java.util.Scanner;

public class Game_Mechanic {
    private String[][] field;
    final Scanner in = new Scanner(System.in);


    public Game_Mechanic(){
        this.field = new String[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                this.field[i][j] = "_";
            }
        }

    }

    public void show_field(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(this.field[i][j]);
            }
            System.out.println();
        }

    }
    public String[][] get_field(){
        return this.field;
    }

    public void set_field(String[][] field){
        this.field = field;
    }

    public int is_win() {

        if (this.field[0][0].equals(this.field[0][1]) && this.field[0][0].equals(this.field[0][2]) && !this.field[0][0].equals("_")) {
            return 1;
        }
        if (this.field[1][0].equals(this.field[1][1]) && this.field[1][0].equals(this.field[1][2]) && !this.field[1][0].equals("_")) {
            return 1;
        }
        if (this.field[2][0].equals(this.field[2][1]) && this.field[2][0].equals(this.field[2][2]) && !this.field[2][0].equals("_")) {
            return 1;
        }
        if (this.field[0][0].equals(this.field[1][0]) && this.field[0][0].equals(this.field[2][0]) && !this.field[0][0].equals("_")) {
            return 1;
        }
        if (this.field[0][1].equals(this.field[1][1]) && this.field[0][1].equals(this.field[2][1]) && !this.field[0][1].equals("_")) {
            return 1;
        }
        if (this.field[0][2].equals(this.field[1][2]) && this.field[0][2].equals(this.field[2][2]) && !this.field[0][2].equals("_")) {
            return 1;
        }
        if (this.field[0][0].equals(this.field[1][1]) && this.field[0][0].equals(this.field[2][2]) && !this.field[0][0].equals("_")) {
            return 1;
        }
        if (this.field[0][2].equals(this.field[1][1]) && this.field[0][2].equals(this.field[2][0]) && !this.field[0][2].equals("_")) {
            return 1;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.field[i][j].equals("_")) {
                    return 2;
                }
            }
        }
        return 0;
    }


}
