public class Accuracy {

	private int[] accuracy;

	public Accuracy() {
		this.accuracy = new int[8];
		for (int i = 0; i < accuracy.size(); i++) {
			this.accuracy[i] = 0;
		}
	}

	public Accuracy(int accuracy[]) {
		this.accuracy = accuracy;
	}

}