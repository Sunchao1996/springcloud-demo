package com.sc.book.product.facade;

import com.netflix.discovery.converters.Auto;
import com.sc.book.product.domain.Product;
import com.sc.book.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * what:
 *
 * @author 孙超 created on 2018/4/7
 */
@RestController
public class ProductFacadeImpl implements ProductFacade {
    @Autowired
    private ProductService productService;

    @Override
    public List<Product> listProduct() {
        return productService.findAllProduct();
    }

    @Override
    public List<Product> findAllProduct() {
        return productService.findAllProduct();
    }

    @Override
    public Product get(Integer id) {
        return productService.get(id);
    }


    @Override
    public Product add(Product product) {
        return product;
    }

    @Override
    public Product get1(Product product) {
        return null;
    }

    @Override
    public Product get2(Integer id, String name) {
        return null;
    }
}
