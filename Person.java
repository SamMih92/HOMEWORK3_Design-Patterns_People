import java.util.Objects;

public class Person {
    protected final String name;
    protected final String surname;
    protected Integer age;
    protected String address;

    public Person(String name, String surname, Integer age, String address) {
        if (name == null)
            throw new IllegalArgumentException("Поле не может быть пустым");
        if (surname == null)
            throw new IllegalArgumentException("Поле не может быть пустой");
        if (age != null && age < 0)
            throw new IllegalArgumentException("Поле пустое любо введен некорректный возраст");
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age != null;
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

    public int getAge() {
        return age;
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

