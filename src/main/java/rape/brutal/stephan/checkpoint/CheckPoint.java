package rape.brutal.stephan.checkpoint;

import rape.brutal.stephan.checkpoint.auto.Auto;
import rape.brutal.stephan.checkpoint.auto.IDestruyable;


public class CheckPoint implements IDestruyable {

    private final int defoltMorality;
    private Auto auto;
    private int hitPoints;
    private int damage;
    private int morality;
    private boolean destroyed;

    public CheckPoint(int hitPoints, int damage, int morality) {
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.morality = morality;
        defoltMorality = morality;
        System.out.println("Created CheckPoint characteristics :" +
                " HitPoints: " + hitPoints + ", Damage: " + damage + "\n");
    }

    public int getMorality() {
        return morality;
    }

    public boolean checkAuto() {
        System.out.println("\n *** Start check auto ***\n");
        if (this.auto == null) {
            System.out.println("\n nyet mashini\n");
            return false;
        } else {
            System.out.println("\n Mashina estь\n");
            String documents = auto.getDocuments();
            System.out.println("Start check documents.\n");
            if (documents == null) {
                System.out.println("No Docs\n");
                attackAuto();
                return false;
            } else if (documents.contains("ИГИЛ")) {
                System.out.println("we have fu***g IGIL in Docs");
                attackAuto();
                return false;
            } else {
                System.out.println("dokumenti nye IGIL\n Check goods on legal: ");
                return true;
//                ArrayList<Good> goodArrayList = auto.getGoodArrayList();
//                for (Good good : goodArrayList) {
//                    if (!good.getLegal()) {
//                        System.out.println("Goods No legal \n");
//                        attackAuto();
//                        return false;
//                    } else {
//                        System.out.println("Good is good \n");
//                        return true;
//                    }
//                }
            }

        }
    }

    public Auto pullAuto() {
        Auto auto = this.auto;
        this.auto = null;
        return auto;
    }

    public void setAuto(Auto auto) {
        if (this.auto == null) {
            this.auto = auto;
        } else {
            System.out.println("Myest nyet \n");
        }
    }

    private void attackAuto() {

        while ((morality > auto.getMorality()) && (hitPoints > 0) && (auto.getHitPoints() > 0)) {
            auto.setHitPoints(auto.getHitPoints() - damage);
            System.out.println("\n Auto was attacked! \n" +
                    "now HP AUTO: " + auto.getHitPoints());
            hitPoints = hitPoints - auto.getDamage();
            morality -= auto.getMorality();
            System.out.println("\n Checkpoint was attacked! \n" +
                    "now HP CheckPoint: " + hitPoints + "\n Morality: " + morality);
        }
        if (auto.getHitPoints() > 0) {
            System.out.println("\nYou alive \n Horoshego Kolumbiyskogo otdiha! ^3^ \n Auto go in ZAKAT");
        }
        if (hitPoints > 0) {
            morality = defoltMorality;
            System.out.println("\n CheckPoint unbroken. \n Morality recovered");
        }
        pullAuto();

    }

    @Override
    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public void makeDamage(int damage) {
        hitPoints -= damage;
        if (hitPoints <= 0) {
            destroyed = true;
        }
    }
}
