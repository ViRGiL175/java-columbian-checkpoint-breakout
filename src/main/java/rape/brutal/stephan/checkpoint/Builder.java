package rape.brutal.stephan.checkpoint;

import rape.brutal.stephan.checkpoint.auto.Auto;
import rape.brutal.stephan.checkpoint.auto.BigAuto;
import rape.brutal.stephan.checkpoint.auto.MadMaxAuto;
import rape.brutal.stephan.checkpoint.auto.OrdinaryAuto;
import rape.brutal.stephan.checkpoint.auto.autoparts.Good;

import java.util.ArrayList;
import java.util.Scanner;

public class Builder {

    private Scanner answer = new Scanner(System.in);
    private CheckPoint checkPoint;
    private Auto auto;
    private ArrayList<Auto> autoArrayList = new ArrayList<>();


    public void beginingOfGeneration() {
        String answerOfUser;
        System.out.println("For generate situation create checkpoint and cars:\n" +
                " For creating checkpoint press 1 ;\n For creating car press 2 ;\n" +
                " For start simulation press 3.\n" +
                "(If you don't create checkpoint and/or Auto/auto's" +
                "\n - unknown points will be create randomly.) \n");
        System.out.println(); /* просто для красоты */
        answerOfUser = answer.nextLine();
        switch (answerOfUser) {
            case "1":
                createCheckPoint();
                break;
            case "2":
                createAuto();
                break;
            case "3":
                System.out.println("\n Start simulation... \n");
                simulate();
                break;
            default:
                System.out.println("Incorrect answer! \n Try it again.\n");
                beginingOfGeneration();
                break;
        }
    }

    private void createCheckPoint() {
        System.out.println("Your choice: create checkpoint." +
                "\n For creating by hand press 1 ;\n For creating randomly press 2 ; \n" +
                " If you want start over - press 3 .\n");
        System.out.println(); /* просто для красоты */
        String answerOfUser = answer.nextLine();
        switch (answerOfUser) {
            case "1":
                System.out.println("РУЧКАМИ РУЧКАМИ: \n");
                checkPointCreateByUser();
                beginingOfGeneration();
                break;
            case "2":
                System.out.println("Randomeme: \n");
                checkPointCreateRandom();
                beginingOfGeneration();
                break;
            case "3":
                beginingOfGeneration();
                break;
            default:
                System.out.println("ti kosorukiy, try again >:C \n");
                createCheckPoint();
                break;
        }
    }

    private void checkPointCreateByUser() {
        System.out.println("Now, if you create checkpoint, he will have HitPoints, Damage and Morality.\n" +
                " Choice this parameters: \n");
        System.out.println("Write HP: ");
        int hitPoints = Integer.parseInt(answer.nextLine());
        System.out.println("Write Damage: ");
        int damage = Integer.parseInt(answer.nextLine());
        System.out.println("Write morality: ");
        int morality = Integer.parseInt(answer.nextLine());
        checkPoint = new CheckPoint(hitPoints, damage, morality);
    }

    private void checkPointCreateRandom() {
        System.out.println("Now your checkpoint will be created randomly. \n");
        int hitPoints = (int) (10 + (Math.random() * (100000 - 10)));
        int damage = (int) (10 + (Math.random() * (1000 - 10)));
        int morality = (int) (10 + (Math.random() * (100000 - 10)));
        checkPoint = new CheckPoint(hitPoints, damage, morality);
    }

    private void createAuto() {
        System.out.println("How many auto's you want create? \n");
        int numberListOfAuto = Integer.parseInt(answer.nextLine());
        for (int i = 0; i < numberListOfAuto; i++) {
            System.out.println(); /* просто для красоты */
            System.out.println("*** Number auto in list: " + (i + 1) + " ***");
            autoCreation();
        }
        beginingOfGeneration();
    }

    private void autoCreation() {
        System.out.println("What type of auto you want create? \n" +
                "Press 1 for create ordinary auto; \n" +
                "Press 2 for create big auto; \n" +
                "Press 3 for create Mad Max auto; \n" +
                "Press 4 for choice THIS car start over" +
                "Press 5 for start over (Choice number of auto's). \n");
        String answerOfUser = answer.nextLine();
        switch (answerOfUser) {
            case "1":
                autoArrayList.add(buildOrdinaryAuto());
                break;
            case "2":
                autoArrayList.add(buildBigAuto());
                break;
            case "3":
                autoArrayList.add(buildMadMaxAuto());
                break;
            case "4":
                autoCreation();
            case "5":
                beginingOfGeneration();
                break;
            default:
                System.out.println("ti kosorukiy, try again >:C \n");
                createAuto();
                break;
        }
    }

    private Auto buildOrdinaryAuto() {
        this.auto = new OrdinaryAuto(10, " Документы обычной машины ", 50 );
        return auto;
    }

    private Auto buildBigAuto() {
        this.auto = new BigAuto(45, " ИГИЛ ", 50);
        auto.addGood(new Good(true, 54));
        return auto;
    }

    private Auto buildMadMaxAuto() {
        this.auto = new MadMaxAuto(8900, " MadMaxDocs ", 50);
        auto.addGood(new Good(false, 100500));
        return auto;
    }

    private void simulate() {
        if (checkPoint == null) checkPointCreateRandom();
        if (auto == null) buildMadMaxAuto();                     // ЗАТЫЧКА - допилить
        checkPoint.setAuto(auto);
        checkPoint.checkAuto();
        System.out.println("********** FINISH_of_SIMULATION **********");
    }
}