#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    
    vector<int> answer;
    vector<int> temp;
    
    for (auto cmd : commands) {
        for (int i = cmd[0] - 1; i <= cmd[1] - 1; i++) {
            temp.push_back(array[i]);
        }
        sort(temp.begin(), temp.end());
        answer.push_back(temp[cmd[2] - 1]);
        temp.clear();
    }
    
    return answer;
}