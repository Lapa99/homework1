public class Employee {
    private String name;
    private String position;
    private String email;
    private String number;
    private float salary;
    private int age;
    public Employee(String name, String position, String email, String number, float salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.number = number;
        this.salary = salary;
        this.age = age;
    }
    public void printInfo() {
        System.out.println("Имя" + name);
        System.out.println("Должность" + position);
        System.out.println("Почта" + email);
        System.out.println("Телефон" + number);
        System.out.println("Зарплата" + salary);
        System.out.println("Возраст" + age);
    }
    public int getAge() {return age;}
}