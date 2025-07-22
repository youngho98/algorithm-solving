#include <iostream>
#include <vector>
#include <string>

using namespace std;

vector<int> v;

int search(int idx);
bool pop();
bool inv();
bool dup();
bool swp();
bool add();
bool sub();
bool mul();
bool div();
bool mod();

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string s;
	vector<string> cmd;
	bool command = true;

	while (true) {
		getline(cin, s);
		if (s == "QUIT") {
			return 0;
		} else if (s == "END") {
			command = false;
		} else if (s == "") {
			command = true;
			cout << "\n";
			continue;
		}

		if (command) {
			cmd.push_back(s);
			continue;
		} else {
			int n;
			cin >> n;
			for (int i = 0; i < n; i++) {
				v.clear();
				int number;
				cin >> number;
				cin.ignore();
				v.push_back(number);
				bool err = false;
				for (string c : cmd) {
					if (c == "POP") {
						if (!pop()) {
							cout << "ERROR\n";
							err = true;
							break;
						}
					} else if (c == "INV") {
						if (!inv()) {
							cout << "ERROR\n";
							err = true;
							break;
						}
					} else if (c == "DUP") {
						if (!dup()) {
							cout << "ERROR\n";
							err = true;
							break;
						}
					} else if (c == "SWP") {
						if (!swp()) {
							cout << "ERROR\n";
							err = true;
							break;
						}
					} else if (c == "ADD") {
						if (!add()) {
							cout << "ERROR\n";
							err = true;
							break;
						}
					} else if (c == "SUB") {
						if (!sub()) {
							cout << "ERROR\n";
							err = true;
							break;
						}
					} else if (c == "MUL") {
						if (!mul()) {
							cout << "ERROR\n";
							err = true;
							break;
						}
					} else if (c == "DIV") {
						if (!div()) {
							cout << "ERROR\n";
							err = true;
							break;
						}
					} else if (c == "MOD") {
						if (!mod()) {
							cout << "ERROR\n";
							err = true;
							break;
						}
					} else {
						v.push_back(stoi(c.substr(4)));
					}
				}
				if (err) {
					continue;
				}
				if (v.size() != 1) {
					cout << "ERROR\n";
					continue;
				}
				cout << v[0] << "\n";
			}
		}
		cmd.clear();
	}

	return 0;
}

int search(int idx) {
	return v[v.size() - idx];
}

bool pop() {
	if (v.size() < 1) {
		return false;
	}
	v.pop_back();
	return true;
}

bool inv() {
	if (v.size() < 1) {
		return false;
	}
	int a = search(1);
	v.pop_back();
	v.push_back(-a);
	return true;
}

bool dup() {
	if (v.size() < 1) {
		return false;
	}
	int a = search(1);
	v.push_back(a);
	return true;
}

bool swp() {
	if (v.size() < 2) {
		return false;
	}
	int a = search(1);
	int b = search(2);
	v.pop_back();
	v.pop_back();
	v.push_back(a);
	v.push_back(b);
	return true;
}

bool add() {
	if (v.size() < 2) {
		return false;
	}
	int a = search(1);
	int b = search(2);
	if (abs(a + b) > 1e9) {
		return false;
	}
	v.pop_back();
	v.pop_back();
	v.push_back(a + b);
	return true;
}

bool sub() {
	if (v.size() < 2) {
		return false;
	}
	int a = search(1);
	int b = search(2);
	if (abs(b - a) > 1e9) {
		return false;
	}
	v.pop_back();
	v.pop_back();
	v.push_back(b - a);
	return true;
}

bool mul() {
	if (v.size() < 2) {
		return false;
	}
	int a = search(1);
	int b = search(2);
	if ((double)a * (double)b > 1e9 || (double)a * (double)b < -1e9) {
		return false;
	}
	v.pop_back();
	v.pop_back();
	v.push_back(a * b);
	return true;
}

bool div() {
	if (v.size() < 2) {
		return false;
	}
	int a = search(1);
	int b = search(2);
	if (a == 0) {
		return false;
	}
	v.pop_back();
	v.pop_back();
	v.push_back(b / a);
	return true;
}

bool mod() {
	if (v.size() < 2) {
		return false;
	}
	int a = search(1);
	int b = search(2);
	if (a == 0) {
		return false;
	}
	v.pop_back();
	v.pop_back();
	v.push_back(b % a);
	return true;
}