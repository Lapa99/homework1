public class Cat extends Animal {
    public Cat(float maxRunLenght, float maxJumpHeight) {
        super(maxRunLenght, maxJumpHeight, maxJumpHeight);
    }
    @Override
    public void swim(float lenght) {
        System.out.println("Кошки не плавают!");
    }
}