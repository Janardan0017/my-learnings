package javadeepdown.collections;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {

    public static void main(String[] args) {
        SortedSet<FoodRating> set = new TreeSet<>(new Comparator<FoodRating>() {
            @Override
            public int compare(FoodRating o1, FoodRating o2) {
                int c = Integer.compare(o2.rating, o1.rating);
                if(c == 0) {
                    c = o1.food.compareTo(o2.food);
                }
                return c;
            }
        });
        set.add(new FoodRating("daal", 4));
        set.add(new FoodRating("roti", 5));
        set.add(new FoodRating("paneer", 4));
        set.add(new FoodRating("pizza", 4));
        System.out.println(set);
    }

    private static class FoodRating {
        String food;
        int rating;

        public FoodRating(String food, int rating) {
            this.food = food;
            this.rating = rating;
        }

        @Override
        public String toString() {
            return String.format("[%s, %s]", food, rating);
        }
    }
}
