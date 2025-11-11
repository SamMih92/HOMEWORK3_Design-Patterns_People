public class Main {
    public static void main(String[] args) {

        // проверка создания объекта взрослого человека

        Person person = new PersonBuilder()
                .setName("Антошка")
                .setSurname("Лопатов")
                .setAge(48)
                .setAddress("Москва")
                .build();

        System.out.println(person.getName() + " " + person.getSurname());
        System.out.println("Возраст: " + (person.hasAge() ? person.getAge() : "Неизвестен"));
        System.out.println("Город проживания: " + (person.hasAddress() ? person.getAddress() : "Неизвестен"));

        // Проверка корректности метода happyBirthday

        person.happyBirthday();
        System.out.println("С днём рождения! Новый возраст: " + person.getAge());

        // Проверка создания объекта ребенка

        Person child = person.newChildBuilder()
                .setName("Петя")
                .build();
        System.out.println(child.getName() + " " + child.getSurname());
        System.out.println("Возраст ребенка: " + (child.hasAge() ? child.getAge() : "Неизвестен"));
        System.out.println("Город проживания ребенка: " + (child.hasAddress() ? child.getAddress() : "Неизвестен"));
    }
}
