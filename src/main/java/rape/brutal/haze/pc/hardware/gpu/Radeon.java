package rape.brutal.haze.pc.hardware.gpu;

public class Radeon extends GPU {

    public Radeon(int condition, String name) {

        super(condition, name);
        gpuFrequency = 800;
        ram = 2048;
        units = 630;
        shaders = 300;
    }

    public void powerOn() {
        System.out.println("Что воняет и горит? Это карточка палит!");
    }

}