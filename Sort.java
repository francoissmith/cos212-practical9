
// Name:
// Student number:
import java.util.Arrays;

public class Sort {

	////// Implement the functions below this line //////

	/********** MERGE **********/
	public static <T extends Comparable<? super T>> void mergesort(T[] data, int first, int last, boolean debug) {
		// Your code here
		if (first < last) {
			int mid = (first + last) / 2;
			mergesort(data, first, mid, debug);
			mergesort(data, mid + 1, last, debug);
			merge(data, first, last, debug);
		}
	}

	private static <T extends Comparable<? super T>> void merge(T[] data, int first, int last, boolean debug) {

		// Your code here
		int mid = (first + last) / 2;
		int it1 = first;
		int it2 = first;
		int it3 = mid + 1;

		T[] temp = data.clone();

		for (int i = first; i <= last; i++) {
			temp[i] = data[i];
		}

		while (it2 <= mid && it3 <= last) {
			if (temp[it2].compareTo(temp[it3]) < 0) {
				data[it1++] = temp[it2++];
			} else {
				data[it1++] = temp[it3++];
			}
		}

		while (it2 <= mid) {
			data[it1++] = temp[it2++];
		}

		// DO NOT MOVE OR REMOVE!
		if (debug)
			System.out.println(Arrays.toString(data));
	}

	/********** COUNTING **********/
	public static void countingsort(int[] data, boolean debug) {
		// Your code here
		int n = data.length, lg = getLargest(data);
		int[] temp = new int[n];
		int[] count = new int[lg + 1];

		for (int i = 0; i <= lg; i++) {
			count[i] = 0;
		}

		for (int i = 0; i < n; i++) {
			count[data[i]]++;
		}

		for (int i = 1; i < lg + 1; i++) {
			count[i] = count[i - 1] + count[i];
		}

		for (int i = n - 1; i >= 0; i--) {
			temp[count[data[i]] - 1] = data[i];
			count[data[i]]--;
		}

		for (int i = 0; i < n; i++) {
			data[i] = temp[i];
		}

		// DO NOT MOVE OR REMOVE!
		if (debug)
			System.out.println(Arrays.toString(data));
	}

	public static int getLargest(int[] data) {
		int largest = data[0];

		for (int i = 1; i < data.length; i++)
			if (largest < data[i]) {
				largest = data[i];
			}

		return largest;
	}

}