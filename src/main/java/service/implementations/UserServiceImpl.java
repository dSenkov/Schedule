package service.implementations;

import domain.AdminTools;
import org.springframework.stereotype.Service;
import service.interfaces.UserService;
import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public boolean loginIsSuccessful(HttpServletRequest request) {
        if (request.getParameter("login").equals(AdminTools.getLOGIN()) &&
                request.getParameter("password").equals(AdminTools.getPASSWORD()))
            return true;
        else return false;
    }
}
