package cn.chenjaly.supermarket.web;

import cn.chenjaly.supermarket.bean.User;
import cn.chenjaly.supermarket.service.UserService;
import cn.chenjaly.supermarket.service.impl.UserServiceimpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        request.setCharacterEncoding("utf-8");
        Map<String,String[]> map=request.getParameterMap();
        User user =new User();
        user.setUid(UUID.randomUUID().toString());
        user.setState(0);
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService service=new UserServiceimpl();
        service.addUser(user);
        response.sendRedirect(request.getContextPath()+"/register.jsp");
    }
}
