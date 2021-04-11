import java.util.Arrays;
import java.util.stream.Stream;

public class ThreadSpeedTester {
    private static final int SIZE = 10000000;
    private static final int HALF = SIZE / 2;
    private float[] arr = new float[SIZE];
    private boolean isDone1;
    private boolean isDone2;


    public void firstMethod() {
        Arrays.fill(arr, 1.0f);
        System.out.println("Начало выполнения метода №1");
        long time = System.currentTimeMillis();
        myCalcArr(arr, 0);
        System.out.println("Время выполнения метода №1 составило " + (System.currentTimeMillis() - time) +
                " миллисекунд");
    }

    public void myCalcArr(float[] arr, int calcShift) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (float) (i + calcShift) / 5) * Math.cos(0.2f + (float) (i + calcShift) / 5) *
                    Math.cos(0.4f + (float) (i + calcShift) / 2));
        }
//        System.out.println("bla bla " + Thread.currentThread());
    }

    public void secondMethod() {
        ThreadSpeedTester speedTest = new ThreadSpeedTester();
        Arrays.fill(arr, 1.0f);
        float[] tempArr1 = new float[HALF];
        float[] tempArr2 = new float[HALF];
        long startTime;
        long splitTime;
        long calcTime;
        long endTime;
        System.out.println("Начало выполнения метода №2");
        startTime = System.currentTimeMillis();
// Наверное логичнее было бы разбивать массив на два и склеивать обратно в тех же потоках, где и проводим вычисления. Но я следую ТЗ.
        System.arraycopy(arr, 0, tempArr1, 0, HALF);
        System.arraycopy(arr, HALF, tempArr1, 0, HALF);
        splitTime = System.currentTimeMillis();

        Thread thread1 = new Thread(() -> {
            isDone1 = false;
            speedTest.myCalcArr(tempArr1, 0);
            isDone1 = true;
            myNotify();
        });
        Thread thread2 = new Thread(() -> {
            isDone2 = false;
            speedTest.myCalcArr(tempArr2, HALF);
            isDone2 = true;
            myNotify();
        });
        thread1.start();
        thread2.start();
        synchronized (this) {
            while (!(isDone1 && isDone2)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        calcTime = System.currentTimeMillis();
        System.arraycopy(tempArr1, 0, arr, 0, HALF);
        System.arraycopy(tempArr2, 0, arr, HALF, HALF);
        endTime = System.currentTimeMillis();
        System.out.println("Метод два закончил свою работу за " + (endTime - startTime) + " миллисекунд");
        System.out.println("Время на разделение массивов: " + (splitTime - startTime) + " миллисекунд");
        System.out.println("Время на вычисления: " + (calcTime - splitTime) + " миллисекунд");
        System.out.println("Время на возврат результата в массив: " + (endTime - calcTime) + " миллисекунд");
    }

    public synchronized void myNotify() {
        if (isDone1 && isDone2) {
            notify();
        }
    }

    public static void main(String[] args) {
        ThreadSpeedTester speedTest = new ThreadSpeedTester();
        speedTest.firstMethod();
        speedTest.secondMethod();
    }

    Stream
}
