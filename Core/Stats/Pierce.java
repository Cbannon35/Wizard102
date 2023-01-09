package Stats;
public class Pierce {

	private int[] pierce;

	public Pierce() {
		this.pierce = new int[8];
		for (int i = 0; i < pierce.length; i++) {
			this.pierce[i] = 0;
		}
	}

	public Pierce(int pierce[]) {
		this.pierce = pierce;
	}

}