
public class AddAll extends ExpressionCollector {

	AddAll() {
		super();
	}

	@Override
	void evaluate() {
		Integer sum = 0;
		for (Expression exp : this.e) {
			exp.evaluate();
			sum += (Integer) exp.getValue();
		}
		this.value = sum;
	}

	@Override
	Object getValue() {
		return this.value;
	}
}
