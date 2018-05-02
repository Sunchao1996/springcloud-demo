package com.book.product.facade;

import com.book.product.domain.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * what:
 *
 * @author 孙超 created on 2018/4/7
 */
@RestController
public class ProductFacadeImpl implements ProductFacade {
    public List<Product> list() {
        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "第一本书"));
        list.add(new Product(2, "第二本书"));
        list.add(new Product(3, "第三本书"));
        list.add(new Product(4, "第三本书"));
        list.add(new Product(5, "第三本书"));
        list.add(new Product(6, "第三本书"));
        list.add(new Product(7, "第三本书"));
        list.add(new Product(8, "第三本书"));
        list.add(new Product(9, "第三本书"));
        list.add(new Product(10, "第三本书"));
        list.add(new Product(11, "第三本书"));
        list.add(new Product(12, "第三本书"));
        list.add(new Product(13, "第三本书"));
        return list;
    }

    @Override
    public Product get(@RequestParam("id") Integer id) {
        return new Product(id, "第一本书");
    }

    @Override
    public Product get1(@RequestBody Product product) {
        return product;
    }

    @Override
    public Product get2(Integer id, String name) {
        return new Product(id,name);
    }

    @Override
    public Product add(@RequestBody Product product) {
        return product;
    }

}
