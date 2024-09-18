
package CyberneticSystem.java.src;

import java.util.Random;

public class CyberneticSystem {
    private Heart heart;
    private Lung lung;
    private Brain brain;
    private int time;
    private Random random;

    public CyberneticSystem() {
        heart = new Heart();
        lung = new Lung();
        brain = new Brain();
        time = 100;
        random = new Random();
    }

    public void runSimulation(int step) {
        if (step == 0 || heart.getHealth() <= 0 || lung.getHealth() <= 0 || brain.getHealth() <= 0) {
            printFinalSummary(step);
            return;
        }

        heart.updatePumpRate(brain.getControlEfficiency());
        heart.updateHealth(lung.getOxygenLevel());

        lung.updateOxygenLevel(heart.getPumpRate());
        lung.updateHealth(heart.getPumpRate());

        brain.updateControlEfficiency(lung.getOxygenLevel());
        brain.updateHealth(lung.getOxygenLevel());

        printStatus(step);

        if (random.nextDouble() < 0.10) {
            triggerRandomEvent(step);
        }

        checkHealthAlerts(step);

        runSimulation(step - 1);
    }

    private void printStatus(int step) {
        System.out.println("Time: " + step);
        System.out.println("Heart Health: " + heart.getHealth() + " | Pump Rate: " + heart.getPumpRate());
        System.out.println("Lung Health: " + lung.getHealth() + " | Oxygen Level: " + lung.getOxygenLevel());
        System.out.println("Brain Health: " + brain.getHealth() + " | Control Efficiency: " + brain.getControlEfficiency());
        System.out.println();
    }

    private void triggerRandomEvent(int step) {
        int organ = random.nextInt(3); // 0 = Heart, 1 = Lung, 2 = Brain
        int healthChange = random.nextInt(21) - 10; // Random health change between -10 and 10

        switch (organ) {
            case 0:
                heart.changeHealth(healthChange);
                System.out.println("EVENT at Time " + step + ": Random health change for Heart by " + healthChange + " points");
                break;
            case 1:
                lung.changeHealth(healthChange);
                System.out.println("EVENT at Time " + step + ": Random health change for Lung by " + healthChange + " points");
                break;
            case 2:
                brain.changeHealth(healthChange);
                System.out.println("EVENT at Time " + step + ": Random health change for Brain by " + healthChange + " points");
                break;
        }
    }

    private void checkHealthAlerts(int step) {
        if (heart.getHealth() < 25) {
            System.out.println("ALERT at Time " + step + ": Heart Critical! Health at " + heart.getHealth() + "%");
        }
        if (lung.getHealth() < 25) {
            System.out.println("ALERT at Time " + step + ": Lung Critical! Health at " + lung.getHealth() + "%");
        }
        if (brain.getHealth() < 25) {
            System.out.println("ALERT at Time " + step + ": Brain Critical! Health at " + brain.getHealth() + "%");
        }
    }

    private void printFinalSummary(int step) {
        System.out.println("Simulation Ended:");
        System.out.println("Time: " + step);
        System.out.println("Heart Health: " + heart.getHealth());
        System.out.println("Lung Health: " + lung.getHealth());
        System.out.println("Brain Health: " + brain.getHealth());

        if (heart.getHealth() <= 0 || lung.getHealth() <= 0 || brain.getHealth() <= 0) {
            System.out.println("Simulation Result: Failure");
        } else {
            System.out.println("Simulation Result: Success");
        }
    }

    public static void main(String[] args) {
        CyberneticSystem simulation = new CyberneticSystem();
        simulation.runSimulation(100); // Start the simulation with 100 time steps
    }
}
