import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;


public class ListComparison {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Initialize the size for lists
		final int size = 1000000;
		
		//Set the target linkedlist and arraylist
		LinkedList<String> myLinkedList = new LinkedList<String>();
		ArrayList<String> myArrayList = new ArrayList<>(size);
		
		//Record the time adding entries for linkedlist
		long startTime = System.nanoTime();
		for(int i = 0;i<size;i++) {
			myLinkedList.add("a");
		}
		long endTime = System.nanoTime();
		
		double totalTime = (double)(endTime-startTime)/1000000000.0;
		
		System.out.println("LinkedList add: " + totalTime + "sec");
		
		//Record the time adding entries for arraylist
		startTime = System.nanoTime();
		for(int i = 0;i<size;i++) {
			myArrayList.add("a");
		}
		endTime = System.nanoTime();
		
		totalTime = (double)(endTime-startTime)/1000000000.0;
		
		System.out.println("Arraylist add: " + totalTime + "sec");
		
		//Set iterators for my linkedlist and arraylist
		ListIterator<String> itr1 = myLinkedList.listIterator();
		ListIterator<String> itr2 = myArrayList.listIterator();
		
		//Record the time getting entries for linkedlist
		startTime = System.nanoTime();
		while(itr1.hasNext()) {
			itr1.next();
		}
		endTime = System.nanoTime();
		
		totalTime = (double)(endTime-startTime)/1000000000.0;
		
		System.out.println("LinkedList get: " + totalTime + "sec");
		
		//Record the time getting entries for arraylist
		startTime = System.nanoTime();
		while(itr2.hasNext()) {
			itr2.next();
		}
		endTime = System.nanoTime();
		
		totalTime = (double)(endTime-startTime)/1000000000.0;
		
		System.out.println("Arraylist get: " + totalTime + "sec");
		
		//Set another for linkedlist
		ListIterator<String> itr3 = myLinkedList.listIterator();
		
		//Record the time removing entries for linkedlist
		startTime = System.nanoTime();
		while(itr3.hasNext()) {
			itr3.next();
			itr3.remove();
		}
		endTime = System.nanoTime();
		
		totalTime = (double)(endTime-startTime)/1000000000.0;
		
		System.out.println("LinkedList remove: " + totalTime + "sec");
		
		//Record the time removing entries for arraylist
		startTime = System.nanoTime();
		for(int i = size-1;i>=0;i--) {
			myArrayList.remove(i);
		}

		endTime = System.nanoTime();
		
		totalTime = (double)(endTime-startTime)/1000000000.0;
		
		System.out.println("Arraylist remove: " + totalTime + "sec");
	}

}
