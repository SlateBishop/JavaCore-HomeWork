public class Dog extends Animal {
    private String name;
    private int runDistance;
    private int maxRun = 500; //не константа для того, что бы можно было давать псу отдохнуть и бежать дальше
    private int swimDistance;
    private int maxSwim = 10;
    private static int dogsCount;

    public Dog(String name) {
//        super(name);
        this.name = name;
        dogsCount++;
    }

    @Override
    public void run(int distance) {
        if (runDistance + distance <= maxRun && distance >= 0) {
            runDistance += distance;
            System.out.printf("Пёс %s пробежал %d метров. Всего он пробежал %d метров\n", name, distance, runDistance);
        } else if (runDistance + distance > maxRun) {
            System.out.printf("Пёс %s уже пробежал %d метров. Он не может пробежать ещё %d метров, пусть сперва отдохнет\n", name, runDistance, distance);
        } else {
            System.out.println("Введено не корректное значение");
        }
    }

    @Override
    public void swim(int distance) {
        if (swimDistance + distance <= maxSwim && distance >= 0) {
            swimDistance += distance;
            System.out.printf("Пёс %s проплыл %d метров. Всего он проплыл %d метров\n", name, distance, swimDistance);
        } else if (swimDistance + distance > maxSwim) {
            System.out.printf("Пёс %s уже проплыл %d метров. Он не может проплыть ещё %d метров, пусть сперва отдохнет\n", name, swimDistance, distance);
        } else {
            System.out.println("Введено не корректное значение");
        }
    }

    public static void howManyDogs() {
        System.out.printf("Пёсиков: %d\n", dogsCount);
    }

}
