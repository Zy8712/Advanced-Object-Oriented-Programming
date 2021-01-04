/* Make sure the instructions document is read carefully.
 * 
 * You are required to use the given `words` and `definitions` arrays to implement the methods.
 * See test_two_array_implementation_insert and test_two_array_implementation_remove 
 * in class TestArrayImplementations.
 * 
 * Requirements:
 * 		- You are not allowed to add new attributes to this class.
 * 		- You are not allowed to use any Java collection library (no import statements).
 * 
 * The idea is that both `words` and `definitions` are initialized as arrays of size `MAX_CAPACITY` with each slot storing null.
 * Entries (words and definitions) are added from left to right, whereas all free slots remain null.
 * When an entry is removed, all slots to its right are shifted to the left to close the gap.
 * 
 * For example, given a dictionary with four entries:
 * words:       {w1, w2, w3, w4, null, null, ...}
 * definitions: {d1, d2, d3, d4, null, null, ...}
 * Removing the entry for word `w2` has the resulting dictionary:
 * words:       {w1, w3, w4, null, null, null, ...}
 * definitions: {d1, d3, d4, null, null, null, ...}
 * 
 * You may consider studying this note on manipulating basic array:
 * https://www.eecs.yorku.ca/~jackie/teaching/lectures/2019/F/EECS2030/notes/EECS2030_F19_Notes_Tracing_PointCollectorTester.pdf
 */

public class TwoArrayDictionary implements Dictionary {

	/*
	 * Use these attributes only to implement the methods.
	 */
	int MAX_CAPACITY = 100;
	int count = 0; 
	String[] words;
	String[] definitions;

	/*
	 * Your tasks: declare and implement methods from the Dictionary interface.
	 */

	public TwoArrayDictionary() {
		this.words = new String[MAX_CAPACITY];
		this.definitions = new String[MAX_CAPACITY];
		this.count = 0;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String getDefinition(String word) throws WordNotInDictionaryException {
		if (this.isEmpty()) {
			throw new WordNotInDictionaryException();
		}
		for (int i = 0; i < this.count; i++) {
			if (this.words[i].equals(word)) {
				return this.definitions[i];
			}
		}
		throw new WordNotInDictionaryException();
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public void insertEntry(String word, String definition)
			throws WordAlreadyExistsInDictionaryException, DictionaryFullException {
		if (count <= 0) {
			this.words = new String[MAX_CAPACITY];
			this.definitions = new String[MAX_CAPACITY];
			this.words[this.count] = word;
			this.definitions[this.count] = definition;
			count++;
		} else {
			if (this.contains(word)) {
				throw new WordAlreadyExistsInDictionaryException();
			}
			if (this.isFull()) {
				throw new DictionaryFullException();
			}
			this.words[this.count] = word;
			this.definitions[this.count] = definition;
			count++;
		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public boolean contains(String word) {
		for (int i = 0; i < this.count; i++) {
			if (this.words[i].equals(word)) {
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
	public String removeWord(String word) throws WordNotInDictionaryException {
		if (this.count == 0) {
			throw new WordNotInDictionaryException();
		}
		boolean exists = false;
		for (int i = 0; i < this.count; i++) {
			if (this.words[i].equals(word)) {
				exists = true;
				break;
			}
		}
		if (exists == false) {
			throw new WordNotInDictionaryException();
		}
		int spot = 0;
		String def = "";
		for (int i = 0; i < this.count - 1; i++) { 
			if (this.words[i].equals(word)) {
				def = this.definitions[i];
				spot = i;
				this.words[i] = null;
				this.definitions[i] = null;
				break;
			}
		}
		for (int k = spot + 1; k < this.words.length; k++) {
			boolean go = true;
			for (int j = k - 1; go; j++) {
				this.words[j] = this.words[k];
				this.definitions[j] = this.definitions[k];
				go = false;
			}
		}
		this.count--;
		return def;
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
				if (this.words[i] == null) {
					break;
				}
				result[counter] = this.words[i];
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
		for (String w : this.definitions) {
			if (w == null) {
				break;
			}
			result[counter] = w;
			counter++;
		}
		return result;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public WordDefinitionPair[] getEntries() {
		WordDefinitionPair[] result = new WordDefinitionPair[this.count];
		for (int i = 0; i < result.length; i++) {
			result[i] = new WordDefinitionPair(this.words[i], this.definitions[i]);
		}
		return result;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public int size() {
		return this.count;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public boolean isEmpty() {
		return this.count <= 0;
	}
}
