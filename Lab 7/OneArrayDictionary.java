/*
 * You are required to use the given `dict` array to implement the methods.
 * See test_one_array_implementation_insert and test_one_array_implementation_remove 
 * in class TestArrayImplementations.
 *
 * Requirements:
 * 		- You are not allowed to add new attributes to this class.
 * 		- You are not allowed to use any Java collection library (no import statements).
 * 
 * The idea is that `dict` is initialized as an array of size `MAX_CAPACITY` with each slot storing null.
 * Entries are added from left to right, whereas all free slots remain null.
 * When an entry is removed, all slots to its right are shifted to the left to close the gap.
 * 
 * For example, given a dictionary with four entries:
 * {(w1, d1), (w2, d2), (w3, d3), (w4, d4), null, null, ...} 
 * Removing the entry for word `w2` has the resulting dictionary:
 * {(w1, d1), (w3, d3), (w4, d4), null, null, null, ...}
 * 
 * You may consider studying this note on manipulating basic array:
 * https://www.eecs.yorku.ca/~jackie/teaching/lectures/2019/F/EECS2030/notes/EECS2030_F19_Notes_Tracing_PointCollectorTester.pdf
 */

public class OneArrayDictionary implements Dictionary {

	int MAX_CAPACITY = 100;
	int count = 0;
	WordDefinitionPair[] dict;

	/*
	 * Your tasks: declare and implement methods from the Dictionary interface.
	 */

	public OneArrayDictionary() {
		this.dict = new WordDefinitionPair[MAX_CAPACITY];
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public int size() {
		return this.count;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public boolean isEmpty() {
		return this.count == 0;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void insertEntry(String word, String definition)
			throws DictionaryFullException, WordAlreadyExistsInDictionaryException {
		if (count <= 0) {
			this.dict = new WordDefinitionPair[MAX_CAPACITY];
			this.dict[this.count] = new WordDefinitionPair(word, definition);
			this.count++;
		} else {
			if (this.contains(word)) {
				throw new WordAlreadyExistsInDictionaryException();
			}
			if (this.isFull()) {
				throw new DictionaryFullException();
			}
			this.dict[this.count] = new WordDefinitionPair(word, definition);
			count++;
		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public boolean contains(String word) {
		for (int i = 0; i < this.count; i++) {
			if (this.dict[i].getWord().equals(word)) {
				return true;
			}
		}
		return false;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public boolean isFull() {
		return this.count >= 99;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public String getDefinition(String word) throws WordNotInDictionaryException {
		if (this.isEmpty()) {
			throw new WordNotInDictionaryException();
		}
		for (int i = 0; i < this.count; i++) {
			if (this.dict[i].getWord().equals(word)) {
				return this.dict[i].getdefinition();
			}
		}
		throw new WordNotInDictionaryException();
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public String removeWord(String word) throws WordNotInDictionaryException {
		int locate = 0;
		String definition = "";
		boolean ex = false;
		if (this.count == 0) {
			throw new WordNotInDictionaryException();
		}
		for (int i = 0; i < this.count; i++) {
			if (this.dict[i].getWord().equals(word)) {
				ex = true;
				break;
			}
		}
		if (ex == false) {
			throw new WordNotInDictionaryException();
		}
		for (int i = 0; i < this.count - 1; i++) { 
			if (this.dict[i].getWord().equals(word)) {
				definition = this.dict[i].getdefinition();
				locate = i;
				this.dict[i] = null;
				break;
			}
		}
		for (int i = locate + 1; i < this.dict.length; i++) {
			boolean go = true;
			for (int j = i - 1; go; j++) {
				this.dict[j] = this.dict[i];
				go = false;
			}
		}
		this.count--;
		return definition;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public String[] getWords() {
		if (this.count <= 0) {
			return new String[] {};
		} else {
			String[] result = new String[count];
			int counter = 0;
			for (int i = 0; i < this.count; i++) {
				if (this.dict[i] == null) {
					break;
				}
				result[counter] = this.dict[i].getWord();
				counter++;
			}
			return result;
		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public String[] getDefinitions() {
		String[] result = new String[count];
		int counter = 0;
		for (WordDefinitionPair pair : this.dict) {
			if (pair == null) {
				break;
			}
			result[counter] = pair.getdefinition();
			counter++;
		}
		return result;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public WordDefinitionPair[] getEntries() {
		WordDefinitionPair[] results = new WordDefinitionPair[this.count];
		if (this.count <= 0) {
			return new WordDefinitionPair[] {};
		} else {
			for (int i = 0; i < this.count; i++) {
				results[i] = new WordDefinitionPair(this.dict[i].getWord(), this.dict[i].getdefinition());
			}
		}
		return results;
	}
}
