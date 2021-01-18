import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }
    private List<T> getFruits() {
        return fruits;
    }
    private void clear() {
        fruits.clear();
    }
    public float getWeight(){
        return (float) fruits.stream().mapToDouble(Fruit::getWeight).sum();
    }
    public void put(T fruit) {
        fruits.add(fruit);
    }
    public void put(T... fruit) {
        fruits.addAll(Arrays.asList(fruit));
    }
    public void putAll(Box<T> box) {
        fruits.addAll(box.getFruits());
        box.clear();
    }
    public <E extends Fruit> boolean compare(Box<E> box) {
        return getWeight() == box.getWeight();
    }
}