public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public void increaseFood(int Food) {
        this.food += food;
    }
    public void decreaseFood(int appetite) {
        if (!hasEnoughFood(appetite)) {
            System.out.println("Hasn't required val of food");
            return;
        }
        food = food - appetite;
    }
    public boolean hasEnoughFood(int appetite) {
        return appetite <= food;
    }
}