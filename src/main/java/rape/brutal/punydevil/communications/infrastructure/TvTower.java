package rape.brutal.punydevil.communications.infrastructure;

import java.util.HashMap;

/**
 * Created by XXX on 23.02.2017.
 */
public class TvTower implements IBroadcaster {
    private HashMap<Integer, String> tvProgram = new HashMap<>();

    public TvTower() {
        tvProgram.put(1, "какие-то шумы");
        tvProgram.put(2, "новости на китайском");
        tvProgram.put(3, "японские мультики");
        tvProgram.put(4, "улицы разбитых фонарей");
        tvProgram.put(5, "какие-то шумы");
        tvProgram.put(666, "Сцены из гуро хентая перемежаются с вставками из Boku no Pico");
    }

    public String connectToTower(int chanel){
        return tvProgram.get(chanel);
    }
}
