package CyberneticSystem.java.src;

import java.util.Random;

public class Heart extends Organ {
    private int pumpRate;

    public Heart() {
        super();
        this.pumpRate = 70;
    }

    public int getPumpRate() {
        return pumpRate;
    }

    public void updatePumpRate(int brainControlEfficiency) {
        int randomFluctuation = new Random().nextInt(8) - 4;
        pumpRate = Math.max(40, Math.min(100, pumpRate + (brainControlEfficiency / 10) - 5 + randomFluctuation));
    }

    public void updateHealth(double lungOxygenLevel) {
        int healthChange = (int) (-1 + (lungOxygenLevel / 25) - 2);
        changeHealth(healthChange);
    }
}

