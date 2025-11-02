#include <vector>
#include <unordered_set>

using namespace std;

int solution(vector<int> nums) {
    
    // unordered_set을 이용하여 중복 제거
    unordered_set<int> us;
    for (int n : nums) {
        us.insert(n);
    }
    
    return min(nums.size() / 2, us.size());
}