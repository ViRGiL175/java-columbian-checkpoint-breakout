package rape.brutal.haze.pc.constructor;

public class Hardware {

    private int condition;

    private String name;

    public Hardware(int condition, String name) {
        this.condition = condition;
        this.name = name;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public String getHardwareName() {
        return name;
    }

    protected void repair(int money) {
        if (condition<100){
            condition += money;
        }

//to do
    }
}
