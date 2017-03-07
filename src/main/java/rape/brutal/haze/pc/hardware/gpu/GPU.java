package rape.brutal.haze.pc.hardware.gpu;

import rape.brutal.haze.pc.constructor.Hardware;

public abstract class GPU extends Hardware {

    protected int gpuFrequency;
    protected int ram;
    protected int units;
    protected int shaders;

    public GPU(int condition, String name) {
        super(condition, name);
    }


    public abstract void powerOn();

    public void powerOff() {
        System.out.println("Видеокарта завершила работу");
    }
}







