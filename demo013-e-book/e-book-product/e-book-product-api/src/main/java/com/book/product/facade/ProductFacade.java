package com.book.product.facade;

import com.book.product.domain.Product;
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
    @RequestMapping(value = "list",method = RequestMethod.GET)
    List<Product> list();
    @RequestMapping(value = "get",method = RequestMethod.GET)
    Product get(@RequestParam("id") Integer id);
    @RequestMapping(value = "get1",method = RequestMethod.GET)
    Product get1(Product product);
    @RequestMapping(value = "get2",method = RequestMethod.GET)
    Product get2(@RequestParam("id")Integer id,@RequestParam("name") String name);
    @RequestMapping(value="add",method = RequestMethod.POST)
    Product add(@RequestBody Product product);
}
