import java.util.*;

public class EmployeeImportanec {
  class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
  };

  Map<Integer, Employee> emap;

  public int getImportance(List<Employee> employees, int queryid) {
    emap = new HashMap<>();
    for (Employee e : employees)
      emap.put(e.id, e);
    return dfs(queryid);
  }

  public int dfs(int eid) {
    Employee employee = emap.get(eid);
    int ans = employee.importance;
    for (Integer subid : employee.subordinates)
      ans += dfs(subid);
    return ans;
  }
}
