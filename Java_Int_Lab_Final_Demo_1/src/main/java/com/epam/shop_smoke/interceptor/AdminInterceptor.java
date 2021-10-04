package com.epam.shop_smoke.interceptor;

import com.epam.shop_smoke.entity.Role;
import com.epam.shop_smoke.entity.User;
import com.epam.shop_smoke.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Component
public class AdminInterceptor implements HandlerInterceptor {
    @Autowired
    private UserManager userManager;

    private boolean checkRole() {
        User user = userManager.getUser();
        for (Role roles : user.getRoles()) {
            if (roles.getNameRole().equals("ADMIN")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        User user = userManager.getUser();
        if (Objects.isNull(user) || !checkRole()) {
            response.sendRedirect("/index");
            return false;
        }
        request.setAttribute("user", user);
        return true;
    }
}
