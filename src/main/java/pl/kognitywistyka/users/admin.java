package pl.kognitywistyka.users;

/**
 * Created by Anna on 10.07.2017.
 */



public class admin extends User{

    public admin(){}

    public admin(String id, String password){
        setId(id);
        setPassword(password);
    }

    @Override
    public String toString() {return getId();}
}
