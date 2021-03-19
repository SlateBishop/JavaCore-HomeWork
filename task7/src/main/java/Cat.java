public class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        if (satiety) {
            System.out.printf("Кот %s не голоден\n", name);
        } else {
            satiety = plate.decreaseFood(appetite);
        }
    }

    public void info() {
        System.out.println("Имя: " + name);
        if (satiety) {
            System.out.println("Статус: сыт");
        } else {
            System.out.println("Статус: умирает от голода");
        }
    }
}
