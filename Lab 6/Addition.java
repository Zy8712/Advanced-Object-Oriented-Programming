
public class Addition extends Expression {

	private int sum;

	/**
	 * Creates a new Addition Object. The fields leftOperand and rightOperand are extended from the Expression
	 * superclass. 
	 * @param left The Left Operand of this Expression.
	 * @param right the Right Operand of this Expression.
	 */
	Addition(int left, int right) {
		super(left, right);
		this.left = left;
		this.right = right;
		
		this.sum = this.left + this.right;
		this.value = this.sum;
	}
	
	/**
	 * Evaluates the current expression and puts the result in an Expression.value field
	 */
	@Override
	void evaluate() {
		this.sum = this.left + this.right;
		this.value = this.sum;
	}
	
	public Object getValue() {
		return this.value;
	}

}
