package com.zhao.service;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/4/13.
 */
    @Component
    public class ShiroRealm extends AuthorizingRealm {

        //    @Autowired
//    private UserService userService;
        @Override
        protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            Object principal = principalCollection.getPrimaryPrincipal();
            authorizationInfo.addRole("user");
            authorizationInfo.addStringPermission("user");
            return authorizationInfo;
        }

        @Override
        protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken tokens) throws AuthenticationException {
            AuthenticationInfo authenticationInfo = null;
            System. out.println("doGetAuthenticationInfo: " + tokens.hashCode());

            // 1. 进行强制的类型转换
            UsernamePasswordToken token = (UsernamePasswordToken) tokens;

            // 2. 获取用户名
            String username = token.getUsername();

            // 3. 利用用户名从数据库中获取用户信息
            System. out.println("利用用户名: " + username + "获取用户信息." );
//            Uuser userbyMark = userService.getUserbyMark(Long.parseLong(username), username, username);
            // 4. 返回 AuthenticationInfo 实例
            // principal: 登陆信息. 也可以是对象类型.
            Object principal = username;
            // credentials: 凭证. 即第 3 步从数据库中获取的用户的密码
//        String credentials = userbyMark.getPassword();
            String credentials =new String(token.getPassword());
            // realmName: 当前 Realm 的 name. 可以直接调用 getName() 方法完成
            String realmName = getName();

            SimpleAuthenticationInfo info = new
                    SimpleAuthenticationInfo(principal, credentials, realmName);

            return info;
        }
    }
