public class Animal {
    private String name;
    private int runDistance;
    private int swimDistance;
    private static int animalsCount;

    public Animal(String name) {
        this.name = name;
        animalsCount++;
    }

    public Animal() {
        this.name = "noNameAnimal";
        animalsCount++;
    }

    public void run(int distance) {
        if (distance >= 0) {
            runDistance += distance;
            System.out.printf("Животное %s пробежало %d метров. Всего оно пробежало %d метров\n", name, distance, runDistance);
        } else {
            System.out.println("Введено не корректное значение");
        }
    }

    public void swim(int distance) {
        if (distance >= 0) {
            swimDistance += distance;
            System.out.printf("Животное %s проплыло %d метров. Всего оно проплыло %d метров\n", name, distance, swimDistance);
        } else {
            System.out.println("Введено не корректное значение");
        }
    }

    public static void howManyAnimals() {
        System.out.printf("Всего имеется %d животных\n", animalsCount);
    }
}
