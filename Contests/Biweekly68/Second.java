import java.util.*;

public class Second {
  public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
    Set<String> set = new HashSet<>();
    for (String supply : supplies)
      set.add(supply);
    Set<String> ans = new HashSet<>();
    for (int i = 0; i < recipes.length; i++) {
      outer: for (int j = 0; j < recipes.length; j++) {
        if (ans.contains(recipes[j])) {
          continue;
        }
        for (String ing : ingredients.get(j)) {
          if (!set.contains(ing)) {
            continue outer;
          }
        }
        ans.add(recipes[j]);
        set.add(recipes[j]);
      }
    }
    return new ArrayList<>(ans);
  }
}
