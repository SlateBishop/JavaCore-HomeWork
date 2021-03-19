public class App {

    public static void main(String[] args) {
        int catsValue = 5;
        Plate plate = new Plate(10);
        plate.addFood(1);
        plate.info();
        Cat[] cats = new Cat[catsValue];
        for (int i = 0; i < catsValue; i++) {
            cats[i] = new Cat(("Кот №" + (i + 1)), catsValue - i);
            cats[i].eat(plate);
            cats[i].info();
//            plate.info();
        }

    }
}
