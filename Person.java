import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected static final int UNKNOWN_AGE = -1;

    protected final String name;
    protected final String surname;
    protected int age = UNKNOWN_AGE;
    protected String address;

    public Person(String name, String surname, int age) {
        if (name == null)
            throw new IllegalArgumentException("Поле не может быть пустым");
        if (surname == null)
            throw new IllegalArgumentException("Поле не может быть пустым");
        if (age < UNKNOWN_AGE)
            throw new IllegalArgumentException("Введен некорректный возраст");
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname) {
        if (name == null)
            throw new IllegalArgumentException("Поле не может быть пустым");
        if (surname == null)
            throw new IllegalArgumentException("Поле не может быть пустым");
        this.name = name;
        this.surname = surname;
    }

    public boolean hasAge() {
        return age != UNKNOWN_AGE;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return hasAge() ? OptionalInt.of(age) : OptionalInt.empty();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) age++;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                (hasAge() ? ", age=" + age : "") +
                (hasAddress() ? ", address='" + address + '\'' : "") +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }


    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAddress(this.address)
                .setAge(0);
    }

}
