package CyberneticSystem.java.src;

public class Organ {
    protected int health;

    public Organ() {
        this.health = 100;
    }

    public int getHealth() {
        return health;
    }

    public void changeHealth(int change) {
        health = Math.max(0, Math.min(100, health + change));
    }
}