#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
    int n, k;
    cin >> n;
    cin >> k;

    int psum[n + 1];
    psum[0] = 0;
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        psum[i + 1] = psum[i] + num;
    }

    int max = -100000000;
    for (int i = 0; i + k <= n; i++) {
        if (max < psum[i + k] - psum[i]) {
            max = psum[i + k] - psum[i];
        }
    }

    cout << max;

    return 0;
}