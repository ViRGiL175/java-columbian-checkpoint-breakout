package rape.brutal.punydevil.communications.phone.hardware;

public class Accumulator {

    private static final int MAX_CAPACITY = 1000;
    private int capacity = 0;

    public int getCapacity() {
        return capacity;
    }

    public void charge() throws InterruptedException {
        Thread.sleep(2000);
        do {
            capacity++;
        }
        while (capacity < MAX_CAPACITY);
        System.out.println("Батарея заряжена");
    }
}
