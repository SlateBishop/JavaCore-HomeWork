public enum Athlete {
    HUMAN("Человек"), CAT("Котик"), SKYNET("Жидкий Терминатор");
    private String athleteType;

    Athlete(String athleteType) {
        this.athleteType = athleteType;
    }

    public String getAthleteType() {
        return athleteType;
    }
}
