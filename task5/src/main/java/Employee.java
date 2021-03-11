public class Employee {

    private String fio;
    private String position;
    private String email;
    private String phoneNumber;
    private long salary;
    private int age;

    public Employee(String fio, String position, String email, String phoneNumber, long salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public static void main(String[] args) {

    }

    public int getAge() {
        return age;
    }

    public void info() {
        System.out.printf("Сотрудник: %s\nДолжность: %s\nEmail: %s\nТелефонный номер: %s\nЗарплата: %d\nВозраст: %d\n", fio, position, email, phoneNumber, salary, age);
    }
}
