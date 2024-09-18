package CyberneticSystem.java.src;

import java.util.Random;

public class Brain extends Organ {
    private int controlEfficiency;

    public Brain() {
        super ();
        this.controlEfficiency = 90;
    }

    public int getControlEfficiency() {
        return controlEfficiency;
    }

    public void updateControlEfficiency(double lungOxygenLevel) {
        int randomFluctuation = new Random().nextInt(4) - 2;
        controlEfficiency = Math.max(50, Math.min(100, controlEfficiency + (int)(lungOxygenLevel / 20) - 3 + randomFluctuation));
    }

    public void updateHealth(double lungOxygenLevel) {
        int healthChange = (int) (-1 + (lungOxygenLevel / 25) - 2);
        changeHealth(healthChange);
    }
}

