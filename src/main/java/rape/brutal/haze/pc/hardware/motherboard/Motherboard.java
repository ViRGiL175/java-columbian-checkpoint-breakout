package rape.brutal.haze.pc.hardware.motherboard;


import rape.brutal.haze.pc.constructor.Hardware;

public abstract class Motherboard extends Hardware {
    protected String socket;
    protected String bios;
    protected String ramType;
    protected String chipset;
    protected int hyperTransport;

    public Motherboard(int condition, String name) {
        super(condition, name);
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getBios() {
        return bios;
    }

    public void setBios(String bios) {
        this.bios = bios;
    }

    public String getRamType() {
        return ramType;
    }

    public void setRamType(String ramType) {
        this.ramType = ramType;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public int getHyperTransport() {
        return hyperTransport;
    }

    public void setHyperTransport(int hyperTransport) {
        this.hyperTransport = hyperTransport;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof Motherboard) {
//            Motherboard newMother = (Motherboard) obj;
//            if (newMother.hyperTransport == this.hyperTransport) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//        return super.equals(obj);
//    }


}


