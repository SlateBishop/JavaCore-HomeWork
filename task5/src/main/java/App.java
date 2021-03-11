public class App {

    public static void main(String[] args) {
        App app = new App(); //Нашел такое решение для вызова метода oldMan, но не уверен, что оно корректное
        Employee[] employeeArray = new Employee[5];
        employeeArray[0] = new Employee("Ivanov. I.A.", "Foremost", "xxxxx@xxx-xx.xxx - top secret information",
                "+412-xxxxxxxx - top secret information", 500000000, 30);
        employeeArray[1] = new Employee("Pupkin A.I.", "the First after Foremost", "xxxxx@xxx-xx.xxx - top secret information",
                "+412-xxxxxxxx - top secret information", 50000000, 32);
        employeeArray[2] = new Employee("Petrov", "Slave №1", "awdf@mail.ru", "+7-xxxxxxxxxx", 20000, 40);
        employeeArray[3] = new Employee("Herov", "Slave №2", "qwer@mail.ru", "+7-xxxxxxxxxx", 18000, 38);
        employeeArray[4] = new Employee("Bubnov", "Slave №3", "vcxz@mail.ru", "+7-xxxxxxxxxx", 19000, 17);
        app.oldMan(employeeArray);

    }

    private /*static*/ void oldMan(Employee[] arr) {   //Пришлось сделать метод статичным, иначе не вызывался в мэйне. На выходных разберусь подробнее как правильно делать, сейчас слишком хочется спать
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getAge() > 40) {
                arr[i].info();
                System.out.println();
            }
        }

    }
}
