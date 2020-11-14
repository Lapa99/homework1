import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee(
                "Artem Maksimovich",
                "Programmer",
                "Artem@mailbox.com",
                "84659365846",
                "150000",
                "29");
        employees[1] = new Employee (
                "Andrey Maksimovich",
                "Programmer",
                "Andrey@mailbox.com",
                "85692303485",
                "200000",
                "31");
        employees[2] = new Employee (
                "Maksim Maksimovich",
                "Programmer",
                "Maksim@mailbox.com",
                "89995472307",
                "115000",
                "30");
        employees[3] = new Employee (
                "Artem Ivanovich",
                "Programmer",
                "Artem@mailbox.com",
                "89561143057",
                "110000",
                "24");
        employees[4] = new Employee (
                "Ivan Victorovich",
                "Programmer",
                "Ivan@mailbox.com",
                "85470213696",
                "100000",
                "22");
        for (int i = 0, i < employees.length, i++) {
            if (employees[i].getAge > 40) employees[i].printInfo();
        }
    }