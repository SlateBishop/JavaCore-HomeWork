public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void addFood(int add) {
        if (add >= 0) {
            food += add;
        } else {
            System.out.println("Боженька покарает еретиков, отбирающих еду у котиков");
        }
    }

    public boolean decreaseFood(int decrease) {
        if (food - decrease >= 0) {
            food -= decrease;
            return true;
        } else {
            info();
            System.out.println("В тарелке слишком мало еды");
            return false;
        }
    }

    public void info() {
        System.out.println("В тарелке " + food + " еды");
    }

}
