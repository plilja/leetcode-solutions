/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> idToEmployee = new HashMap<>();
        for (Employee e : employees) {
            idToEmployee.put(e.id, e);
        }
        int result = 0;
        Deque<Employee> q = new ArrayDeque<>();
        q.add(idToEmployee.get(id));
        while (!q.isEmpty()) {
            Employee e = q.poll();
            result += e.importance;
            for (int subordinate : e.subordinates) {
                q.add(idToEmployee.get(subordinate));
            }
        }
        return result;
    }
}
