
public class Multiplication extends Expression {

	private int product;

	Multiplication(int left, int right) {
		super(left, right);

		this.left = left;
		this.right = right;

		this.product = this.left * this.right;
		this.value = this.product;
	}

	/**
	 * Evaluates the current expression and puts the result in an Expression.value
	 * field
	 */
	@Override
	void evaluate() {
		this.product = this.left * this.right;
		this.value = this.product;
	}

	public Object getValue() {
		return this.value;
	}

}
