package rape.brutal.haze.pc.hardware.motherboard;

public class Gigabyte extends Motherboard {


    public Gigabyte(int condition, String name) {
        super(condition, name);
        socket = "AM3+";
        bios = "BIOS v32";
        ramType = "DDR3";
        chipset = "AR52";
        hyperTransport = 133;
    }
}
