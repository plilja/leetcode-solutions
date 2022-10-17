class Solution {
    record Car (
        int position,
        int speed
    ){}
    
    public int racecar(int target) {
        Map<Car, Integer> distance = new HashMap<>();
        Deque<Car> bfsQueue = new ArrayDeque<>();
        Set<Car> visited = new HashSet<>();
        
        var startCar = new Car(0, 1);
        bfsQueue.add(startCar);
        distance.put(startCar, 0);
        visited.add(startCar);
        
        while (true) {
            var car = bfsQueue.poll();
            int dist = distance.get(car);
            if (car.position == target) {
                return dist;
            }
            // Try A
            if (car.position >= 0 && car.position < 2 * target) {
                var carA = new Car(car.position + car.speed, 2 * car.speed);
                if (!visited.contains(carA)) {
                    visited.add(carA);
                    bfsQueue.add(carA);
                    distance.put(carA, dist + 1);
                }
            }
            // Try R
            var carR = new Car(car.position, car.speed > 0 ? -1 : 1);
            if (!visited.contains(carR)) {
                visited.add(carR);
                bfsQueue.add(carR);
                distance.put(carR, dist + 1);
            }
        }
    }
    
}
