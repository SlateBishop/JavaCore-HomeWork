import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    private ArrayList<Stage> stages;

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public Race(Stage... stages) {
//разве тут нужен new ArrayList<>? Достаточно же просто Arrays.asList(stages), он сам вернет return new ArrayList<>(a);
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}