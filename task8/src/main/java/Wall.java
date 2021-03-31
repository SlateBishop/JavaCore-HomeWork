public class Wall implements Obstruction {

    private int obstructionValue;

    public Wall(int obstructionValue) {
        this.obstructionValue = obstructionValue;
    }

    @Override
    public int getObstructionValue() {
        return obstructionValue;
    }
}
