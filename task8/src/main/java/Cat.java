public class Cat implements Athletes {

    private int runLimit;
    private int jumpLimit;
    private boolean inCompetition;

    public Cat(int runLimit, int jumpLimit) {
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.inCompetition = true;
    }

    @Override
    public void run(int obstructionValue) {
        if (runLimit >= obstructionValue) {
            System.out.printf("%s пробежал %d метров и издал победное МЯУ!\n", Athlete.CAT.getAthleteType(), obstructionValue);
        } else {
            System.out.printf("%s не смог пробежать %d метров и пошел отрываться на чьих то тапках\n", Athlete.CAT.getAthleteType(), obstructionValue);
            inCompetition = false;
        }
    }

    @Override
    public void jump(int obstructionValue) {
        if (jumpLimit >= obstructionValue) {
            System.out.printf("%s перепрыгнул препятствие высотой %d метров и издал победное МЯУ!\n", Athlete.CAT.getAthleteType(), obstructionValue);
        } else {
            System.out.printf("%s не смог перепрыгнуть препятствие высотой %d метров и пошел отрываться на чьих то тапках\n", Athlete.CAT.getAthleteType(), obstructionValue);
            inCompetition = false;
        }
    }

    @Override
    public boolean getInfo() {
        return inCompetition;
    }

    @Override
    public String getClassName() {
        return Athlete.CAT.getAthleteType();
    }
}
