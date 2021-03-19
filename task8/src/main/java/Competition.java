import java.util.Random;

public class Competition {

    private static final int NUMBER_OF_PARTICIPANTS = 10;
    private static final int NUMBER_OF_OBSTRUCTIONS = 5;
    private static final int MIN_LENGTH = 200;
    private static final int MAX_LENGTH = 500;
    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 6;
    private static final int HUMAN_RUN_LIMIT = 400;
    private static final int HUMAN_JUMP_LIMIT = 2;


    public static void main(String[] args) {
        Competition competition = new Competition();
        competition.competition();
    }

    public void competition() {
        Obstruction[] obstructions = createObstructions(NUMBER_OF_OBSTRUCTIONS, MIN_LENGTH, MAX_LENGTH, MIN_HEIGHT, MAX_HEIGHT);
        Athletes[] participants = createParticipants(NUMBER_OF_PARTICIPANTS, HUMAN_RUN_LIMIT, HUMAN_JUMP_LIMIT);
        int i = 0;

        System.out.println("Начинаются соревнования в таких дисциплинах как бег по дорожкам и прыжки через стену!");
        System.out.println("Полоса препятствий будет состоять из " + NUMBER_OF_OBSTRUCTIONS + " объектов.");
        System.out.println("А теперь взглянем на " + NUMBER_OF_PARTICIPANTS + " сегодняшних участников:");
        System.out.println("Мы видим как выполняют растяжку люди, котики бегают за своими хвостами и друг другом.");
        System.out.println("А так же!!! Только сегодня!!! Skynet прислал свои особые модели по выбиванию всего @#$%^& из мешков с костями!");
        System.out.println();

        for (Athletes participant : participants) {
            i++;
            System.out.println();
            System.out.printf("Участник №%d, %s, приступает испытаниям!\n", i, participant.getClassName());
            for (Obstruction obstruction : obstructions) {
                if (participant.getInfo()) {
                    if (obstruction instanceof Wall) {
                        participant.jump(obstruction.getObstructionValue());
                    } else {
                        participant.run(obstruction.getObstructionValue());
                    }
                } else {
                    break;
                }
            }
        }

        whoWinInfo(participants);
    }

    private void whoWinInfo(Athletes[] participants) {
        System.out.println();
        int i = 0;
        for (Athletes participant : participants) {
            i++;
            if (participant.getInfo()) {
                System.out.printf("Участник №%d %s прошел все испытания!\n", i, participant.getClassName());
            } else {
                System.out.printf("Участник №%d %s провалился.\n", i, participant.getClassName());
            }
        }
    }

    public Obstruction[] createObstructions(int numberOfObstructions, int minLength, int maxLength, int minHeight, int maxHeight) {
        Random rnd = new Random();
        Obstruction[] obstructions = new Obstruction[numberOfObstructions];
        for (int i = 0; i < numberOfObstructions; i++) {
            int a = rnd.nextInt(2); //выбор между стеной и дорожкой
            switch (a) {
                case 0:
                    obstructions[i] = new Wall((rnd.nextInt((maxHeight - minHeight)) + minHeight));  //было 1-6
                    break;
                case 1:
                    obstructions[i] = new Treadmill((rnd.nextInt((maxLength - minLength)) + minLength)); //было 200-500
                    break;
            }
        }
        return obstructions;
    }

    public Athletes[] createParticipants(int numberOfParticipants, int humanRunLimit, int humanJumpLimit) {
        int catRunLimit = humanRunLimit / 3;
        int catJumpLimit = humanJumpLimit * 2;
        int skynetRunLimit = humanRunLimit * 100;
        int skynetJumpLimit = humanJumpLimit * 10;
        Random rnd = new Random();
        Athletes[] participants = new Athletes[numberOfParticipants];
        for (int i = 0; i < numberOfParticipants; i++) {
            int a = rnd.nextInt(3);
            switch (a) {
                case 0:
                    participants[i] = new Human((rnd.nextInt(humanRunLimit / 2 + 1) + humanRunLimit / 2), (rnd.nextInt(humanJumpLimit / 2 + 1) + humanJumpLimit / 2));
                    break;
                case 1:
                    participants[i] = new Cat((rnd.nextInt(catRunLimit / 2 + 1) + catRunLimit / 2), (rnd.nextInt(catJumpLimit / 2 + 1) + catJumpLimit / 2));
                    break;
                case 2:
                    participants[i] = new Skynet((rnd.nextInt(skynetRunLimit / 2 + 1) + skynetRunLimit / 2), (rnd.nextInt(skynetJumpLimit / 2 + 1) + skynetJumpLimit / 2));
                    break;
            }
        }
        return participants;
    }


}



