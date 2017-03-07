package rape.brutal.punydevil.communications.users;

import rape.brutal.haze.pc.constructor.IUsable;
import rape.brutal.haze.pc.human.Human;
import rape.brutal.punydevil.communications.phone.NoNamePhone;
import rape.brutal.punydevil.communications.phone.Phone;

import java.io.IOException;
import java.util.Objects;

/**
 *
 */


public class User extends Human {

    private Phone userPhone;

    public User(Phone userPhone) {
        System.out.println("User buy phone");
        this.userPhone = userPhone;
        this.userPhone.setUser(this);
    }

    void pressPowerButton() throws InterruptedException, IOException {
        userPhone.turnOn();
        userPhone.unlock();
    }

    public void playGame() {
        userPhone.startGame();
    }

    public Phone getUserPhone() {
        return userPhone;
    }

    public void hear(String text, int contactNumber){

    }

    public void call(int number, String text) {

        userPhone.phoneCall(text, number);
    }

    public void SMS(int number, String text) throws InterruptedException, IOException {
        System.out.println("sms recruited");
        userPhone.phoneSMS(text, number);
    }

    public void charge() throws Exception {
        userPhone.charge();
    }

    public void watchTV(int number) {
        if (Objects.equals(userPhone.getClass().getName(), NoNamePhone.class.getName())) {
            ((NoNamePhone) userPhone).watchTv(number);
        } else {
            System.out.println("Функции ТВ в телефоне нет");
        }
    }

    @Override
    protected void greeting() {

    }

    @Override
    protected void byeing() {

    }

    @Override
    public void use(IUsable iUsable) {

    }


}