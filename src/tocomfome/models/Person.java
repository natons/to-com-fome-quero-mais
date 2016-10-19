
package tocomfome.models;

public abstract class Person {
    private String name;

    public Person() {}

    public Person(final String name) {
        this.setName(name);
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
