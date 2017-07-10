package pl.kognitywistyka.security;

import pl.kognitywistyka.service.UserService;
import pl.kognitywistyka.users.editor;
import pl.kognitywistyka.users.user;

import javax.xml.registry.infomodel.User;
import java.security.MessageDigest;
import java.util.List;

/**
 * Created by Anna on 10.07.2017.
 */
public class AuthenticationService {

    private static AuthenticationService instance;

    private user currentLoginInfo;

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

    public boolean authenticate(String id, String password){
        UserService userService = UserService.getInstance();
        List<user> retrievedUser = UserService.findById(id);
        if (retrievedUser != null && !retrievedUser.isEmpty()){
            String hashedPassword = sha256(password);
            if (retrievedUser.get(0).confirmPassword(hashedPassword)){
                setCurrentLoginInfo(retrievedUser.get(0));
                return true;
            }
            else return false;
        }else return false;
    }


    public void setCurrentLoginInfo(user currentLoginInfo) {this.currentLoginInfo = currentLoginInfo; }
    public user getCurrentLoginInfo() {return currentLoginInfo;}
    public boolean isAuthenticated(){return getCurrentLoginInfo()!=null;}
    public boolean logout(){setCurrentLoginInfo(null);
    return true;}
    public boolean czyToPawel(){
        if (getCurrentLoginInfo().getClass().equals(editor.class)) return false;
        else return true;}
    public static AuthenticationService getInstance(){
        if (instance == null) instance = new AuthenticationService();
        return instance;
    }
}
