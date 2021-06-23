package cn.chenjaly.supermarket.service;

import cn.chenjaly.supermarket.bean.User;

public interface UserService {
    public User getUserByUsername(String username);

    public int updateUser(User user);

    public int addUser(User user);
}
