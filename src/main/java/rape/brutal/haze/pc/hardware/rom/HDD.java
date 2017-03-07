package rape.brutal.haze.pc.hardware.rom;


public class HDD extends ROM {


    public HDD(int condition, String name) {
        super(condition, name);
            readSpeed = 100;
            writeSpeed = 50;

    }
}
