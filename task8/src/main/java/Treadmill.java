public class Treadmill implements Obstruction {

    private int obstructionValue;

    public Treadmill(int obstructionValue) {
        this.obstructionValue = obstructionValue;
    }

    @Override
    public int getObstructionValue() {
        return obstructionValue;
    }
}
