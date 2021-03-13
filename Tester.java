package arrayList;


public class Tester {

	public static void main(String[] args)  {
		
		DynamicArray<Integer> array = new DynamicArray<>();
		for(int i = 0; i < 8; i++) {
			array.push(i);
		}
		
		array.add(4, 5);
		
		
	
		
		for(int x : array) {
			System.out.println(x);
		}
		
		
	}

}
