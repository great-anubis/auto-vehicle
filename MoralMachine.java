package CS_Project_Spring_2023;

import java.util.*;

public class MoralMachine {

    public static void main(String[] args) {
        int numberOfScenarios = 100;
        double[] survivalRates = testAlgorithm(numberOfScenarios);
        printSurvivalRates(survivalRates, numberOfScenarios);
    }

    public static boolean decideSwerve(int scenario, String group1, String group2) {
        boolean savingLives = savingMoreLives(group1, group2);
        boolean upholdingLaw = upholdingTheLaw(scenario);
        boolean agePref = age(group1, group2);
        boolean groupSizePref = groupSize(group1, group2);

        if (agePref || savingLives || groupSizePref || upholdingLaw) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean savingMoreLives(String group1, String group2) {
        int group1Count = group1.length();
        int group2Count = group2.length();

        return group1Count > group2Count;
    }

    public static boolean upholdingTheLaw(int scenario) {
        String scene = Integer.toString(scenario);

        if (scene.charAt(0) == '0') {
            return false;
        } else if (scene.charAt(0) == '1') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean groupSize(String group1, String group2) {
        int group1Length = group1.length();
        int group2Length = group2.length();

        return group1Length >= group2Length;
    }

    public static int countGroupMembersOfType(String group, char[] types) {
        int count = 0;

        for (int i = 0; i < group.length(); i++) {
            char ch = group.charAt(i);

            for (char type : types) {
                if (ch == type) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static boolean age(String group1, String group2) {
        int youngerGroupCount = countGroupMembersOfType(group1, new char[] { 'b', 'B', 'g', 'G' });
        int olderGroupCount = countGroupMembersOfType(group2, new char[] { 'e', 'E' });

        return youngerGroupCount > olderGroupCount;
    }

    public static double[] testAlgorithm(int numberOfScenarios) {
        double[] survivalRates = new double[26]; // Assuming there are 26 character types

        for (int i = 0; i < numberOfScenarios; i++) {
            ScenarioGenerator scenarioGenerator = new ScenarioGenerator();
            int scenario = scenarioGenerator.getScenario();
            String group1 = scenarioGenerator.getGroup();
            String group2 = scenarioGenerator.getGroup();

            boolean swerve = decideSwerve(scenario, group1, group2);
            String killedGroup = swerve ? group1 : group2;

            for (int j = 0; j < killedGroup.length(); j++) {
                char type = killedGroup.charAt(j) - 'a'; // Convert to index
                survivalRates[type]++;
            }
        }

        for (int i = 0; i < survivalRates.length; i++) {
            survivalRates[i] /= numberOfScenarios; // Normalize the survival rates
        }

        return survivalRates;
    }

    public static void printSurvivalRates(double[] survivalRates, int numberOfScenarios) {
        System.out.println("Survival rates after running " + numberOfScenarios + " scenarios:");

        for (int i = 0; i < survivalRates.length; i++) {
            char type = (char) (i + 'a');
            double survivalRatePercentage = survivalRates[i] * 100;
            System.out.println(type + " (" + ScenarioGenerator.getMemberName(type) + "): " + survivalRatePercentage + "%");
        }
    }
}
