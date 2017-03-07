package rape.brutal.punydevil.communications.phone;

import rape.brutal.bladerunner.DemoGame;
import rape.brutal.punydevil.communications.infrastructure.ICallable;
import rape.brutal.punydevil.communications.infrastructure.IConnector;
import rape.brutal.punydevil.communications.phone.hardware.*;
import rape.brutal.punydevil.communications.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Phone implements ICallable {

    boolean isTurnedOn = false;
    boolean isUnlock = false;
    private SIM sim;
    private IConnector activeAts;
    private User user;
    private Display display = new Display();
    private Accumulator accumulator = new Accumulator();
    private CPU cpu = new CPU();
    private RadioModule radioModule = new RadioModule();
    private Memory memory = new Memory();
    private ArrayList<IConnector> iConnectors = new ArrayList<>();

    public Phone(SIM sim) {
        System.out.println("Sim inner phone");
        this.sim = sim;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public boolean isUnlock() {
        return isUnlock;
    }

    public void setUnlock(boolean unlock) {
        isUnlock = unlock;
    }

    private boolean setActiveAts() {
        System.out.println("Phone registered on the network\n");
        if (iConnectors.size() > 0) {
            this.activeAts = iConnectors.get(new Random().nextInt(iConnectors.size()));
            if (activeAts != null) {
                activeAts.register(sim.getNumber(), this);
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("No signal!");
            return false;
        }
    }

    public void addATS(IConnector activeAts) {
        iConnectors.add(activeAts);
    }

    public void addATSs(List<IConnector> iConnectors) {
        this.iConnectors.addAll(iConnectors);
    }

    public void phoneCall(String text, int contactNumber) {
        int simNumber = sim.getNumber();
        if (setActiveAts()) {
            activeAts.call(text, simNumber, contactNumber);
        } else {
            System.out.println("No signal!");
        }
    }

    public void phoneSMS(String text, int contactNumber) throws InterruptedException {
        int simNumber = sim.getNumber();
        if (setActiveAts()) {
            activeAts.sendSMS(text, simNumber, contactNumber);
        } else {
            System.out.println("No signal!");
        }
    }

    @Override
    public void receiveCall(String text, int contactNumber) {
        System.out.println(contactNumber + " is calling!");
        System.out.println(contactNumber + " sad: " + text);
//        boolean wannaAnswer = new Random().nextBoolean();
//        if (wannaAnswer) {
//            if (Objects.equals(text, "привет")) {
//                text = "как дела?";
//            } else if (Objects.equals(text, "как дела?")) {
//                text = "норм";
//            }
//            activeAts.call(text, getNumber(), contactNumber);
//        }
        if (user != null) {
            user.hear(text, contactNumber);
        }
    }

    @Override
    public void receiveSMS(String text, int contactNumber) {
        System.out.println("аббоненту " + contactNumber + " отправлено сообщение " + '"' + text + '"');
        boolean wannaAnswer = new Random().nextBoolean();
        if (wannaAnswer) {
            String answer = "Test answer!";
            activeAts.sendSMS(answer, getNumber(), contactNumber);
        }
    }

    public int getNumber() {
        return sim.getNumber();
    }

    public void turnOn() throws InterruptedException {
        if (!isTurnedOn) {

            System.out.println("loading...");
            Thread.sleep(2000);
            if (accumulator == null) {
                System.out.println("Вставьте аккумулятор");
            } else if (accumulator.getCapacity() <= 0) {
                System.out.println("Батарея разряжена");
            } else {
                isTurnedOn = true;
                System.out.println("Welcome!");
            }
        }
    }

    public void turnOff() {
        isTurnedOn = false;
    }

    public void charge() throws InterruptedException {
        accumulator.charge();
    }

    public void startGame() {
        new DemoGame().play();
    }

    public void unlock() {
    }
}