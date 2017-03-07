package rape.brutal.punydevil.communications.users;

import rape.brutal.punydevil.communications.phone.Iphone;
import rape.brutal.punydevil.communications.phone.NoNamePhone;

import java.util.Objects;

/**
 * Created by Puny Devil on 01.03.2017.
 */
public class Girl extends User {

    private Iphone girlPhone;

    public Girl(Iphone userPhone) {
        super(userPhone);
        this.girlPhone = userPhone;
    }

    @Override
    public void hear(String text, int contactNumber) {
        super.hear(text, contactNumber);
        if (Objects.equals(text, "убью")){
            text = "ты кто?";
            call(contactNumber, text);
        }
    }

    @Override
    public void call(int number, String text) {
        girlPhone.phoneCall(text, number);
    }
}
