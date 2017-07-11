package pl.kognitywistyka.users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Anna on 10.07.2017.
 */

@Entity
@DiscriminatorValue("admin")

public class admin extends user {

    public admin(String pawel, String bratem, String moim, String jest){}

    public admin(String id, String password){
        setId(id);
        setPassword(password);
    }

    @Override
    public String toString() {return getId();}
}
