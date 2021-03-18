import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Game_Mechanic game_Object = new Game_Mechanic();
        Scanner in = new Scanner(System.in);
        String choose = new String();
        Object Player_1 = new Object();
        Object Player_2 = new Object();
        control(in, choose, game_Object);
    }

    public static void control(Scanner in, String choose, Game_Mechanic game_Object){
        while(true) {
            System.out.println("Здравствуйте, выберите режим игры:");
            System.out.println("1. Игрок 1 против Игрок 2");
            System.out.println("2. Игрок против компъютера");
            System.out.println("3. Выйти");
            choose = in.nextLine();
            if(choose.equals("1")){
                Player_User Player_1 = new Player_User();
                Player_User Player_2 = new Player_User();
                match(Player_1, Player_2, game_Object);
                break;
            }
            else if(choose.equals("2")){
                System.out.println("Выберите сложность:");
                System.out.println("1. Лёгкая");
                System.out.println("2. Средняя");
                choose = in.nextLine();
                if(choose.equals("1")){
                    Player_User Player_1 = new Player_User();
                    Player_Computer Player_2 = new Player_Computer();
                    match(Player_1, Player_2, game_Object);
                    break;
                }
                else if(choose.equals("2")){
                    Player_User Player_1 = new Player_User();
                    Player_Computer_Medium Player_2 = new Player_Computer_Medium();
                    match(Player_1, Player_2, game_Object);
                    break;
                }

            }
            else if(choose.equals("3")){
                System.out.println("До свидания");
                break;
            }
            else{
                System.out.println("Вы ввели что-то не то");
            }

        }
    }

    public static void match(Players Player_1, Players Player_2, Game_Mechanic game_Object){
        String [][] field;
        String player_1_choose = "X";
        String player_2_choose = "0";
        field = game_Object.get_field();
        game_Object.show_field();
        while(true){

            field = Player_1.make_move(field, player_1_choose);
            game_Object.set_field(field);
            if(!game_Object.is_win()){
                System.out.printf("%s победил!", player_1_choose);
                break;
            }
            field = Player_2.make_move(field, player_2_choose);
            game_Object.set_field(field);
            game_Object.show_field();
            if(!game_Object.is_win()){
                System.out.printf("%s победил!", player_2_choose);
                break;
            }

        }
    }
}
