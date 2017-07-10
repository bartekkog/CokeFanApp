package pl.kognitywistyka.service;

import pl.kognitywistyka.users.admin;
import pl.kognitywistyka.users.editor;
import pl.kognitywistyka.users.user;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Anna on 10.07.2017.
 */
public class UserService {

    private static UserService instance;
    private HashMap<String, user>;

    public static UserService getInstance(){
        if (instance==null){
            instance = new UserService();
            instance.ensureTestData();
        }
        return instance;
    }

    public void ensureTestData() {
        HashMap<Object, Object> users = new HashMap<>();
        List<user> usersList = Arrays.asList(
                new editor("1","Małgorzata","Baljon"),
                new editor("2","Ania","Baljon"),
                new admin("pawel","pawel","pawel",)
                );
        for (user user : usersList) {
            String id = user.getId();
            users.put(id,user);
        }

    }

    public  synchronized List<user> findById(id){

    }
}
