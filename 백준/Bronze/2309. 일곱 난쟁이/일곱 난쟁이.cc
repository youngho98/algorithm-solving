#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int arr[9];
    int sum = 0;
    vector<int> v;

    for (int i = 0; i < 9; i++) {
        int num;
        cin >> num;
        arr[i] = num;
        sum += num;
    }
    for (int i = 0; i < 9; i++) {
        for (int j = i + 1; j < 9; j++) {
            if (sum - arr[i] - arr[j] == 100) {
                for (int k = 0; k < 9; k++) {
                    if (k != i && k != j) {
                        v.push_back(arr[k]);
                    }
                }
                goto Exit;
            }
        }
    }
    Exit:
    sort(v.begin(), v.end());
    for (int i : v) {
        cout << i << "\n";
    }
}