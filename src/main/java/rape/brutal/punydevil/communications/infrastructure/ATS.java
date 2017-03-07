package rape.brutal.punydevil.communications.infrastructure;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by XXX on 14.02.2017.
 */
public class ATS implements IConnector {

    private static HashMap<Integer, ICallable> iCallableHashMap = new HashMap<>();

    public ATS() {
        System.out.println("ATS registered");

    }



    @Override
    public void call(String text, int callerNumber, int contactNumber) {
        ICallable iCallable = iCallableHashMap.get(contactNumber);
        if (callerNumber == contactNumber) {
            iCallable.receiveCall("Вы звоните самому себе!", callerNumber);
        } else {
            iCallable.receiveCall(text, callerNumber);
        }
    }

    @Override
    public void sendSMS(String text, int callerNumber, int contactNumber) {
        ICallable iCallable = iCallableHashMap.get(contactNumber);
        iCallable.receiveSMS(text, callerNumber);
    }

    @Override
    public void register(int number, ICallable iCallable) {
        iCallableHashMap.put(number, iCallable);
    }

    public void destroyAll() {

    }
}
