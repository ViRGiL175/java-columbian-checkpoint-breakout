package rape.brutal.stephan.checkpoint.auto;

import rape.brutal.haze.pc.constructor.Hardware;
import rape.brutal.haze.pc.constructor.TechItem;
import rape.brutal.stephan.checkpoint.auto.autoparts.Good;
import rape.brutal.stephan.checkpoint.auto.autoparts.bodys.Body;
import rape.brutal.stephan.checkpoint.auto.autoparts.motors.Motor;
import rape.brutal.stephan.checkpoint.auto.autoparts.wheels.Wheels;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ViRGiL7 on 25.02.2017.
 * Project: check-point
 */
public abstract class Auto extends TechItem implements IDestruyable {

    protected Body body;
    protected Motor motor;
    protected Wheels wheels;
    private String documents;
    private int hitPoints;
    private int morality;
    private ArrayList<Good> goodArrayList = new ArrayList<>();
    private int damage;
    private boolean destroyed;

    public Auto(int hitPoints, String documents, int morality) {
        System.out.println("Create " + this.getClass().getSimpleName() + "\n and his charact. : "
                + hitPoints + " " + documents + " " + morality);
        this.hitPoints = hitPoints;
        this.documents = documents;
        this.morality = morality;
    }

    public Body getBody() {
        return body;
    }

    public Motor getMotor() {
        return motor;
    }

    public Wheels getWheels() {
        return wheels;
    }

    public int getMorality() {
        return this.morality;
    }

    public void setMorality(int morality) {
        this.morality = morality;
    }

    public void addGood(Good good) {
        goodArrayList.add(good);
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }

    @Override
    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public ArrayList<Good> getGoodArrayList() {
        return goodArrayList;
    }

    @Override
    public void assignHardware() {
        Collection<Hardware> values = hardwareHashMap.values();
        for (Hardware hardware : values) {
            if (hardware instanceof Body) {
                body = (Body) hardware;
            } else if (hardware instanceof Motor) {
                motor = (Motor) hardware;
            } else if (hardware instanceof Wheels) {
                wheels = (Wheels) hardware;
            }
        }
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    public abstract int getCost();

    @Override
    public void makeDamage(int damage) {
        hitPoints -= damage;
        if (hitPoints <= 0) {
            destroyed = true;
        }
    }
}

