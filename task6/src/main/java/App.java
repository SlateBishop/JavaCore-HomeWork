public class App {



    public static void main(String[] args) {
        Animal animal1 = new  Animal("Жираф");
        Animal animal2 = new  Animal("Хрюндель");
        Cat cat1 = new Cat("Кот");
        Cat cat2 = new Cat("Жёпа");
        Dog dog1 = new Dog("Пёс");
        Dog dog2 = new Dog("Пёсель");

        animal1.run(1000);
        animal2.swim(500);
        cat1.run(20);
        cat1.run(190);
        cat1.swim(-2);
        dog2.swim(-3);
        dog2.swim(8);

        allAnimalsCount();

    }

    public static void allAnimalsCount() {
        Animal.howManyAnimals();
        Cat.howManyCats();
        Dog.howManyDogs();
    }
}
