package rape.brutal.haze.pc.hardware;

import rape.brutal.haze.pc.constructor.Hardware;

public class PowerSupply extends Hardware {

    public PowerSupply(int condition, String name) {
        super(condition, name);
    }

    public void powerOn() {
        System.out.println("БП запущен");
    }

    public void powerOff() {
        System.out.println("БП выключен");
    }


}
