package cn.chenjaly.supermarket.service.impl;

import cn.chenjaly.supermarket.bean.User;
import cn.chenjaly.supermarket.dao.UserDao;
import cn.chenjaly.supermarket.dao.impl.UserDaoimpl;
import cn.chenjaly.supermarket.service.UserService;

public class UserServiceimpl implements UserService {

    UserDao dao=new UserDaoimpl();
    @Override
    public User getUserByUsername(String username) {
        return dao.getUserByUsername(username);
    }

    @Override
    public int updateUser(User user) {
        return dao.updateUser(user);
    }

    @Override
    public int addUser(User user) {
        return dao.addUser(user);
    }

}
