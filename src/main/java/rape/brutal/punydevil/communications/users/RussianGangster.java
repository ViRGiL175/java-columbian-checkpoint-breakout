package rape.brutal.punydevil.communications.users;

import rape.brutal.punydevil.communications.phone.NoNamePhone;
import rape.brutal.punydevil.communications.phone.Phone;

import java.util.Objects;

/**
 * Created by Puny Devil on 01.03.2017.
 */
public class RussianGangster extends User {

    private Phone russianGangsterPhone;

    public RussianGangster(NoNamePhone userPhone) {
        super(userPhone);
        this.russianGangsterPhone = userPhone;
    }

    @Override
    public void hear(String text, int contactNumber) {
        super.hear(text, contactNumber);
            if (Objects.equals(text, "убью")){
                text = "порешаю";
            call(contactNumber, text);
        }
    }

    @Override
    public void call(int number, String text) {
        russianGangsterPhone.phoneCall(text, number);
    }
}
