public class Skynet implements Athletes {

    private int runLimit;
    private int jumpLimit;
    private boolean inCompetition;

    public Skynet(int runLimit, int jumpLimit) {
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.inCompetition = true;
    }

    @Override
    public void run(int obstructionValue) {
        if (runLimit >= obstructionValue) {
            System.out.printf("%s пробежал %d метров\n", Athlete.SKYNET.getAthleteType(), obstructionValue);
        } else {
            System.out.printf("%s не смог пробежать %d метров\n Отправлен на переплавку\n", Athlete.SKYNET.getAthleteType(), obstructionValue);
            inCompetition = false;
        }
    }

    @Override
    public void jump(int obstructionValue) {
        if (jumpLimit >= obstructionValue) {
            System.out.printf("%s перепрыгнул препятствие высотой %d метров\n", Athlete.SKYNET.getAthleteType(), obstructionValue);
        } else {
            System.out.printf("%s не смог перепрыгнуть препятствие высотой %d метров\n Отправлен на переплавку\n", Athlete.SKYNET.getAthleteType(), obstructionValue);
            inCompetition = false;
        }
    }

    @Override
    public boolean getInfo() {
        return inCompetition;
    }

    @Override
    public String getClassName() {
        return Athlete.SKYNET.getAthleteType();
    }
}
