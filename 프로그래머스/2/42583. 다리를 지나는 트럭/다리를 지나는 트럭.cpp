#include <vector>
#include <deque>

using namespace std;

struct Truck {
    int weight, passTime; // 무게, 건너는 시간
    Truck (int weight, int passTime) {
        this->weight = weight;
        this->passTime = passTime;
    }
};

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int time = 0;           // 현재 시간
    int idx = 0;            // 진입할 트럭의 index
    int bridge_weight = 0;  // 현재 다리의 무게
    
    deque<Truck> bridge;
    
    while (idx < truck_weights.size()) {
        time++;
        // 다리를 다 건넜으면 빠진다
        if (!bridge.empty() && bridge.front().passTime <= time) {
            bridge_weight -= bridge.front().weight;
            bridge.pop_front();
        }
        // 다리에 진입할 수 있으면 진입한다
        if (bridge.size() < bridge_length && bridge_weight + truck_weights[idx] <= weight) {
            bridge_weight += truck_weights[idx];
            bridge.push_back(Truck(truck_weights[idx++], time + bridge_length));
        }
        // 다리가 꽉 찼다면 시간을 다리에 있는 첫번째 트럭이 건너기 1초 전으로 이동시킨다.
        if (bridge.size() == bridge_length) {
            time = bridge.front().passTime - 1;
        }
    }
    
    // 다리에 마지막 남은 트럭이 건너는 시간을 return
    return bridge.back().passTime;
}