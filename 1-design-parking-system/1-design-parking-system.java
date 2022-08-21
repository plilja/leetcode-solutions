class ParkingSystem {
    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        switch (carType) {
            case 3:
                if (small > 0) {
                    small--;
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (medium > 0) {
                    medium--;
                    return true;
                } else {
                    return false;
                }
            case 1:
                if (big > 0) {
                    big--;
                    return true;
                } else {
                    return false;
                }
            default:
                throw new IllegalArgumentException("Unknown car type received " + carType);
        }
        
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
