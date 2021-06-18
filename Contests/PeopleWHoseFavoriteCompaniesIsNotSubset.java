import java.util.*;

public class PeopleWHoseFavoriteCompaniesIsNotSubset {
  public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
    List<Set<String>> set = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    for (List<String> curr : favoriteCompanies) {
      Set<String> comp = new HashSet<>(curr);
      set.add(comp);
    }

    for (int i = 0; i < set.size(); i++) {
      boolean flag = false;
      for (int j = 0; j < set.size(); j++) {
        Set<String> s1 = set.get(i);
        Set<String> s2 = set.get(j);
        if (i != j && s2.size() > s1.size() && s2.containsAll(s1)) {
          flag = true;
          break;
        }
      }
      if (!flag) {
        ans.add(i);
      }
    }
    return ans;
  }
}
