
public class Equal extends Expression {

	private boolean booleanVal;

	Equal(int left, int right) {
		super(left, right);

		this.left = left;
		this.right = right;

		this.booleanVal = this.left == this.right;
		this.value = this.booleanVal;
	}

	/**
	 * Evaluates the current expression and puts the resusult in an Expression.value
	 * field
	 */
	@Override
	void evaluate() {
		this.booleanVal = this.left == this.right;
		this.value = this.booleanVal;
	}

	public Object getValue() {
		return this.value;
	}

}
