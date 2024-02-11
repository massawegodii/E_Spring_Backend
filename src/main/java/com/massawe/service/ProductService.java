package com.massawe.service;

import com.massawe.configuration.JwtRequestFilter;
import com.massawe.dao.CartDao;
import com.massawe.dao.ProductDao;
import com.massawe.dao.UserDao;
import com.massawe.entity.Cart;
import com.massawe.entity.Product;
import com.massawe.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private CartDao cartDao;

    public Product addNewProduct(Product product){
        return productDao.save(product);
    }

    public List<Product>getAllProducts(int pageNumber, String searchKey){
        Pageable pageable = PageRequest.of(pageNumber, 4);

        if (searchKey.equals("")){
            return (List<Product>) productDao.findAll(pageable);
        }else {
            return (List<Product>) productDao.findByProductNameContainingIgnoreCaseOrProductDescriptionContainingIgnoreCase(
                    searchKey, searchKey, pageable
            );
        }
    }

    public void deleteProductDetails(Integer productId) {
        productDao.deleteById(productId);
    }
    public Product getProductDetailsById(Integer productId){
        return productDao.findById(productId).get();
    }

    public List<Product> getProductDetails(boolean isSingleCheckout, Integer productId){

        if(isSingleCheckout && productId != 0){
            //we are going to but the product
            List<Product> list = new ArrayList<>();
            Product product = productDao.findById(productId).get();
            list.add(product);
            return list;

        }else {
            //we are going to check entire cart
            String username = JwtRequestFilter.CURRENT_USER;
            User user = userDao.findById(username).get();
            List<Cart> carts = cartDao.findByUser(user);
            return carts.stream().map(x -> x.getProduct()).collect(Collectors.toList());
        }
//        return new ArrayList<>();
    }
}
