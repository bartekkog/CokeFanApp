package pl.kognitywistyka.ui;

import com.vaadin.ui.Notification;
import pl.kognitywistyka.security.AuthenticationService;

/**
 * Created by Baljonesque on 15.08.2017.
 */
public class LogInWindowLogic extends LogInWindow{

    public LogInWindowLogic(){init();}

    private void init() {

        submit.addClickListener( clickEvent -> {
            if(emailAddress.isEmpty() || password.isEmpty()){
                Notification.show("Enter correct data", Notification.Type.ERROR_MESSAGE);
            } else {
                boolean isAuthenticated = AuthenticationService.getInstance().authenticate(emailAddress.getValue(),password.getValue());
                if (isAuthenticated) {
                    getUI().setContent(new MainWindow0());
                } else Notification.show("Incorrect email address or password ;(", Notification.Type.ERROR_MESSAGE);
            }


                }

        );

        cancel.addClickListener(clickEvent -> {
            getUI().setContent(new MainWindow0());
                }

        );
    }

    }




