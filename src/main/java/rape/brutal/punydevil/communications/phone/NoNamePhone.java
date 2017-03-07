package rape.brutal.punydevil.communications.phone;

import rape.brutal.punydevil.communications.infrastructure.IBroadcaster;
import rape.brutal.punydevil.communications.phone.hardware.SIM;

public class NoNamePhone extends Phone {

    private IBroadcaster iBroadcaster;

    public NoNamePhone(SIM sim) {
        super(sim);
    }

    public void setBroadcaster(IBroadcaster iBroadcaster) {
        this.iBroadcaster = iBroadcaster;
    }

    @Override
    public void unlock() {
        if (!isUnlock() && isTurnedOn()) {
            System.out.println("unlock kitayPhone");
            setUnlock(true);
        }
    }

    @Override
    public void startGame() {

    }

    public void watchTv(int number) {
        System.out.println(iBroadcaster.connectToTower(number));
    }
}
