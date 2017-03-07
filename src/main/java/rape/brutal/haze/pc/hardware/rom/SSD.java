package rape.brutal.haze.pc.hardware.rom;


public class SSD extends ROM {


    public SSD(int condition, String name) {
        super(condition, name);
        readSpeed = 500;
        writeSpeed = 250;
    }
}
