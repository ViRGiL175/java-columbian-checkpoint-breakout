package rape.brutal.stephan.checkpoint.auto;

/**
 * Created by Mr. User on 06.03.2017.
 */
public interface IDestruyable {

    int getHitPoints();

    boolean isDestroyed();

    void makeDamage(int damage);

}
