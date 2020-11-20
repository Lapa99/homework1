public class Cat {
    private String name;
    private boolean isFull;
    private int appetite;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isFull = false;
    }
    public void eat(Plate plate) {
        if (plate.hasEnoughFood(appetite) && !isFull) {
            plate.decreaseFood(appetite);
            isFull = true;
            System.out.println(name + " поел");
        }
        else if (isFull) {
            System.out.println(name + " не хочет есть");
        }
        else {
            System.out.println("Мало еды в тарелке " + name);
        }
    }
}