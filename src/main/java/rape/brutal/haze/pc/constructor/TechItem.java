package rape.brutal.haze.pc.constructor;

import java.util.HashMap;


public abstract class TechItem implements IUsable {

    protected HashMap<String, Hardware> hardwareHashMap = new HashMap<>();

    public void use() {
    }

    public abstract int getCost();


    public Hardware getHardware(String hardwareName) {
        return hardwareHashMap.get(hardwareName);
    }

    public void addHardware(Hardware hardware) {
        hardwareHashMap.put(hardware.getHardwareName(), hardware);
    }

    public abstract String getItemName();

    public abstract void assignHardware();

}