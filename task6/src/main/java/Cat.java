public class Cat extends Animal {
    private String name;
    private int runDistance;
    private int maxRun = 200; //не константа для того, что бы можно было давать коту отдохнуть и бежать дальше
    private static int catsCount;

    public Cat(String name) {
//        super(name); - почему при создании инстанса в имени выдает null?? Пришлось через this.name = name; повторять
        this.name = name;
        catsCount++;
    }

    @Override
    public void run(int distance) {
        if (runDistance + distance <= maxRun && distance >= 0) {
            runDistance += distance;
            System.out.printf("Кот %s пробежал %d метров. Всего он пробежал %d метров\n", name, distance, runDistance);
        } else if (runDistance + distance > maxRun) {
            System.out.printf("Кот %s уже пробежал %d метров. Он не может пробежать ещё %d метров, пусть сперва отдохнет\n", name, runDistance, distance);
        } else {
            System.out.println("Введено не корректное значение");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.printf("К сожалению ваш кот %s не умеет плавать\n", name);
    }

    public static void howManyCats() {
        System.out.printf("Котиков: %d\n", catsCount);
    }

}
