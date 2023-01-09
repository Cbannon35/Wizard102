package Stats;

public class Critical {

	private int[] critical;

	public Critical() {
		this.critical = new int[8];
		for (int i = 0; i < critical.length; i++) {
			this.critical[i] = 0;			
		}
	}

	public Critical(int critical[]) {
		this.critical = critical;
	}

}