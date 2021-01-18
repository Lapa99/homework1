import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3, 4};
        String[] arr2 = {"1","2","3","4"};
        swap(arr1,0,1);
        asList(arr2);

        Box<Orange> or = new Box<>();
        Box<Orange> or1 = new Box<>();
        Box<Apple> ap = new Box<>();
        Box<Apple> ap1 = new Box<>();

        or.put(new Orange());
        or1.put(new Orange());
        ap.put(new Apple());
        ap1.put(new Apple());
        System.out.println("Box 1: "+ or.getWeight());
        System.out.println("Box 2: "+ or1.getWeight());
        System.out.println("Box 3: "+ ap.getWeight());
        System.out.println("Box 4: "+ ap1.getWeight());
        System.out.println("Box 1 equals box 3: "+ or.compare(ap));
        System.out.println("Box 2 equals box 4: "+ or1.compare(ap1));
        or.putAll(or1);
        ap.putAll(ap1);
        System.out.println("Box 1: "+ or.getWeight());
        System.out.println("Box 2: "+ or1.getWeight());
        System.out.println("Box 3: "+ ap.getWeight());
        System.out.println("Box 4: "+ ap1.getWeight());
    }
    public static <T> void swap(T[] arr, int n1, int n2) {
        T o = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = o;
    }
    public static <T> List<T> asList(T[] arr) {
        if (arr != null) {
            List<T> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                list.add(arr[i]);
            } return list;
        } return new ArrayList<>();
    }
}
