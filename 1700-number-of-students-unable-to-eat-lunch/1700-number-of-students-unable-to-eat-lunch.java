class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int studentOne = 0;
        int studentZero = 0;
        for (int s : students) {
            if (s == 0) {
                studentZero++;
            } else {
                studentOne++;
            }
        }
        int eat = 0;
        for (int s : sandwiches) {
            if (s == 0) {
                if (studentZero == 0) {
                    break;
                }
                studentZero--;
            } else {
                if (studentOne == 0) {
                    break;
                }
                studentOne--;
            }
            eat++;
        }
        return students.length - eat;
    }
}
