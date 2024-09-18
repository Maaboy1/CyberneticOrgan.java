package CyberneticSystem.java.src;

import java.util.Random;

public class Lung extends Organ {
    private double oxygenLevel;

    public Lung() {
        super();
        this.oxygenLevel = 95.0; // Initial oxygen level
    }

    public double getOxygenLevel() {
        return oxygenLevel;
    }

    public void updateOxygenLevel(int heartPumpRate) {
        int randomFluctuation = new Random().nextInt(4) - 2; // Random fluctuation between -2 and 1
        oxygenLevel = Math.max(70.0, Math.min(100.0, oxygenLevel + (heartPumpRate / 20.0) - 3 + randomFluctuation));
    }

    public void updateHealth(int heartPumpRate) {
        int healthChange = (int) (-1 + (heartPumpRate / 25) - 2);
        changeHealth(healthChange);
    }
}

