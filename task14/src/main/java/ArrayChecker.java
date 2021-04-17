public class ArrayChecker {

    public boolean arrayCheck(int[] arr, int i1, int i2) {
        if (arr == null) {
            System.out.println("Необходимо вводить не пустой массив");
            return false;
        }
        boolean i1Check = false;
        boolean i2Check = false;
        for (int i : arr) {
            if (i != i1 && i != i2) {
                return false;
            }
            if (i == i1) {
                i1Check = true;
            }
            if (i == i2) {
                i2Check = true;
            }
        }
        return (i1Check && i2Check);
    }
}
