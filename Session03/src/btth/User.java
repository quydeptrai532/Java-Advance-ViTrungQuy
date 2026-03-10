package btth;

import java.time.LocalDate;

public class User {
    private String id;
    private String email;
    private String password;
    private boolean verified;
    private LocalDate createdAt;

    public User(String id, String email, String password, boolean verified, LocalDate createdAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.verified = verified;
        this.createdAt = createdAt;
    }

    public String getId() { return id; }

    public String getEmail() { return email; }

    public String getPassword() { return password; }

    public boolean isVerified() { return verified; }

    public LocalDate getCreatedAt() { return createdAt; }

    @Override
    public String toString() {
        return "User{id='" + id + "', email='" + email + "', verified=" + verified + ", createdAt=" + createdAt + "}";
    }
}