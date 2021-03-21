import java.util.Random;

public class MyArray {
    private static int LEGAL_ARR_SIZE = 4;

    public int sumMyArray(String[][] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr.length != LEGAL_ARR_SIZE || arr[i].length != LEGAL_ARR_SIZE) {
                throw new MyArraySizeException("Заданный массив не удовлетворяет требуемому размеру");
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    result += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Не удалось преобразовать элемент массива с координатами: " + i + ", " + j);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MyArray myArr = new MyArray();
        try {
            System.out.println(myArr.sumMyArray(myArr.createNewArr(4, 4)));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    private String[][] createNewArr(int stringsNumber, int columnsNumber) {
        Random rnd = new Random();
        String[][] arr = new String[stringsNumber][columnsNumber];
        for (int i = 0; i < stringsNumber; i++) {
            for (int j = 0; j < columnsNumber; j++) {
//                arr[i][j] = String.valueOf((rnd.nextInt(75) + 48));
//сделал небольшой разброс значений, для того что бы был шанс создать массив из чисел, но и шанс на ошибку был не мал.
                char ch = (char) (rnd.nextInt(12) + 48);
                arr[i][j] = String.valueOf(ch);
//                System.out.println(arr[i][j]);
            }
        }
        return arr;
    }
}
