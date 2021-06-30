package cn.chenjaly.supermarket.service.impl;

import cn.chenjaly.supermarket.bean.Category;
import cn.chenjaly.supermarket.dao.CategoryDao;
import cn.chenjaly.supermarket.dao.impl.CategoryDaoimpl;
import cn.chenjaly.supermarket.service.CategoryService;

import java.util.List;

public class CategoryServiceimpl implements CategoryService {
     CategoryDao dao = new CategoryDaoimpl();

    @Override
    public List<Category> getCategoryList() {
        return dao.getCategoryList();
    }
}
