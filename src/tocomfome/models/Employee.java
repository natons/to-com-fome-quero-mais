package tocomfome.models;

public class Employee extends Person {
    private String login;
    private String password;

    public Employee() {
        super();
    }

    public Employee(final String name, final String login, final String password) {
        super(name);

        this.setLogin(login);
        this.setPassword(password);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
