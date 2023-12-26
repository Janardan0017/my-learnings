package leetcode;

import javafx.util.Pair;

import java.util.*;

class FoodRatings {

    Map<String, SortedSet<FoodItem>> map;
    String[] foods;
    String[] cuisines;


    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        for(int i=0; i<foods.length; i++) {
            FoodItem item = new FoodItem(foods[i], ratings[i]);
            SortedSet<FoodItem> set = map.get(cuisines[i]);
            if(set == null) {
                set = new TreeSet<>(new Comparator<FoodItem>() {
                    @Override
                    public int compare(FoodItem o1, FoodItem o2) {
                        int c = Integer.compare(o2.rating, o1.rating);
                        if(c == 0) {
                            c = o1.name.compareTo(o2.name);
                        }
                        return c;
                    }
                });
            }
            set.add(item);
            map.put(cuisines[i], set);
        }
        this.foods = foods;
        this.cuisines = cuisines;
        // this.ratings = ratings;
    }
    
    public void changeRating(String food, int newRating) {
        int i = 0;
        // System.out.println("change");
        while(!foods[i].equals(food)) {
            System.out.println(food + " -> " + newRating);
            i++;
        }
        map.get(cuisines[i]).forEach(e -> {
            if(e.name.equals(food)) {
                System.out.println(e.rating + " ->> " + newRating);
                e.rating = newRating;
            }
        });
    }
    
    public String highestRated(String cuisine) {
        return map.get(cuisine).first().name;
    }
}

class FoodItem {
    String name;
    int rating;

    public FoodItem() { }
    public FoodItem(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodItem foodItem = (FoodItem) o;
        return rating == foodItem.rating && Objects.equals(name, foodItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rating);
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */