package com.zhao.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/4/13.
 */

@Component
public class ShiroLogin {

//    @Autowired
//    private UserService userService;

    public void doLogin(String username, String password, HttpSession session){
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);

            try {
                currentUser.login(token);
                //如何能够访问到已经在 Realm 中获取到的 User 的实例.
                Object principal = SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
                session.setAttribute("user", principal);
            } catch (UnknownAccountException uae) {
//                return -1L;
            } catch (IncorrectCredentialsException ice) {
//                return -2L;
            } catch (AuthenticationException ae) {
//                return -3L;
            }
        }
//        Uuser userbyMark = userService.getUserbyMark(Long.parseLong(username), username, username);
//        return userbyMark.getId();
    }
}

