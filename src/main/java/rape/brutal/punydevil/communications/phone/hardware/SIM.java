package rape.brutal.punydevil.communications.phone.hardware;

/**
 * Created by XXX on 14.02.2017.
 */
public class SIM {

    public SIM() {
        System.out.println("created sim");
    }

    private int number;

    public SIM(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
