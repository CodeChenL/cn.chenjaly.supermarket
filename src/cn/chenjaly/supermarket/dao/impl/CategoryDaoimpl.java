package cn.chenjaly.supermarket.dao.impl;

import cn.chenjaly.supermarket.bean.Category;
import cn.chenjaly.supermarket.dao.CategoryDao;
import cn.chenjaly.supermarket.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDaoimpl implements CategoryDao {
    JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Category> getCategoryList() {
        String sql="select * from Category";
        return template.query(sql,new BeanPropertyRowMapper<>(Category.class));
    }
}
