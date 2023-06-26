package personal.model;

import java.util.Objects;

public class User {
    private String id = "";
    private String firstName;
    private String lastName;
    private String phone;

    public User(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public User(String id, String firstName, String lastName, String phone) {
        this(firstName, lastName, phone);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("Идентификатор: %s\nИмя: %s,\nФамилия: %s,\nТелефон: %s", id, firstName, lastName, phone);
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User user) {
            return this.id.equals(user.id) && this.firstName.equals(user.firstName) && this.lastName.equals(user.getLastName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phone);
    }
}
