import stats.*;

public class Stats {

    private int health;
    private int mana;
    private int energy;
    private Damage damage;
    private Resistance resistance;
    private Accuracy accuracy;
    private Critical critical;
    private CriticalBlock criticalBlock;
    private Pierce pierce;
    private int stunResistance;
    private int incomingHeal;
    private int outgoingHeal;
    private int powerPipRating;
    private int shadowPipRating;
    private int archmasteryRating;
   
    public Stats() {
        this.health = 0; 
        this.mana = 0;
        this.energy = 0;
        this.damage = null;
        this.resistance = null;
        this.accuracy = null;
        this.critical = null;
        this.criticalBlock = null;
        this.pierce = null;
        this.stunResistance = 0;
        this.incomingHeal = 0;
        this.outgoingHeal = 0;
        this.powerPipRating = 0;
        this.shadowPipRating = 0;
        this.archmasteryRating = 0;
    }

    public Stats(int health, int mana, int energy, Damage damage, Resistance resistance, Accuracy accuracy, Critical critical, CriticalBlock criticalBlock, Pierce pierce, int stunResistance, int incomingHeal, int outgoingHeal, int powerPipRating, int shadowPipRating, int archmasteryRating) {
        this.health = health; 
        this.mana = mana;
        this.energy = energy;
        this.damage = damage;
        this.resistance = resistance;
        this.accuracy = accuracy;
        this.critical = critical;
        this.criticalBlock = criticalBlock;
        this.pierce = pierce;
        this.stunResistance = stunResistance;
        this.incomingHeal = incomingHeal;
        this.outgoingHeal = outgoingHeal;
        this.powerPipRating = powerPipRating;
        this.shadowPipRating = shadowPipRating;
        this.archmasteryRating = archmasteryRating;
    }
}