package rape.brutal.haze.pc.hardware.cpu;

import rape.brutal.haze.pc.constructor.Hardware;

public abstract class CPU extends Hardware {

    protected String socket;
    protected double frequency;
    protected int generation;
    protected int cache;
    protected int processTechnology;

    public CPU(int condition, String name) {
        super(condition, name);
    }


    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public int getCache() {
        return cache;
    }

    public void setCache(int cache) {
        this.cache = cache;
    }

    public int getProcessTechnology() {
        return processTechnology;
    }

    public void setProcessTechnology(int processTechnology) {
        this.processTechnology = processTechnology;
    }

    public abstract void powerOn();

    public void powerOff() {
        System.out.println("Процессор завершил работу");
    }

    public void turboBoost() {
        System.out.println("Частота ЦП увеличена");
    }

    public int scorePoint() {
        int scorePoint = (int) (cache * frequency * generation / processTechnology);
        return scorePoint;
    }
}







