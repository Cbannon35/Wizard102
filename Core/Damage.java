public class Damage {

	private int[] damagePercent;
	private int[] damageFlat;

	public Damage() {
		this.damagePercent = new int[8];
		this.damageFlat = new int[8];
		for (int i = 0; i < damagePercent.size(); i++) {
			this.damagePercent[i] = 0;
			this.damageFlat[i] = 0;
		}
	}

	public Damage(int damagePercent[], int damageFlat[]) {
		this.damagePercent = damagePercent;
		this.damageFlat = damageFlat;
	}

}