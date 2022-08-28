class Solution {
    record Car (int position, double speed) {
    }
    
    public int carFleet(int target, int[] positions, int[] speeds) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < positions.length; ++i) {
            cars.add(new Car(positions[i], speeds[i]));
        }
        Collections.sort(cars, (a, b) -> a.position - b.position);
        
        int result = 1; // the last car
        for (int i = cars.size() - 2; i >= 0; --i) {
            Car car = cars.get(i);
            Car nextCar = cars.get(i + 1);
            double arrival = (target - car.position()) / car.speed();
            double nextArrival = (target - nextCar.position()) / nextCar.speed();
            if (arrival > nextArrival + 1e-9) {
                result++;
            } else {
                cars.set(i, nextCar);
                cars.set(i + 1, car);
            }
        }
        return result;
    }
}
