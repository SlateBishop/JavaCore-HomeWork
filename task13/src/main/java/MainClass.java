import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);
        CountDownLatch cd = new CountDownLatch(CARS_COUNT * 2);
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(200), new Tunnel(100), new Road(300));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cb, cd);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

/* Мне не очень нравится вариант который я реализовал для отслеживания начала гонки.
 * Но из альтернатив придумал только передать в конструктор ещё один CountDownLatch или сделать логическую переменную
 * для отслеживания готовности каждого участника. Оба варианта показались хуже реализованного, особенно с логической
 * переменной, т.к. с ней ещё скорее всего пришлось бы поломать голову как синхронизировать объявление о начале гонки
 * наперед старта участников, но после их готовности.
 */
        while (cd.getCount() != CARS_COUNT) {
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        try {
            cd.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Car car : cars) {
            System.out.println(car.getName() + " ехал со скоростью " + car.getSpeed());
        }

    }
}