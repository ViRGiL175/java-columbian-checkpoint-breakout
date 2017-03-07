package rape.brutal.haze.pc.hardware.ram;

import rape.brutal.haze.pc.constructor.Hardware;

public abstract class RAM extends Hardware {

    protected int frequency;
    protected int size;
    protected int timing;
    protected String type;

    public RAM(int condition, String name) {
        super(condition, name);
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTiming() {
        return timing;
    }

    public void setTiming(int timing) {
        this.timing = timing;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void powerOn() {

        System.out.println("RAM начала работу");
    }

    public void powerOff() {
        System.out.println("RAM завершила работу");
    }

    public int scorePoint() {
        int scorePoint = (int) (frequency / timing);
        return scorePoint;
    }
}

