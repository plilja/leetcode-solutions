class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> suppliesSet = new HashSet<>();
        Collections.addAll(suppliesSet, supplies);
        
        Map<String, List<String>> recipeToIngredients = new HashMap<>();
        
        for (int i = 0; i < recipes.length; ++i) {
            String recipe = recipes[i];
            var ingr = ingredients.get(i);
            recipeToIngredients.put(recipe, ingr);
        }
        
        Map<String, Boolean> canMakeCache = new HashMap<>();
        List<String> result = new ArrayList<>();
        
        for (String recipe : recipes) {
            if (canMakeRecipe(recipe, recipeToIngredients, suppliesSet, canMakeCache)) {
                 result.add(recipe);
            }
        }
        return result;
    }
    
    private boolean canMakeRecipe(String recipe, Map<String, List<String>> recipeToIngredients, Set<String> supplies, Map<String, Boolean> cache) {
        Boolean cachedValueOrNull = cache.get(recipe);
        if (cachedValueOrNull != null) {
            return cachedValueOrNull; 
        }
        if (supplies.contains(recipe)) {
            return true;
        }
        cache.put(recipe, false);
        boolean result = true;
        for (String ingredient : recipeToIngredients.get(recipe)) {
            if (recipeToIngredients.containsKey(ingredient)) {
                result = canMakeRecipe(ingredient, recipeToIngredients, supplies, cache);
                if (!result) {
                    break;
                }
            } else if (!supplies.contains(ingredient)) {
                result = false;
                break;
            }
        }
        cache.put(recipe, result);
        return result;
    }
}
