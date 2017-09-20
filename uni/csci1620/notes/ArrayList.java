public class ArrayList<E extends Comparable<E>> { // <E> is a temporary type, not a real data type, can also set bounds, E must implement Comparable
	private Object[] list; // java doesn't let us create arrays of generics
	private int numElements;
	private int origCap;
	private final int DEFCAP = 50;

	public ArrayList() {
		list = new Object[DEFCAP];
		numElements = 0;
		origCap = DEFCAP;
	}

	public ArrayList(int initSize) {
		if (initSize < 1 || initSize > DEFCAP) {
			throw new InvalidInitialSizeException();
		}

		list = new Object[initSize];
		numElements = 0;
		origCap = initSize;
	}

	public void addItem(E item) {
		if (numElements == list.length)
			enlarge();
		list[numElements++] = item;
	}

	public E remove(int index) {
		if (index < 0 || index >= numElements)
			throw new ArrayListIndexOutOfBoundsException(); // also create this class

		E ret = (E)list[index]; // ret is type E, list[index] is Object, need to cast it

		list[index] = list[numElements-1];
		numElements--;
		return ret;
	}

	private void enlarge() {
		if (numElements == DEFCAP) {
			throw new MaximumCapacityException(); // should create this class
		}

		int newSize;
		if (numElements + origCap <= DEFCAP)
			newSize = numElements + origCap;
		else
			newSize = DEFCAP;

		// create larger array
		Object larger[] = new Object[newSize];
		for (int i = 0; i < numElements; i++)
			larger[i] = list[i];

		list = larger;
	}

	public int size() {
		return numElements;
	}

	public boolean isEmpty() {
		return !(numElements > 0);
	}

	public void clear() {
		list = new Object[origCap];
		numElements = 0;
	}

	public int find(E item) {
		int pos = -1;
		for (int i = 0; i < numElements; i++) {
			if (list[i].equals(item)) {
				pos = i;
				break;
			}
		}

		return pos;
	}

	public E get(int index) {
		if (index < 0 || index >= numElements)
			throw new ArrayListIndexOutOfBoundsException();
		return (E)list[index]; // again, cast it properly
	}
}