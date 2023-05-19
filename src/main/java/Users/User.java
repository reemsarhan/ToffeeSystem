package Users;

public abstract class User {
    private static int id = 0;
    private String role;

    public User() {
        this.id = ++id;
    }

    public User(int id, String role) {
        this.id = ++id;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }
}