package rape.brutal.haze.pc.constructor;

import rape.brutal.haze.pc.PC;
import rape.brutal.haze.pc.hardware.PowerSupply;
import rape.brutal.haze.pc.hardware.cpu.AMD;
import rape.brutal.haze.pc.hardware.motherboard.ASUS;
import rape.brutal.haze.pc.hardware.ram.DDR3;
import rape.brutal.punydevil.communications.phone.Phone;
import rape.brutal.punydevil.communications.users.User;
import rape.brutal.stephan.checkpoint.auto.BigAuto;
import rape.brutal.stephan.checkpoint.auto.MadMaxAuto;
import rape.brutal.stephan.checkpoint.auto.OrdinaryAuto;
import rape.brutal.stephan.checkpoint.auto.autoparts.bodys.AMAZINGbody;
import rape.brutal.stephan.checkpoint.auto.autoparts.bodys.BigBody;
import rape.brutal.stephan.checkpoint.auto.autoparts.bodys.OrdinaryBody;
import rape.brutal.stephan.checkpoint.auto.autoparts.motors.BigMotor;
import rape.brutal.stephan.checkpoint.auto.autoparts.motors.HardMotor;
import rape.brutal.stephan.checkpoint.auto.autoparts.motors.NormalMotor;
import rape.brutal.stephan.checkpoint.auto.autoparts.wheels.BigWheels;
import rape.brutal.stephan.checkpoint.auto.autoparts.wheels.MurderWheels;
import rape.brutal.stephan.checkpoint.auto.autoparts.wheels.OrdinaryWheels;

import java.util.Objects;

public class Engineer extends User {


    public static final String HOW_MATCH_ANSWER = "Ок, сделаю! Сколько платишь?";
    public static final String READY_ANSWER = "Всё собрано!";
    private String itemName;
    private int money;
    private TechItem techItem;


    public Engineer(Phone userPhone) {
        super(userPhone);
    }

    public TechItem getTechItem() {
        return techItem;
    }

    public void hear(String text, int contactNumber) {
        super.hear(text, contactNumber);

        if (text.matches("[-+]?\\d+")) {
            money = Integer.parseInt(text);
            techItem = createItem(money, itemName);
            call(contactNumber, READY_ANSWER);
        }

        if (Objects.equals(text, PC.NAME)) {
            itemName = text;
            text = HOW_MATCH_ANSWER;
            call(contactNumber, text);
        }

        if (Objects.equals(text, BigAuto.NAME)) {
            itemName = text;
            text = HOW_MATCH_ANSWER;
            call(contactNumber, text);
        }

        if (Objects.equals(text, MadMaxAuto.NAME)) {
            itemName = text;
            text = HOW_MATCH_ANSWER;
            call(contactNumber, text);
        }

        if (Objects.equals(text, OrdinaryAuto.NAME)) {
            itemName = text;
            text = HOW_MATCH_ANSWER;
            call(contactNumber, text);
        }
    }

    public TechItem createItem(int money, String itemName) {


        switch (itemName) {

            case PC.NAME:
                PC pc;
                if (PC.COST <= money) {
                    pc = new PC();

                    System.out.println("Собираем Компьютер...");

                    AMD amd = new AMD(100, "AMD");
                    ASUS asus = new ASUS(100, "ASUS");
                    DDR3 ddr3 = new DDR3(45, "DDR3");
                    PowerSupply powerSupply = new PowerSupply(100, "PowerSupply");

                    pc.addHardware(amd);
                    pc.addHardware(asus);
                    pc.addHardware(ddr3);
                    pc.addHardware(powerSupply);

                    pc.assignHardware();
                } else {
                    System.out.println("Недостаточно денег, собирать не буду!");
                    break;
                }
                return new PC();

            case BigAuto.NAME:
                BigAuto bigAuto;
                if (BigAuto.COST <= money) {

                    bigAuto = new BigAuto(100, "Шрек", 110);

                    BigBody bigBody = new BigBody(100, "BigBody");
                    BigMotor bigMotor = new BigMotor(100, "BigMotor");
                    BigWheels bigWheels = new BigWheels(100, "BigWheels");

                    bigAuto.addHardware(bigBody);
                    bigAuto.addHardware(bigMotor);
                    bigAuto.addHardware(bigWheels);

                    bigAuto.assignHardware();
                } else {
                    System.out.println("Недостаточно денег, собирать не буду!");
                    break;
                }
                return bigAuto;

            case MadMaxAuto.NAME:
                MadMaxAuto madMaxAuto;
                if (MadMaxAuto.COST <= money) {

                    madMaxAuto = new MadMaxAuto(100000, "ИГИЛ", 1100000);

                    AMAZINGbody amazinGbody = new AMAZINGbody(100, "AMAZINGbody");
                    HardMotor hardMotor = new HardMotor(100, "HardMotor");
                    MurderWheels murderWheels = new MurderWheels(100, "MurderWheels");

                    madMaxAuto.addHardware(amazinGbody);
                    madMaxAuto.addHardware(hardMotor);
                    madMaxAuto.addHardware(murderWheels);

                    madMaxAuto.assignHardware();
                } else {
                    System.out.println("Недостаточно денег, собирать не буду!");
                    break;
                }
                return madMaxAuto;

            case OrdinaryAuto.NAME:
                OrdinaryAuto ordinaryAuto = new OrdinaryAuto(1, "пенсия", 1);
                if (ordinaryAuto.getCost() <= money) {

                    OrdinaryBody ordinaryBody = new OrdinaryBody(100, "OrdinaryBody");
                    NormalMotor normalMotor = new NormalMotor(100, "NormalMotor");
                    OrdinaryWheels ordinaryWheels = new OrdinaryWheels(100, "OrdinaryWheels");

                    ordinaryAuto.addHardware(ordinaryBody);
                    ordinaryAuto.addHardware(normalMotor);
                    ordinaryAuto.addHardware(ordinaryWheels);

                    ordinaryAuto.assignHardware();
                } else {
                    System.out.println("Недостаточно денег, собирать не буду!");
                    break;
                }
                return ordinaryAuto;


            default:
                System.out.println("Я не умею такое собирать!");
                return null;
        }
        return null;
    }

    void repairItem(TechItem techItem, int money) {

    }

    @Override
    public void use(IUsable iUsable) {

    }

    @Override
    protected void greeting() {

    }

    @Override
    protected void byeing() {

    }


}
