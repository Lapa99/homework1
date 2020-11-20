public class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Мурзик", 3);
        cats[1] = new Cat("Алекс", 5);
        cats[2] = new Cat("Пушок", 10);
        Plate plate = new Plate(20);
        for(int i = 0; i < cats.length; i++) cats[i].eat(plate);
        appendToFood(plate, 46);
        for(int i = 0; i < cats.length; i++) cats[i].eat(plate);
    }
    static void appendToFood(Plate plate, int food) {
        plate.increaseFood(food);
    }
}