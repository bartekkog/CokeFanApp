package pl.kognitywistyka.users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Baljonesque on 10.07.2017.
 */

@Entity
@DiscriminatorValue("editor")
public class editor extends user {

    public editor(String s, String name, String nazwisko){}

    public editor(String id, String password){
        setId(id);
        setPassword(password);
    }

    public String toString() {return getId();}


}
