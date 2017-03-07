package rape.brutal.punydevil.communications.users;

import rape.brutal.punydevil.communications.phone.NoNamePhone;
import rape.brutal.punydevil.communications.phone.Phone;

/**
 * Created by Puny Devil on 01.03.2017.
 */
public class Redneck extends User {

    private Phone redneckPhone;

    public Redneck(NoNamePhone userPhone) {
        super(userPhone);
        this.redneckPhone = userPhone;
    }

    @Override
    public void call(int number, String text) {
        System.out.println("the beginning of the call");
        redneckPhone.phoneCall(text, number);
    }
}
