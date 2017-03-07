package rape.brutal.haze.pc.hardware.cpu;

public class Intel extends CPU {

    public Intel(int condition, String name) {
        super(condition, name);
        socket = "LGA1151";
        frequency = 3;
        generation = 6;
        cache = 512;
        processTechnology = 10;
    }

    public void powerOn() {
        System.out.println("Интл инсайд");
    }


}