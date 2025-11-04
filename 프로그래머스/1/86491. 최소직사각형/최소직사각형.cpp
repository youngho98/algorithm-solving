#include <vector>

using namespace std;

int solution(vector<vector<int>> sizes) {
    int width = 0;
    int height = 0;
    
    // 가장 긴 길이를 찾아 가로로 정한다.
    for (auto size : sizes) {
        width = max(size[0], width);
        width = max(size[1], width);
    }
    
    // 모든 사각형들을 가로>=세로가 되게끔 배치하여 세로를 구한다.
    for (auto size : sizes) {
        height = max(min(size[0], size[1]), height);
    }
    
    return width * height;
}