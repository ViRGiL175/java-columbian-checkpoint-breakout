package rape.brutal.haze.pc.hardware.rom;

import rape.brutal.haze.pc.constructor.Hardware;

public abstract class ROM extends Hardware {

    protected int readSpeed;
    protected int writeSpeed;

    public ROM(int condition, String name) {
        super(condition, name);

    }


    public void powerOn() {
        System.out.println("Дисковая подсистема запущена");
    }

    public void powerOff() {
        System.out.println("Дисковая подсистема остановлена");
    }

    public int scorePoint() {
        int scorePoint = (int) (readSpeed * writeSpeed);
        return scorePoint;
    }
}


