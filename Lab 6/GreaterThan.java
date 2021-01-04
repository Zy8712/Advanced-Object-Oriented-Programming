
public class GreaterThan extends Expression {

	private boolean booleanVal;

	GreaterThan(int left, int right) {
		super(left, right);

		this.left = left;
		this.right = right;

		this.booleanVal = this.left > this.right;
		this.value = this.booleanVal;
	}

	@Override
	void evaluate() {
		this.booleanVal = this.left > this.right;
		this.value = this.booleanVal;
	}

	public Object getValue() {
		return this.value;
	}

}
