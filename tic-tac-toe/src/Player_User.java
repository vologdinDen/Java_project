import java.util.Scanner;

public class Player_User extends Players {
    final Scanner in = new Scanner(System.in);

    public Player_User(){

    }

    public String[][] make_move(String [][] field, String choose) {
        String [] coordinate_str;
        int [] coordinate_int = new int[2];
        while (true) {
            try {
                System.out.print("Введите координаты через запятую:");
                coordinate_str = in.nextLine().replaceAll(" ", "").split(",");

                coordinate_int[0] = Integer.parseInt(coordinate_str[0]);
                coordinate_int[1] = Integer.parseInt(coordinate_str[1]);

                if (coordinate_int[0] > 3 || coordinate_int[0] < 0 || coordinate_int[1] < 0 || coordinate_int[1] > 3) {
                    System.out.println("Координаты не могут быть меньше 0 или больше 3");
                    this.make_move(field, choose);
                    break;
                }

                if (!field[coordinate_int[0] - 1][coordinate_int[1] - 1].equals("_")) {
                    System.out.println("Эта позиция занята!");
                    this.make_move(field, choose);
                    break;
                }

                field[coordinate_int[0] - 1][coordinate_int[1] - 1] = choose;

                break;
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели что-то не то");
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Вводить координаты нужно через запятую!");
            }
        }
        return field;
    }
}
