#include <iostream>
#include <string>
#include <map>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int t;
    cin >> t;

    for (int i = 0; i < t; i++) {
        int n;
        cin >> n;

        map<string, int> clothes;
        for (int j = 0; j < n; j++) {
            string name, category;
            cin >> name >> category;
            if (clothes.find(category) == clothes.end()) {
                clothes[category] = 1;
            } else {
                clothes[category]++;
            }
        }

        int answer = 1;
        for (auto it : clothes) {
            answer *= it.second + 1;
        }

        cout << answer - 1 << "\n";
    }

    return 0;
}