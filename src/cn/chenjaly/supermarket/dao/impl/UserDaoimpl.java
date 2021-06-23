package cn.chenjaly.supermarket.dao.impl;

import cn.chenjaly.supermarket.bean.User;
import cn.chenjaly.supermarket.dao.UserDao;
import cn.chenjaly.supermarket.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoimpl implements UserDao {

    JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User getUserByUsername(String username) {

        String sql="select * from user where username=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),username);
    }

    @Override
    public int updateUser(User user) {
        String sql="update user set password=?,name=?,email=?,telephone=?,sex=?,birthday=?,address=? where uid=?";
        return jdbcTemplate.update(sql,user.getPassword(), user.getName(), user.getEmail(), user.getTelephone(),user.getSex(),user.getBirthday(), user.getAddress(),user.getUid());
    }

    @Override
    public int addUser(User user) {
        String sql="insert into User values(?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(
                sql,user.getUid(), user.getUsername(), user.getPassword(),
                user.getName(), user.getEmail(), user.getTelephone(),
                user.getBirthday(), user.getSex(),String.valueOf(user.getState()),
                user.getCode(), user.getAddress());
    }
}
