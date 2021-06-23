package cn.chenjaly.supermarket.dao;

import cn.chenjaly.supermarket.bean.User;

public interface UserDao {
    public User getUserByUsername(String username);

    public int updateUser(User user);

    public int addUser(User user);
}
