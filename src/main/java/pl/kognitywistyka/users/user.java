package pl.kognitywistyka.users;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by Anna on 10.07.2017.
 */
public abstract class user {

    @Id
    @Column(name="USER_ID", nullable = false)
    private String id; //login? email? to determine

    @Column(name="PASSWORD", nullable = false)
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract String toString();

    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }

    public boolean equals(user user) {
        return super.equals(user.getId());
    }

    public boolean confirmPassword(String hashedPassword){
        return password.equals(hashedPassword);
    }
}
