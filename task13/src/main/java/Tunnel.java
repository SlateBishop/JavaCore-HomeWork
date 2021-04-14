import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private final Semaphore smp = new Semaphore(MainClass.CARS_COUNT/2);

    public Tunnel(int length) { //Добавил в конструкторе длину тоннеля по человечески, что бы ла возможность добавлять разные тоннели в трассу.
        this.length = length;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        // Не совсем понял зачем тут два вложенных try/catch блока. Не лучше ли было сделать два catch?
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " +
                        description);
                smp.acquire();
                System.out.println(c.getName() + " начал этап: " + description + ", текущее время " + System.currentTimeMillis());
                Thread.sleep(length / c.getSpeed() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " +
                        description + ", текущее время " + System.currentTimeMillis());
                smp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}