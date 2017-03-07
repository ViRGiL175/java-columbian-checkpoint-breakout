package rape.brutal.punydevil.communications.infrastructure;

/**
 * Created by XXX on 14.02.2017.
 */
public interface IConnector {

    void call(String text, int callerNumber, int contactNumber);

    void sendSMS(String text, int callerNumber, int contactNumber);

    void register(int number, ICallable iCallable);
}
