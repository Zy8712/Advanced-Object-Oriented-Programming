
public class LessThan extends Expression {

	LessThan(int left, int right) {
		super(left, right);
		this.left = left;
		this.right = right;

		this.value = this.left < this.right;
	}

	@Override
	void evaluate() {
		this.value = this.left < this.right;
	}

	public Object getValue() {
		return this.value;
	}

}
