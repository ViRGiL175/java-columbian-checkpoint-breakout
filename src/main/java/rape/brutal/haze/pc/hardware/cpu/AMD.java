package rape.brutal.haze.pc.hardware.cpu;

public class AMD extends CPU {


    public AMD(int condition, String name) {
        super(condition, name);
        socket = "AM3+";
        frequency = 2.5;
        generation = 5;
        cache = 1024;
        processTechnology = 16;
    }

    public void powerOn() {
        System.out.println("АМД инсайд");
    }
}