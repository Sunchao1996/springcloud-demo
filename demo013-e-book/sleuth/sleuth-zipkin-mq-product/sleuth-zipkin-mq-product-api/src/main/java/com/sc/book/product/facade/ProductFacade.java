package com.sc.book.product.facade;

import com.sc.book.product.domain.Product;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * what:接口里面的方法体怎么写，实现类和使用的时候就怎么写
 *
 * @author 孙超 created on 2018/4/7
 */
@RequestMapping("/product")
public interface ProductFacade {
    @RequestMapping(value = "list", method = RequestMethod.GET)
    List<Product> listProduct();

    @RequestMapping(value = "findAllProduct", method = RequestMethod.GET)
    List<Product> findAllProduct();

    @RequestMapping(value = "get", method = RequestMethod.GET)
    Product get(@RequestParam("id") Integer id);

    //    接收参数是用对象接收的时候需要在接口上加上,consumes = MimeTypeUtils.APPLICATION_JSON_VALUE
    @RequestMapping(value = "get1", method = RequestMethod.GET, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    Product get1(@RequestBody Product product);

    @RequestMapping(value = "get2", method = RequestMethod.GET)
    Product get2(@RequestParam("id") Integer id, @RequestParam("name") String name);

    @RequestMapping(value = "add", method = RequestMethod.POST, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    Product add(@RequestBody Product product);
}
