import java.util.Random;
import java.util.Scanner;
public class lession4 {
    public static int SIZE = 5;
    private static final int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }
    public static boolean checkWin(char symb) {
        int endOfOffset = map.length - DOTS_TO_WIN;
        for (int rowOffset = 0; rowOffset <= endOfOffset; rowOffset++) {
            if (isDiagonalsFilledWith(symb, rowOffset)) {
                return true;
            }
            for (int columnOffset = 0; columnOffset <= endOfOffset; columnOffset++) {
                boolean hasWin = isLinesFilledWith(symb, rowOffset, columnOffset);
                if (hasWin) {
                    return  true;
                }
            }
        }
        return false;
    }
    private static boolean isLinesFilledWith(char symb, int rowOffset, int columnOffset) {
        for (int row = rowOffset; row < (DOTS_TO_WIN + rowOffset); row++) {
            int horizontalWinCounter = 0;
            int verticalWinCounter = 0;
            for (int column = columnOffset; column < (DOTS_TO_WIN + columnOffset); column++) {
                if (map[row][column] == symb) {
                    horizontalWinCounter++;
                } else {
                    horizontalWinCounter = 0;
                }
                if (map[column][row] == symb) {
                    verticalWinCounter++;
                } else {
                    verticalWinCounter = 0;
                }
            }
            if ((horizontalWinCounter == DOTS_TO_WIN) || (verticalWinCounter == DOTS_TO_WIN)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isDiagonalsFilledWith(char symb, int rowOffset) {
        int mainDiagonalCounter = 0;
        int sideDiagonalCounter = 0;
        final int subSquareLenght = (DOTS_TO_WIN + rowOffset);
        for (int row = rowOffset; row < subSquareLenght; row++) {
            if (map[row][row] == symb) {
                mainDiagonalCounter++;
            } else {
                mainDiagonalCounter = 0;
            }
            if (map[row][map.length - 1 - row] == symb) {
                sideDiagonalCounter++;
            } else {
                sideDiagonalCounter = 0;
            }
        }
        return (mainDiagonalCounter == DOTS_TO_WIN) || (sideDiagonalCounter == DOTS_TO_WIN);
    }
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}