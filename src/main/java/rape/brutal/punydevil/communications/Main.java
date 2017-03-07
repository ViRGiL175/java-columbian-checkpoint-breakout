package rape.brutal.punydevil.communications;

import rape.brutal.punydevil.communications.infrastructure.ATS;
import rape.brutal.punydevil.communications.infrastructure.IConnector;
import rape.brutal.punydevil.communications.infrastructure.TvTower;
import rape.brutal.punydevil.communications.phone.Iphone;
import rape.brutal.punydevil.communications.phone.NoNamePhone;
import rape.brutal.punydevil.communications.phone.Phone;
import rape.brutal.punydevil.communications.phone.hardware.SIM;
import rape.brutal.punydevil.communications.users.Geek;
import rape.brutal.punydevil.communications.users.Girl;
import rape.brutal.punydevil.communications.users.RussianGangster;
import rape.brutal.punydevil.communications.users.User;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        ATS ats = new ATS();
        ATS ats1 = new ATS();
        ATS ats2 = new ATS();
        ArrayList<IConnector> iConnectors = new ArrayList<>();
        iConnectors.add(ats);
        iConnectors.add(ats1);
        iConnectors.add(ats2);
        TvTower tvTower = new TvTower();

        SIM sim1 = new SIM(123456);
        Phone phone1 = new Iphone(sim1);
        phone1.addATSs(iConnectors);
        User user1 = new Girl((Iphone) phone1);

        SIM sim2 = new SIM(654321);
        Phone phone2 = new NoNamePhone(sim2);
        phone2.addATSs(iConnectors);
        User user2 = new Geek((NoNamePhone) phone2);

        SIM sim3 = new SIM(54321);
        Phone phone3 = new NoNamePhone(sim3);
        phone3.addATSs(iConnectors);
        User user3 = new RussianGangster((NoNamePhone) phone3);

        user1.call(654321, "убью");
    }
}