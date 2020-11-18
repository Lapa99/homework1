public abstract class Animal {
    protected float maxRunLenght;
    protected float maxSwimLenght;
    protected float maxJumpHieght;
    public Animal(float maxRunLenght, float maxSwimLenght, float maxJumpHieght) {
        this.maxRunLenght = maxRunLenght;
        this.maxSwimLenght = maxSwimLenght;
        this.maxJumpHieght = maxJumpHieght;
    }
    public void run(float lenght) {
        System.out.println("run " + isAvailableAction(lenght, maxRunLenght));
    }
    public void swim(float lenght) {
        System.out.println("swim " + isAvailableAction(lenght, maxRunLenght));
    }
    public void jump(float lenght) {
        System.out.println("jump " + isAvailableAction(lenght, maxJumpHieght));
    }
    private boolean isAvailableAction(float required, float expected) {
        return required <= expected;
    }
}