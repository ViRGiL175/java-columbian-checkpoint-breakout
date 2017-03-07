package rape.brutal.punydevil.communications.users;

import rape.brutal.punydevil.communications.phone.NoNamePhone;

import java.util.Objects;

/**
 * Created by Puny Devil on 01.03.2017.
 */
public class Geek extends User {

    private NoNamePhone geekPhone;

    public Geek(NoNamePhone userPhone) {
        super(userPhone);
        this.geekPhone = userPhone;
    }

    @Override
    public void hear(String text, int contactNumber) {
        super.hear(text, contactNumber);
        if (Objects.equals(text, "убью")){
            text = "по IP вычислю";
            call(contactNumber, text);
        }
    }

    @Override
    public void call(int number, String text) {
        geekPhone.phoneCall(text, number);
    }
}