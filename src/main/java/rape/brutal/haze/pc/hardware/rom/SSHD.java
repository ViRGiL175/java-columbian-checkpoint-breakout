package rape.brutal.haze.pc.hardware.rom;


public class SSHD extends ROM {


    public SSHD(int condition, String name) {
        super(condition, name);
        readSpeed = 250;
        writeSpeed = 150;
    }
}
