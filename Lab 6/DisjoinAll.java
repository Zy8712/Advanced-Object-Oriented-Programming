
public class DisjoinAll extends ExpressionCollector {

	DisjoinAll() {
		super();
	}

	@Override
	void evaluate() {
		Boolean result = false;
		if (this.e.size() == 0) {
			this.value = true;
		} else {
			for (Expression exp : this.e) {
				exp.evaluate();
				result = result || (Boolean) exp.value;
			}
		}
		this.value = result;
	}

	@Override
	Object getValue() {
		return this.value;
	}

}
