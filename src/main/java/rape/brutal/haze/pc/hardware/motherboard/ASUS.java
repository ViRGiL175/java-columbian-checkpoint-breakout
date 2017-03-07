package rape.brutal.haze.pc.hardware.motherboard;


public class ASUS extends Motherboard {


    public ASUS(int condition, String name) {

        super(condition, name);
        socket = "AM3+";
        bios = "BIOS v33.6";
        ramType = "DDR3";
        chipset = "RM730";
        hyperTransport = 133;
    }
}
