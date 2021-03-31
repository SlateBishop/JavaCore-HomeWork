import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private Map<String, String> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        PhoneBook phBook = new PhoneBook();
        phBook.add("+7-910-0000", "Ivanov");
        phBook.add("+7-919-1111", "Ivanov");
        phBook.add("+7-921-2222", "Petrov");
        phBook.get("Ivanov");
        phBook.get("Herov");

    }

    public void add(String phoneNumber, String name) {
        phoneBook.put(phoneNumber, name);
    }

    public void get(String name) {
        int count = 0;
        System.out.println("Телефон абонента " + name + " :");
        for (Map.Entry<String, String> book : phoneBook.entrySet()) {
            if (book.getValue().equals(name)) {
                System.out.println(book.getKey());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Абонент не найден");
        }
    }

}
