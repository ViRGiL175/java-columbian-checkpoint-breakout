package rape.brutal.punydevil.communications.phone;


import rape.brutal.punydevil.communications.phone.hardware.SIM;

public class Iphone extends Phone {


    public Iphone(SIM sim) {
        super(sim);
    }

    void FingerPrint() {

    }

    @Override
    public void startGame() {

    }

    @Override
    public void unlock() {
        if (!isUnlock && isTurnedOn) {
            System.out.println("Unlock Iphone");
            isUnlock = true;
        }
    }
}
