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

@WebServlet(name = "UpdateUserInfoServlet", value = "/UpdateUserInfoServlet")
public class UpdateUserInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
//        String password=request.getParameter("password");
//        String name=request.getParameter("name");
//        String sex=request.getParameter("sex");
//        String address=request.getParameter("address");
//        String email=request.getParameter("email");
//        String telephone=request.getParameter("telephone");
//        String birthday=request.getParameter("birthday");

        Map<String,String[]> map=request.getParameterMap();
        HttpSession session=request.getSession();
        User user =(User) session.getAttribute("user");
//        user.setAddress(address);
//        user.setBirthday(birthday);
//        user.setSex(sex);
//        user.setEmail(email);
//        user.setName(name);
//        user.setTelephone(telephone);
//        user.setPassword(password);
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService service=new UserServiceimpl();
        service.updateUser(user);
        session.setAttribute("user",user);
        response.sendRedirect(request.getContextPath()+"/user_info.jsp");
    }
}
