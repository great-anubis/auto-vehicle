package CS_Project_Spring_2023;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MMGenerator {
    static final char MAN = 'a';
    static final char WOMAN = 'b';
    static final char BOY = 'c';
    static final char GIRL = 'd';
    static final char ELDERLY_MAN = 'e';
    static final char ELDERLY_WOMAN = 'f';
    static final char OBESE_MAN = 'g';
    static final char OBESE_WOMAN = 'h';
    static final char MALE_EXECUTIVE = 'i';
    static final char FEMALE_EXECUTIVE = 'j';
    static final char MALE_DOCTOR = 'k';
    static final char FEMALE_DOCTOR = 'l';
    static final char MALE_JOGGER = 'm';
    static final char FEMALE_JOGGER = 'n';
    static final char PREGNANT_WOMAN = 'o';
    static final char HOMELESS_PERSON = 'p';
    static final char CRIMINAL = 'q';
    static final char BABY = 'r';
    static final char DOG = 's';
    static final char CAT = 't';

    // Define scenario codes as constants
    static final int NO_LEGAL_COMPLICATIONS = 0;
    static final int CURRENT_LANE_GREEN = 1;
    static final int OTHER_LANE_GREEN = 2;

    private static final Map<Character, String> memberNames = new HashMap<>();

    static {
        memberNames.put(MAN, "Man");
        memberNames.put(WOMAN, "Woman");
        memberNames.put(BOY, "Boy");
        memberNames.put(GIRL, "Girl");
        memberNames.put(ELDERLY_MAN, "Elderly Man");
        memberNames.put(ELDERLY_WOMAN, "Elderly Woman");
        memberNames.put(OBESE_MAN, "Obese Man");
        memberNames.put(OBESE_WOMAN, "Obese Woman");
        memberNames.put(MALE_EXECUTIVE, "Male Executive");
        memberNames.put(FEMALE_EXECUTIVE, "Female Executive");
        memberNames.put(MALE_DOCTOR, "Male Doctor");
        memberNames.put(FEMALE_DOCTOR, "Female Doctor");
        memberNames.put(MALE_JOGGER, "Male Jogger");
        memberNames.put(FEMALE_JOGGER, "Female Jogger");
        memberNames.put(PREGNANT_WOMAN, "Pregnant Woman");
        memberNames.put(HOMELESS_PERSON, "Homeless Person");
        memberNames.put(CRIMINAL, "Criminal");
        memberNames.put(BABY, "Baby");
        memberNames.put(DOG, "Dog");
        memberNames.put(CAT, "Cat");
    }

    public static int getScenario() {
        Random random = new Random();
        int scenario = random.nextInt(3);
        int legal = random.nextInt(3) * 10;

        return scenario + legal;
    }

    public static String getGroup() {
        Random random = new Random();
        int count = random.nextInt(5) + 1; // Generate a random count between 1 and 5
        StringBuilder group = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int val = random.nextInt(CAT - MAN + 1);
            group.append((char) (MAN + val));
        }
        return group.toString();
    }

    public static String getMemberName(char member) {
        String name = memberNames.get(member);
        return name != null ? name : "n/a";
    }

    public static void printGroup(String group) {
        for (int i = 0; i < group.length(); i++) {
            System.out.println(getMemberName(group.charAt(i)));
        }
    }
}
