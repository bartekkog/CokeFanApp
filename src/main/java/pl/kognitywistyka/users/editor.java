package pl.kognitywistyka.users;

/**
 * Created by Anna on 10.07.2017.
 */
public class editor extends User{

    public editor(){}
    public editor(String id, String password){
        setId(id);
        setPassword(password);
    }

    public String toString() {return getId();}


}
