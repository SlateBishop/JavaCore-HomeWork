import java.util.Arrays;

public class ArrayCuter {

    public int[] cutArray(int[] arr, int num) {
        if (arr == null) {
            System.out.println("Необходимо вводить не пустой массив");
            return null;
        }
        int lastNumPoint = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num && i != (arr.length - 1)) {
                lastNumPoint = i;
            } else if (arr[i] == num && i == (arr.length - 1)) {
                return null;
            }
        }
        if (lastNumPoint == -1) {
            throw new RuntimeException("Массив не содержит цисло " + num);
        }
        int[] result = new int[(arr.length - lastNumPoint - 1)];
        System.arraycopy(arr, lastNumPoint + 1, result, 0, result.length);
        return result;
    }
}
