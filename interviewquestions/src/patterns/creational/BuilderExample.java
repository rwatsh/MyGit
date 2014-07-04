package patterns.creational;

class NutritionalFacts {
	private int sodium; // mandatory property

	// optional properties
	private int fat;
	private int carbo;

	/**
	 * A nested static class.
	 * 
	 */
	static class Builder {
		private int sodium;
		private int fat;
		private int carbo;

		/**
		 * Use constructor param for mandatory properties.
		 * 
		 * @param s
		 */
		public Builder(int s) {
			this.sodium = s;
		}

		/*
		 * Have methods for each property that return this.
		 * 
		 * @param f
		 * @return
		 */
		public Builder fat(int f) {
			this.fat = f;
			return this;
		}

		public Builder carbo(int c) {
			this.carbo = c;
			return this;
		}

		public NutritionalFacts build() {
			return new NutritionalFacts(this);
		}
	}

	private NutritionalFacts(Builder b) {
		this.sodium = b.sodium;
		this.fat = b.fat;
		this.carbo = b.carbo;
	}

	@Override
	public String toString() {
		return "NutritionalFacts [sodium=" + sodium + ", fat=" + fat
				+ ", carbo=" + carbo + "]";
	}
	
	
}
/**
 * Builder test.
 * 
 * @author Watsh
 *
 */
public class BuilderExample {
	public static void main(String[] args) {
		NutritionalFacts n = new NutritionalFacts.Builder(10).carbo(23).fat(1)
				.build();
		System.out.println(n);
	}

}
