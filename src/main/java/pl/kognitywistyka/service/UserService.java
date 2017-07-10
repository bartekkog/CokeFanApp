package pl.kognitywistyka.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.kognitywistyka.HibernateUtils;
import pl.kognitywistyka.security.AuthenticationService;
import pl.kognitywistyka.users.admin;
import pl.kognitywistyka.users.editor;
import pl.kognitywistyka.users.user;

import javax.jws.soap.SOAPBinding;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
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
                new admin("pawel","pawel","pawel", AuthenticationService.sha256("admin"))
                );
        for (user user : usersList) {
            String id = user.getId();
            users.put(id,user);
        }

    }

    public  synchronized List<user> findById(String id) throws NoResultException{
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tr = null;
        List resultList = null;
        List<user> finalList = null;
        try {
            tr = session.beginTransaction();
            Query query = session.createQuery("from user where id like:id").setParameter("id", "%" + id + "%");
            resultList = query.getResultList();
            finalList = new ArrayList<>():
            for (Object object : resultList) {
                finalList.add((user) object);
            }
        }
            catch (NoResultException e) {
                if (tr!=null) tr.rollback();
                e.printStackTrace();

        } finally {
            session.close(); //NO W KONCU :D
        }
        return finalList;


    }
}
