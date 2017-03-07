package rape.brutal.haze.pc.human;

import rape.brutal.haze.pc.constructor.Engineer;
import rape.brutal.haze.pc.constructor.IUsable;
import rape.brutal.punydevil.communications.phone.Phone;


public class Sysadmin extends Engineer {

    public Sysadmin(Phone userPhone) {
        super(userPhone);
    }

    @Override
    protected void greeting() {
        System.out.println("Сисадмин: Привет!");
    }
    public void byeing() {
        System.out.println("Сисадмин: Пока! Заходи ещё! На все работы гарантия 1 год!");
    }
    public void choising() {
        System.out.println("Сисадмин: Для какого типа задач собрать тебе компьютер?");
    }


    public void use() {
    }

    @Override
    public void use(IUsable iUsable) {

    }
}



