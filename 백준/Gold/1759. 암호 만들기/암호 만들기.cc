#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

void recur(int dept, int idx, int check);

int l, c;
char* chars;
int vowel_check;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> l >> c;

	chars = new char[c + 1];
	for (int i = 0; i < c; i++) {
		cin >> chars[i];
	}
	chars[c] = '\0';
	
	sort(chars, chars + c);

	for (int i = 0; i < c; i++) {
		if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
			vowel_check += 1 << i;
		}
	}

	recur(0, 0, 0);

	return 0;
}

void recur(int dept, int idx, int check) {
	if (dept == l) {
		int con = 0;
		int vow = 0;
		vector<char> pw;
		for (int i = 0; i < c; i++) {
			if ((check & (1 << i)) != 0) {
				pw.push_back(chars[i]);
				if ((vowel_check & (1 << i)) != 0) {
					vow++;
				} else {
					con++;
				}
			}
		}
		if (con + vow == l && con >= 2 && vow >= 1) {
			for (int i = 0; i < l; i++) {
				cout << pw[i];
			}
			cout << "\n";
		}
		return;
	}

	for (int i = idx; i < c; i++) {
		recur(dept + 1, i + 1, check + (1 << i));
		recur(dept + 1, i + 1, check);
	}
}