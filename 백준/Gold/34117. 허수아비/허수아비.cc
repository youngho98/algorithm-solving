#define _CRT_SECURE_NO_WARNINGS

#include <cstdio>

constexpr int LM = 500000;
int N, P;
long long sum;
int arr[LM];

template<class T>
void swap(T& a, T& b) {
	T temp = a; a = b; b = temp;
}

struct PQ {
	int hn = 0;
	int heap[LM];
	int size() { return hn; }
	int top() { return heap[1]; }
	void push(int num) {
		heap[++hn] = num;
		for (int c = hn; c > 1; c >>= 1) {
			if (heap[c] < heap[c >> 1]) swap(heap[c], heap[c >> 1]);
		}
	}
	void pop() {
		swap(heap[1], heap[hn--]);
		for (int c = 2; c <= hn; c <<= 1) {
			if (c < hn && heap[c] > heap[c + 1]) c++;
			if (heap[c] < heap[c >> 1]) swap(heap[c], heap[c >> 1]);
		}
	}
}pq;

int main() {
	scanf("%d %d", &N, &P);
	for (int i = 0; i < N; i++) {
		scanf("%d", arr + i);
	}

	for (int i = 0; i < N; i++) {
		sum += arr[i];
		pq.push(arr[i]);
		if (sum < P) printf("%d ", -1);
		else {
			while (sum > P) {
				if (sum - pq.top() >= P) {
					sum -= pq.top();
					pq.pop();
				}
				else break;
			}
			printf("%d ", pq.size());
		}
	}

	return 0;
}
