import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Game_Mechanic game_Object = new Game_Mechanic();
        Scanner in = new Scanner(System.in);
        String choose = new String();
        control(in, choose, game_Object);
    }

    public static void control(Scanner in, String choose, Game_Mechanic game_Object){
        while(true) {
            System.out.println("Здравствуйте, выберите режим игры:");
            System.out.println("1. Игрок 1 против Игрок 2");
            System.out.println("2. Игрок против компъютера");
            System.out.println("3. Выйти");
            choose =  in.nextLine();
            if(choose.equals("1")){
                Player_User Player_1 = new Player_User();
                Player_User Player_2 = new Player_User();
                match(Player_1, Player_2, game_Object, true);
                break;
            }
            else if(choose.equals("2")){

                System.out.println("Выберите сложность:");
                System.out.println("1. Лёгкая");
                System.out.println("2. Средняя");
                System.out.println("3. Сложная");
                choose = in.nextLine();
                switch (choose) {
                    case "1" -> {
                        Players Player_1;
                        Players Player_2;
                        boolean first = who_first(in);
                        if (first) {
                            Player_1 = new Player_User();
                            Player_2 = new Player_Computer();
                        } else {
                            Player_1 = new Player_Computer();
                            Player_2 = new Player_User();
                        }
                        match(Player_1, Player_2, game_Object, first);

                    }
                    case "2" -> {
                        Players Player_1;
                        Players Player_2;
                        boolean first = who_first(in);
                        if (first) {
                            Player_1 = new Player_User();
                            Player_2 = new Player_Computer_Medium();
                        } else {
                            Player_1 = new Player_Computer_Medium();
                            Player_2 = new Player_User();
                        }
                        match(Player_1, Player_2, game_Object, first);
                    }
                    case "3" -> {
                        Players Player_1;
                        Players Player_2;
                        boolean first = who_first(in);
                        if (first) {
                            Player_1 = new Player_User();
                            Player_2 = new Player_Computer_Hard();
                        } else {
                            Player_1 = new Player_Computer_Hard();
                            Player_2 = new Player_User();
                        }
                        match(Player_1, Player_2, game_Object, first);
                    }
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

    public static void match(Players Player_1, Players Player_2, Game_Mechanic game_Object, boolean first){
        String [][] field;
        String[] arr = choose_player();
        String player_1_choose, player_2_choose;
        if(first) {
            player_1_choose = arr[0];
            player_2_choose = arr[1];
        }else{
            player_1_choose = arr[1];
            player_2_choose = arr[0];
        }
        field = game_Object.get_field();
        game_Object.show_field();
        while(true){
            field = Player_1.make_move(field, player_1_choose);
            game_Object.set_field(field);
            System.out.println("Игрок 1 сделал ход");
            game_Object.show_field();
            if(game_Object.is_win() == 1){
                System.out.printf("%s победил\n", player_1_choose);
                game_Object.clear_field();
                break;
            }else if(game_Object.is_win() == 0){
                System.out.println("Ничья");
                game_Object.clear_field();
                break;
            }

            field = Player_2.make_move(field, player_2_choose);
            game_Object.set_field(field);
            System.out.println("Игрок 2 сделал ход");
            game_Object.show_field();
            if(game_Object.is_win() == 1){
                System.out.printf("%s победил\n", player_2_choose);
                game_Object.clear_field();
                break;
            }else if(game_Object.is_win() == 0){
                System.out.println("Ничья");
                game_Object.clear_field();
                break;
            }


        }
    }

    public static boolean who_first(Scanner in){
        String choose_who_first;
        while(true){
            System.out.print("Хотите ли вы начать первым?(Y - да, N - нет):");
            choose_who_first = in.nextLine();
            if(choose_who_first.equals("Y")){
                return true;
            }
            else if(choose_who_first.equals("N")){
                return false;
            }
            else{
                System.out.println("Вы ввели что-то не то");
            }
        }
    }

    public static String[] choose_player(){
        String player = " ";
        String ai = "";
        String [] choose = new String[2];
        Scanner in = new Scanner(System.in);
        while(player.equals(" ")){
            System.out.print("Чем хотите играть?(X - играть крестиками, 0 - ноликами):");
            player = in.nextLine();
            if(player.equals("X")){
                ai = "0";
            }
            else if(player.equals("0")){
                ai = "X";
            }
            else{
                System.out.println("Вы ввели что-то не то");
                player = "";
            }

        }
        choose[0] = player;
        choose[1] = ai;
        return choose;
    }

}
