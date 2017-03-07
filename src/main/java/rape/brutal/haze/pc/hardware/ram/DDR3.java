package rape.brutal.haze.pc.hardware.ram;

public class DDR3 extends RAM {

    public DDR3(int condition, String name) {

        super(condition, name);
        frequency = 1066;
        size = 4096;
        type = "DDR3";
        timing = 9;
    }
}
