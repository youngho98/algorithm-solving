import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	static int[] sortedArr;
	static int k;
	static int cnt;
	static int answer = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		sortedArr = new int[n];
		int start = 0;
		int end = arr.length - 1;
		mergeSort(start, end);
		
		System.out.println(answer);
	}
	
	static void mergeSort(int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(start, mid);
			mergeSort(mid + 1, end);
			merge(start, mid, end);
		}
	}
	
	static void merge(int start, int mid, int end) {
		int left = start;
		int right = mid + 1;
		int idx = start;
		while (left <= mid && right <= end) {
			if (arr[left] < arr[right]) {
				sortedArr[idx++] = arr[left++];
				cnt++;
				if (cnt == k) {
					answer = sortedArr[idx - 1];
				}
			} else {
				sortedArr[idx++] = arr[right++];
				cnt++;
				if (cnt == k) {
					answer = sortedArr[idx - 1];
				}
			}
		}
		while (left <= mid) {
			sortedArr[idx++] = arr[left++];
			cnt++;
			if (cnt == k) {
				answer = sortedArr[idx - 1];
			}
		}
		while (right <= end) {
			sortedArr[idx++] = arr[right++];
			cnt++;
			if (cnt == k) {
				answer = sortedArr[idx - 1];
			}
		}
		
		for (int i = start; i <= end; i++) {
			arr[i] = sortedArr[i];
		}
	}
	
}