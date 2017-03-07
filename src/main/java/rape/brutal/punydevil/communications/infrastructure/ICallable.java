package rape.brutal.punydevil.communications.infrastructure;

/**
 * Created by XXX on 14.02.2017.
 */
public interface ICallable {

    public void receiveCall(String text, int contactNumber);

    public void receiveSMS(String text, int contactNumber);

}
