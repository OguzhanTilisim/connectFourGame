import java.util.Scanner;
public class ptwo {
    //First we are going to create visual
    public static String[][] visualPattern() {
//game is 6 colums and 6 rows but we have to show them in good design
        String[][] f = new String[7][15];
//we have to loop them
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
                //we are going to make row and colums with loops
                if (j % 2 == 0) f[i][j] = "|";
                else f[i][j] = " ";
                //ground vision
                if (i == 6) f[i][j] = "-";
            }
        }
        return f;
    }

    //we are going to create a method for visual game and we will do it with loop
    public static void printPattern(String[][] f) {
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
                System.out.print(f[i][j]);
            }
            System.out.println();
        }
    }

    //it is time make color thing and we will start with red
    public static void redPattern(String[][] f) {
        //we have to figure out user where would like to put red
        System.out.println("put red desk on cloumn!");
        Scanner scan = new Scanner(System.in);
        int c = 2 * scan.nextInt() + 1;
        for (int i = 5; i >= 0; i--) {
            if (f[i][c] == " ") {
                f[i][c] = "y";
                break;
            }
        }
    }

    //testing win or lose
    public static String testWin(String[][] f) {
        //for horizontal line
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j += 2) {
                if ((f[i][j + 1] != " ")
                        && (f[i][j + 3] != " ")
                        && (f[i][j + 5] != " ")
                        && (f[i][j + 7] != " ")
                        && ((f[i][j + 1] == f[i][j + 3])
                        && (f[i][j + 3] == f[i][j + 5])
                        && (f[i][j + 5] == f[i][j + 7])))
                    return f[i][j + 1];
            }
        }
//loop each number, we are going to increase them and we are going to check clor matches
        for (int i = 1; i < 15; i += 2) {
            //for vertical line
            for (int j = 0; j < 3; j++) {
                if ((f[j][i] != " ")
                        && (f[j + 1][i] != " ")
                        && (f[j + 2][i] != " ")
                        && (f[j + 3][i] != " ")
                        && ((f[j][i] == f[j + 1][i])
                        && (f[j + 1][i] == f[j + 2][i])
                        && (f[j + 2][i] == f[j + 3][i])))
                    return f[j][i];
            }
        }
        //for left to right but upside to downside
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 9; j += 2) {
                if ((f[i][j] != " ")
                        && (f[i + 1][j + 2] != " ")
                        && (f[i + 2][j + 4] != " ")
                        && (f[i + 3][j + 6] != " ")
                        && ((f[i][j] == f[i + 1][j + 2])
                        && (f[i + 1][j + 2] == f[i + 2][j + 4])
                        && (f[i + 2][j + 4] == f[i + 3][j + 6])))
                    return f[i][j];
            }
        }
//now, we have to reverse like right to left
        for (int i = 0; i < 3; i++) {
            for (int j = 7; j < 15; j += 2) {
                if ((f[i][j] != " ")
                        && (f[i + 1][j - 2] != " ")
                        && (f[i + 2][j - 4] != " ")
                        && (f[i + 3][j - 6] != " ")
                        && ((f[i][j] == f[i + 1][j - 2])
                        && (f[i + 1][j - 2] == f[i + 2][j - 4])
                        && (f[i + 2][j - 4] == f[i + 3][j - 6])))
                    return f[i][j];
            }
        }
//game can be draw or unwineable condition so we have to do it
        return null;
    }

    public static void main(String[] args) {
        String[][] f = visualPattern();
        boolean loop = true;
        int count = 0;
        printPattern(f);
        while (loop) {
            //red gets first turn
            if (count % 2 == 0) redPattern(f);

            count++;
            printPattern(f);
            // tell who won
            if (testWin(f) != null) {
                if (testWin(f) == "R")
                    System.out.println("Red won!");
                else if (testWin(f) == "Y")
                    System.out.println("Yellow won!");
                //exit program
                loop = false;
            }
        }
    }
}