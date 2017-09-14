package pl.kognitywistyka.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.kognitywistyka.HibernateUtils;
import pl.kognitywistyka.models.UsersEntity;
import pl.kognitywistyka.security.AuthenticationService;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Anna on 10.07.2017.
 */
public class UserService {

    private static UserService instance;

    public static UserService getInstance(){
        if (instance==null){
            instance = new UserService();
//            instance.ensureTestData();
        }
        return instance;
    }


    public synchronized List<UsersEntity> findByEmail(String email) throws NoResultException{
        Transaction tr = null;
        List resultList = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tr = session.beginTransaction();
            System.out.println("EMAIL: " + email);
            Query query =  session.createQuery("from UsersEntity where email like :email").setParameter("email", "%"+email+"%");
            resultList = query.getResultList();
        } catch (NoResultException e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();

        }
        return (List<UsersEntity>) resultList;
    }

//Adding user to DB

//public boolean add(user user){
//        user.setPassword(AuthenticationService.sha256(user.getPassword()));
//        Session session = HibernateUtils.getSessionFactory().openSession();
//        Transaction tr = null;
//
//        try{
//            tr = session.beginTransaction();
//            session.save(user);
//            tr.commit();
//        } catch (Exception e){
//            if (tr!=null) tr.rollback();
//            e.printStackTrace();
//            return false;
//        } finally {
//            session.close();
//        }
//    return true;}
//
//
////Deleting user from DB
//
//public boolean delete(user user){
//    Session session = HibernateUtils.getSessionFactory().openSession();
//    Transaction tr = null;
//    try {
//        tr = session.beginTransaction();
//        String uID = user.getId();
//        session.load(user.class, uID);
//        session.delete(user);
//        session.getTransaction().commit();
//
//    } catch (Exception e){
//        if(tr!=null) tr.rollback();
//        e.printStackTrace();
//        return false;
//    } finally {
//        session.close();
//    }
//    return true;
//    }
}
