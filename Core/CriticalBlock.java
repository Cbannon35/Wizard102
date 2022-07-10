public class CriticalBlock {

	private int[] criticalBlock;

	public CriticalBlock() {
		this.criticalBlock = new int[8];
		for (int i = 0; i < criticalBlock.size(); i++) {
			this.criticalBlock[i] = 0;
		}
	}

	public CriticalBlock(int criticalBlock[]) {
		this.criticalBlock = criticalBlock;
	}

}