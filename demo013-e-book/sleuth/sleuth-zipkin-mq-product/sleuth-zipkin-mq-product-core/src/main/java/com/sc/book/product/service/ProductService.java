package com.sc.book.product.service;

import com.netflix.discovery.converters.Auto;
import com.sc.book.product.domain.Product;
import com.sc.book.product.persistence.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * what:   商品service
 *
 * @author 孙超 created on 2018/7/4
 */
@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    public List<Product> findAllProduct() {
        return productMapper.findAllProduct();
    }

    public Product get(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }


    public int add(Product product) {
        return productMapper.insert(product);
    }
}
