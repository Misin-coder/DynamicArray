package arrayList;


public class Tester {

	public static void main(String[] args) {
		
		DynamicArray<Integer> array = new DynamicArray<>();
		for(int i = 0; i < 10; i++) {
			array.push(i);
		}
		array.pop();
		array.pop();
		array.pop();
		array.pop();
		array.add(2,2);
		
		for(int x : array) {
			System.out.println(x);
		}
		
	}

}
