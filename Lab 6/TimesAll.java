
public class TimesAll extends ExpressionCollector {

	@Override
	void evaluate() {
		if (this.e.size() == 0) {
			this.value = 1;
		} else {
			Integer runprod = 1;
			for (Expression exp : this.e) {
				exp.evaluate();
				runprod *= (Integer) exp.getValue();
			}
			this.value = runprod;
		}
	}

	@Override
	Object getValue() {
		return this.value;
	}
}
