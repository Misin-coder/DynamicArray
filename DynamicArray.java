package arrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;



/*
 * Dynamic arrays are arraylist in java,
 * Here, i have implemented arraylist with few of its method
 * 
 */

public class DynamicArray<E> implements Iterable<E>{

	private E[] array;
	private int capacity;
	private int currentElement;
	
	private class IteratorHelper implements Iterator<E> {
		int index = 0;

		@Override
		public boolean hasNext() {
			try {
				if(array[index] != null) {
					return true;
				} else return false;
			} catch(ArrayIndexOutOfBoundsException e) {
				return false;
			}
			
//			return (array[index] != null);
		}

		@Override
		public E next() {
			if (hasNext()) {
				return array[index++];
				
			}
			throw new NoSuchElementException();
		}

	}


	@SuppressWarnings("unchecked")
	public DynamicArray() {

		array = (E[]) new Object[1];
		capacity = 1;
		currentElement = 0;
	}

	public void push(E data) {
		if (currentElement == capacity) {
			resize();
		}
		array[currentElement] = data;
		currentElement++;
	}
	

	private void resize() {

		@SuppressWarnings("unchecked")
		E[] temp = (E[]) new Object[capacity * 2];
		for (int i = 0; i < capacity; i++) {
			temp[i] = array[i];
		}
		capacity = capacity * 2;
		array = temp;
	}

	public E pop() {

		if (currentElement < capacity / 2 ) {
			shrink();
		}
		currentElement--;
		E data = array[currentElement];
		array[currentElement] = null;
		return data;
	}

	private void shrink() {

		@SuppressWarnings("unchecked")
		E[] temp = (E[]) new Object[capacity = capacity / 2];
		for (int i = 0; i < capacity; i++) {
			temp[i] = array[i];
		}
		array = temp;
	}

	public void add(E data, int index)  {

		if (currentElement == capacity) {
			resize();
		}
		
		E value1 = array[index];
		array[index] = data;
		for (int i = index + 1; i < capacity; i++) {
			E value2 = array[i];
			array[i] = value1;
			value1 = value2;
		}
		currentElement++;
	}

	public E get(int index) {
		return array[index];
	}

	public int size() {
		return currentElement;
	}

	public int getCapacity() {
		return capacity;
	}

	public void print() {
		System.out.print("[ ");
		for (E x : array) {
			System.out.print(x + " ");
		}
		System.out.print(" ]");
	}

	@Override
	public Iterator<E> iterator() {
		return new IteratorHelper();
	}
}