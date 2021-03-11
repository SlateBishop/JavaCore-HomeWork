import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

    private static final int SIZE = 7;
    private static final int DOTS_TO_WIN = 4;
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '-';
    private static Random rnd = new Random();
    private static Scanner sc = new Scanner(System.in); //Я так понимаю если сканер задаем в полях, то его уже не закрыть, верно?
    private static char[][] map;
    private static int aiMoveX;
    private static int aiMoveY;


    public static void main(String[] args) {
        if (SIZE >= DOTS_TO_WIN) {
            do {
                play(SIZE, DOTS_TO_WIN);
            } while (isPlayAgain());
        }

    }

    private static void play(int size, int dotsToWin) {
        initMap(size);
        System.out.printf("Игра в крестики-нолики на поле %dx%d\nДля победы необходима последовательность длинной %d\n", size, size, dotsToWin);
        printMap();
        while (true) {
            playerTurn();
            printMap();
            if (isWin(DOT_X)) {
                System.out.println("Поздравляю, вы победили!");
                break;
            } else if (isNoEmpty()) {
                System.out.println("Ничья!");
                break;
            }
            aiTurn();
            printMap();
            if (isWin(DOT_O)) {
                System.out.println("Skynet победил и отправился уничтожать организмов. \nВсё кончено.");
                break;
            } else if (isNoEmpty()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }

    private static void aiTurn() {
        if (canWinOrBlockLine(DOT_O)) {
            map[aiMoveX][aiMoveY] = DOT_O;
        } else if (canWinOrBlockDiagonal(DOT_O)) {
            map[aiMoveX][aiMoveY] = DOT_O;
        } else if (canWinOrBlockLine(DOT_X)) {
            map[aiMoveX][aiMoveY] = DOT_O;
        } else if (canWinOrBlockDiagonal(DOT_X)) {
            map[aiMoveX][aiMoveY] = DOT_O;
        } else {
            do {
                aiMoveX = rnd.nextInt(SIZE);
                aiMoveY = rnd.nextInt(SIZE);
            } while (map[aiMoveX][aiMoveY] != DOT_EMPTY);
            map[aiMoveX][aiMoveY] = DOT_O;
        }
        System.out.printf("Компьютер походил %d %d\n", aiMoveY + 1, aiMoveX + 1);
    }

    private static boolean canWinOrBlockLine(char symb) {
        int countLine = 0, countColumn = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) {
                    countLine++;
                } else {
                    countLine = 0;
                }
                if (map[j][i] == symb) {
                    countColumn++;
                } else {
                    countColumn = 0;
                }
                if (countLine == DOTS_TO_WIN - 1) {
                    if (j + 1 < SIZE && map[i][j + 1] == DOT_EMPTY) {
                        aiMoveX = i;
                        aiMoveY = j + 1;
                        return true;
                    } else if (j - countColumn >= 0 && map[i][j - countColumn] == DOT_EMPTY) {
                        aiMoveX = i;
                        aiMoveY = j - countColumn;
                        return true;
                    }
                }
                if (countColumn == DOTS_TO_WIN - 1) {
                    if (j + 1 < SIZE && map[j + 1][i] == DOT_EMPTY) {
                        aiMoveX = j + 1;
                        aiMoveY = i;
                        return true;
                    } else if (j - countColumn >= 0 && map[j - countColumn][i] == DOT_EMPTY) {
                        aiMoveX = j - countColumn;
                        aiMoveY = i;
                        return true;
                    }
                }
            }
            countLine = 0;
            countColumn = 0;
        }
        return false;
    }

    /* Для понимания метода см. пояснения к isDiagonalWin(char symb)
     * Отличие в сравнениях в конце. Для удобства изменения и простоты понимания ввел две переменные currentI и currentJ.
     * Они отображают положения сдвинутой от центра диагонали для каждого из четырех вариантов. Далее если есть диагональ
     * в которой для победы не хватает одного символа, то проверяем можем ли поставить этот символ следующим по диагонали
     * или перед началом победной цепочки.
    */
    private static boolean canWinOrBlockDiagonal (char symb) {
        int diagShift = 0;
        int delta = SIZE - DOTS_TO_WIN;
        do {
            int countDiagonal1 = 0, countDiagonal2 = 0, countDiagonal3 = 0, countDiagonal4 = 0;
            for (int i = 0, j = SIZE - 1; i < DOTS_TO_WIN + diagShift; i++, j--) {  //
                if (map[i + delta - diagShift][i] == symb) {
                    countDiagonal1++;
                } else {
                    countDiagonal1 = 0;
                }
                if (map[i + delta - diagShift][j] == symb) {
                    countDiagonal2++;
                } else {
                    countDiagonal2 = 0;
                }
                if (map[i][i + delta - diagShift] == symb) {
                    countDiagonal3++;
                } else {
                    countDiagonal3 = 0;
                }
                if (map[i][j - delta + diagShift] == symb) {
                    countDiagonal4++;
                } else {
                    countDiagonal4 = 0;
                }
                if (countDiagonal1 == DOTS_TO_WIN - 1) {
                    int currentI = i + delta - diagShift;
                    int currentJ = i;
                    if (currentI + 1 < SIZE && currentJ + 1 < SIZE && map[currentI + 1][currentJ + 1] == DOT_EMPTY) {
                        aiMoveX = currentI + 1;
                        aiMoveY = currentJ + 1;
                        return true;
                    } else if (currentI - countDiagonal1 >=0 && currentJ - countDiagonal1 >= 0               //Перенос строки согласно Java Code Convention, если я правильно понял соглашение.
                               && map[currentI - countDiagonal1][currentJ - countDiagonal1] == DOT_EMPTY) {
                        aiMoveX = currentI - countDiagonal1;
                        aiMoveY = currentJ - countDiagonal1;
                        return true;
                    }
                }
                if (countDiagonal2 == DOTS_TO_WIN - 1) {
                    int currentI = i + delta - diagShift;
                    int currentJ = j;
                    if (currentI + 1 < SIZE && currentJ - 1 >= 0 && map[currentI + 1][currentJ - 1] == DOT_EMPTY) {
                        aiMoveX = currentI + 1;
                        aiMoveY = currentJ - 1;
                        return true;
                    } else if (currentI - countDiagonal2 >=0 && currentJ + countDiagonal2 < SIZE
                               && map[currentI - countDiagonal2][currentJ + countDiagonal2] == DOT_EMPTY) {
                        aiMoveX = currentI - countDiagonal2;
                        aiMoveY = currentJ + countDiagonal2;
                        return true;
                    }
                }
                if (countDiagonal3 == DOTS_TO_WIN - 1) {
                    int currentI = i;
                    int currentJ = i + delta - diagShift;
                    if (currentI + 1 < SIZE && currentJ + 1 < SIZE && map[currentI + 1][currentJ + 1] == DOT_EMPTY) {
                        aiMoveX = currentI + 1;
                        aiMoveY = currentJ + 1;
                        return true;
                    } else if (currentI - countDiagonal3 >=0 && currentJ - countDiagonal3 >= 0
                               && map[currentI - countDiagonal3][currentJ - countDiagonal3] == DOT_EMPTY) {
                        aiMoveX = currentI - countDiagonal3;
                        aiMoveY = currentJ - countDiagonal3;
                        return true;
                    }
                }
                if (countDiagonal4 == DOTS_TO_WIN - 1) {
                    int currentI = i;
                    int currentJ = j - delta + diagShift;
                    if (currentI + 1 < SIZE && currentJ - 1 >= 0 && map[currentI + 1][currentJ - 1] == DOT_EMPTY) {
                        aiMoveX = currentI + 1;
                        aiMoveY = currentJ - 1;
                        return true;
                    } else if (currentI - countDiagonal4 >=0 && currentJ + countDiagonal4 < SIZE
                               && map[currentI - countDiagonal4][currentJ + countDiagonal4] == DOT_EMPTY) {
                        aiMoveX = currentI - countDiagonal4;
                        aiMoveY = currentJ + countDiagonal4;
                        return true;
                    }
                }
            }
            diagShift++;
        } while (diagShift <= delta);
        return false;
    }

    private static boolean isNoEmpty() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isPlayAgain() {
        int answer;
        do {
            System.out.println("Для того, что бы сыграть ещё раз введите 1, для выхода из программы введите 0");
            answer = sc.nextInt();
        } while (answer != 1 && answer != 0);
        return answer == 1;
    }

    private static boolean isWin(char symb) {
        return isDiagonalWin(symb) || isLineWin(symb);
    }

    //Проверяем строки и столбцы на условия победы
    private static boolean isLineWin(char symb) {
        int countLine = 0, countColumn = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) {
                    countLine++;
                } else {
                    countLine = 0;
                }
                if (map[j][i] == symb) {
                    countColumn++;
                } else {
                    countColumn = 0;
                }
                if (countColumn == DOTS_TO_WIN || countLine == DOTS_TO_WIN) {
                    return true;
                }
            }
            countLine = 0;
            countColumn = 0;
        }
        return false;
    }

        /* Теперь проверяем диагонали на победу.
         * Тут не смог придумать ничего лучше, чем пройтись сразу в четырех направлениях для проверки победы по диагонали
         * Допустим поле 5х5, для победы нужно всего три Х. тогда начинаем проверять с самых коротких диагоналей и сдвигаем границы к центру
         *  - - х - -
         *  - х - х -
         *  х - - - х
         *  - х - х -
         *  - - х - -
         *
         * На следующей итерации каждая граница смещается ближе к центру и становится по длине равной четырем:
         *  - х - х -
         *  х - х - х
         *  - х - х -
         *  х - х - х
         *  - х - х -
         */
        private static boolean isDiagonalWin(char symb) {
        int diagShift = 0;
        int delta = SIZE - DOTS_TO_WIN;
        do {
            int countDiagonal1 = 0, countDiagonal2 = 0, countDiagonal3 = 0, countDiagonal4 = 0;
            for (int i = 0, j = SIZE - 1; i < DOTS_TO_WIN + diagShift; i++, j--) {  //
                if (map[i + delta - diagShift][i] == symb) { //Диагональ идущую от [0][0] до [n][n] сдвигаем максимально вниз, что бы она была длиной минимальной для победы, потом в каждом шаге цикла поднимаем вверх на 1
                    countDiagonal1++;
                } else {
                    countDiagonal1 = 0;
                }
                if (map[i + delta - diagShift][j] == symb) {
                    countDiagonal2++;
                } else {
                    countDiagonal2 = 0;
                }
                if (map[i][i + delta - diagShift] == symb) {
                    countDiagonal3++;
                } else {
                    countDiagonal3 = 0;
                }
                if (map[i][j - delta + diagShift] == symb) {
                    countDiagonal4++;
                } else {
                    countDiagonal4 = 0;
                }
                if (countDiagonal1 == DOTS_TO_WIN || countDiagonal2 == DOTS_TO_WIN || countDiagonal3 == DOTS_TO_WIN || countDiagonal4 == DOTS_TO_WIN) {
                    return true;
                }
            }
            diagShift++;
        } while (diagShift <= delta);
        return false;
    }

    private static void playerTurn() {
        System.out.println("Ход игрока.");
        int x, y;
        do {
            System.out.println("Введите координаты места, куда хотите поставить крестик в виде X Y (через пробел):");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (isAnswerNotValid(x,y));
        map[y][x] = DOT_X; // перевернуты координаты х и у потому, что в общепринятой декартовой системе координат х - горизонтальная координата, у - вертикальная
    }

    private static boolean isAnswerNotValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            System.out.println("Введите координаты в пределах игрового поля");
            return true;
        } else if (map[y][x] != DOT_EMPTY) { // перевернуты координаты х и у потому, что в общепринятой декартовой системе координат х - горизонтальная координата, у - вертикальная
            System.out.println("Введите координаты пустого поля");
            return true;
        }
        return false;
    }

    private static void initMap (int size) {
        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap () {
        System.out.print("   ");
        for (int i = 1; i <= map[0].length; i++) {   //Тут ведь можно и через константу SIZE указать длину. Как правильнее?
            System.out.print(" " + i + " ");
        }
        System.out.println();
        int i = 1;
        for (char[] line : map) {
            System.out.print(i++ + "  ");
            for (char cell : line) {
                System.out.printf(" %c ", cell);
            }
            System.out.println();
        }
        System.out.println();

    }





}
