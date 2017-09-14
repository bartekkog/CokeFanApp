package pl.kognitywistyka.security;

import pl.kognitywistyka.models.UsersEntity;
import pl.kognitywistyka.service.UserService;

import java.security.MessageDigest;
import java.util.List;

/**
 * Created by Anna on 10.07.2017.
 */
public class AuthenticationService {

    private static AuthenticationService instance;

    private UsersEntity currentLoginInfo;

    //funkcja hashujaca, bo to jest powazna aplikacja!
    public static String sha256(String base) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public boolean authenticate(String email, String password){
        UserService userService = UserService.getInstance();
        List<UsersEntity> retrievedUser = userService.findByEmail(email);
        System.out.println("SIZE: " + retrievedUser.size());
        if (retrievedUser != null && !retrievedUser.isEmpty()){
            String hashedPassword = sha256(password);
            System.out.println("HASH:" + sha256(password));
            System.out.println("A POWINNO BYć: " + retrievedUser.get(0).getPassword());
            if (retrievedUser.get(0).getPassword().equals(hashedPassword)){
//                setCurrentLoginInfo(retrievedUser.get(0));
                return true;
            }
            else return false;
        }else
          return false;
    }


//    public void setCurrentLoginInfo(user currentLoginInfo) {this.currentLoginInfo = currentLoginInfo; }
    public UsersEntity getCurrentLoginInfo() {return currentLoginInfo;}
    public boolean isAuthenticated(){return getCurrentLoginInfo()!=null;}
//    public boolean logout(){setCurrentLoginInfo(null);
//    return true;}
//    public boolean czyToPawel(){
//        if (getCurrentLoginInfo().getClass().equals(editor.class)) return false;
//        else return true;}
    public static AuthenticationService getInstance(){
        if (instance == null) instance = new AuthenticationService();
        return instance;
    }
}
