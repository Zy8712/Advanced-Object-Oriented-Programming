public class WordDefinitionPair {

	private String word;
	private String definition;

	WordDefinitionPair() {
		this.word = "";
		this.definition = "";
	}

	WordDefinitionPair(String word, String definition) {
		this.word = word;
		this.definition = definition;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getdefinition() {
		return definition;
	}

	public void setdefinition(String definition) {
		this.definition = definition;
	}

	boolean isEmpty() {
		return this.word == null && this.definition == null;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		WordDefinitionPair other = (WordDefinitionPair) obj;
		if (this.word.equals(other.word) && this.definition.equals(other.definition)) {
			return true;
		}
		return false;
	}
}
