public class LinkedList<E> {

	private ListNode<E> first;
	private ListNode<E> last;

	public LinkedList<E>() {
		first = last = null;
	}

	public addToFront(E data) {
		if (first == null) {
			first = last = new ListNode<E>(data);
		}
		else {
			ListNode<E> newNode = new ListNode<E>(data);
			newNode.setNext(first);
			first = newNode;
		}
	}

	public void addToBack(E data) {
		if (first == null) {
			ListNode<E> newNode = new ListNode<E>(data);
			first = newNode;
			last = newNode;
		}
		else {
			ListNode<E> newNode = new ListNode<E>(data);
			last.setNext(newNode);
			last = newNode;
		}
	}

	public int lengthIs() {
		int count = 0;
		ListNode<E> curr = first;

		while (curr != null) {
			curr = curr.getNext();
			count++;
		}

		return count;
	}

	public E removeFromFront() {
		E ret = null;
		if (first == null) {
			throw new EmptyListException();
		}
		else if (first == last) {
			ret = first.getData();
			first = last = null;
		}
		else {
			ret = first.getData();
			first = first.getNext();
		}

		return ret;
	}

	public E removeFromBack() {
		E ret = null;
		if (first == null) {
			throw new EmptyListException();
		}
		else if (first == last) {
			ret = first.getData();
			first = last = null;
		}
		else {
			ret = last.getData();
			ListNode<E> curr = first;
			while (curr.getNext() != last) {
				curr = curr.getNext();
			}
			curr.setNext(null);
			last = curr;
		}

		return ret;
	}

	public E get(int index) {
		ListNode<E> curr = first;
		if (index >= this.lengthIs() || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else {
			for (int count = 0; count < index; count++) {
				curr = curr.getNext();
			}

		}
		return curr.getData();
	}

	public E remove(int index) {
		ListNode<E> curr = first;
		E ret = null;
		if (index >= this.lengthIs() || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else if (first == last) {
			ret = first.getData();
			first = last = null;
		}
		else if (index == 0) {
			ret = removeFromFront();
		}
		else {
			ListNode<E> curr = first;
			for (int count = 0; count < index - 1; count++) {
				curr = curr.getNext();
			}

			ret = curr.getNext().getData();
			curr.setNext(curr.getNext().getNext());
		}

		return ret;
	}

}