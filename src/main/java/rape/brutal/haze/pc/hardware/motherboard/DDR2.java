package rape.brutal.haze.pc.hardware.motherboard;

import rape.brutal.haze.pc.hardware.ram.RAM;

public class DDR2 extends RAM {

    public DDR2(int condition, String name) {

        super(condition, name);
        frequency = 633;
        size = 1024;
        type = "DDR2";
        timing = 16;
    }
}
