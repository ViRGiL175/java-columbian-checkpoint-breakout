package rape.brutal.haze.pc.hardware.ram;

public class DDR4 extends RAM {


    public DDR4(int condition, String name) {
        super(condition, name);
        frequency = 2134;
        size = 8192;
        type = "DDR4";
        timing = 2;
    }
}
