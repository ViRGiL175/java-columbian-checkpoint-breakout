package rape.brutal.haze.pc.hardware.gpu;

public class Nvidia extends GPU {

    public Nvidia(int condition, String name) {

        super(condition, name);
        gpuFrequency = 1200;
        ram = 4096;
        units = 550;
        shaders = 600;
    }

    public void powerOn() {
        System.out.println("Видеокарта запущена");
    }

}