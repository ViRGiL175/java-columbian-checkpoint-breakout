package rape.brutal.haze.pc.hardware.motherboard;

public class MSI extends Motherboard {

    public MSI(int condition, String name) {
        super(condition, name);
        socket = "LGA1151";
        bios = "EFI v5.1";
        ramType = "DDR4";
        chipset = "HM77";
        hyperTransport = 233;
    }
}
