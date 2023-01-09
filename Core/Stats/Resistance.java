public class Resistance {

	private int[] resistancePercent;
	private int[] resistanceFlat;

	public Resistance() {
		this.resistancePercent = new int[8];
		this.resistanceFlat = new int[8];
		for (int i = 0; i < resistancePercent.length; i++) {
			this.resistancePercent[i] = 0;
			this.resistanceFlat[i] = 0;
		}
	}

	public Resistance(int resistancePercent[], int resistanceFlat[]) {
		this.resistancePercent = resistancePercent;
		this.resistanceFlat = resistanceFlat;
	}

}