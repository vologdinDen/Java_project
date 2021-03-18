public class Player_Computer extends Players{

    private int[] coordinate_int;

    public Player_Computer(){
        this.coordinate_int = new int[2];
    }

    public String[][] make_move(String[][] field, String choose) {

        while(true){
            this.coordinate_int[0] = (int)(Math.random() * 3);
            this.coordinate_int[1] = (int)(Math.random() * 3);


            if(field[this.coordinate_int[0]][this.coordinate_int[1]].equals("_")){
                field[this.coordinate_int[0]][this.coordinate_int[1]] = choose;
                break;
            }

        }
        System.out.println("Компъютер сделал ход");
        return field;
    }

}
