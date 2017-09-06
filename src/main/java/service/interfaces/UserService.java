package service.interfaces;

import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    boolean loginIsSuccessful(HttpServletRequest request);
}
