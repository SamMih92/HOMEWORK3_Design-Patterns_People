public class PersonBuilder {
    private String name;
    private String surname;
    private int age = Person.UNKNOWN_AGE;
    private String address;

    public PersonBuilder setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Поле имени не может быть пустым");
        }
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null) {
            throw new IllegalArgumentException("Поле фамилии не может быть пустым");
        }
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < Person.UNKNOWN_AGE)
            throw new IllegalArgumentException("Некорректный возраст");
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null)
            throw new IllegalStateException("Не указано имя");
        if (surname == null)
            throw new IllegalStateException("Не указана фамилия");
        return new Person(name, surname, age);
    }
}
