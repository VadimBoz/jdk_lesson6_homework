package org.example;


import java.util.HashMap;
import java.util.Random;

public class Main {
    private static HashMap<Integer, String> resGames = new HashMap<>();
    private final static int COUNT_GAMES = 100000;



    public static void main(String[] args) {
        Random random = new Random();
        int countWinModerator  =  0;
        int countWinUser  =  0;

        int[] curVariant;
        for (int i = 0; i < COUNT_GAMES; i++) {
            int winVariant = random.nextInt(3);
            int userChoice1 = random.nextInt(3);
            int moderatorChoice = moderatorChoice(userChoice1, winVariant); // вскрытие пустого варианта
            int userChoice2 = userChoice2(moderatorChoice, userChoice1);
            if (userChoice2 == winVariant) {
                countWinUser++;
                resGames.put(i, "User win");
            } else {
                countWinModerator++;
                resGames.put(i, "Moderator win");
            }
        }

        System.out.println("Count win moderator: " + 100 * countWinModerator/COUNT_GAMES + "%\n" +
                "Count win user: " + 100 * countWinUser/COUNT_GAMES + "% ");

    }


    private static int moderatorChoice(int userChoice1, int winVariant) {
        Random random = new Random();
        int res;
        while (true) {
            res = random.nextInt(3);
            if (res != winVariant && res != userChoice1) {
                return res;
            }
        }
    }

    private static int userChoice2(int moderatorChoice, int userChoice1) {
        Random random = new Random();
        int res;
        while (true) {
            res = random.nextInt(3);
            if (res == moderatorChoice
                || res == userChoice1  // пользователь меняет свой выбор
            ) continue;
            return res;
        }
    }


}