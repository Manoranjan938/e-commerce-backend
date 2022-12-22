package com.example.eCommDemo.service;

import com.example.eCommDemo.entity.Product;
import com.example.eCommDemo.entity.ProductAttributes;
import com.example.eCommDemo.entity.Users;
import com.example.eCommDemo.exceptions.ProductNotFoundException;
import com.example.eCommDemo.exceptions.UserNotFoundException;
import com.example.eCommDemo.repository.ProductAttrRepository;
import com.example.eCommDemo.repository.ProductRepository;
import com.example.eCommDemo.repository.UserRepository;
import com.example.eCommDemo.request.ProductRequest;
import com.example.eCommDemo.request.UpdateProductRequest;
import com.example.eCommDemo.response.ProductDetailsResponse;
import com.example.eCommDemo.response.ProductListByUserResponse;
import com.example.eCommDemo.response.ProductListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository prRepo;

    @Autowired
    private ProductAttrRepository prAtRepo;

    @Autowired
    private UserRepository userRepo;

    public String addNewProduct(ProductRequest req) throws UserNotFoundException {

        Users u = userRepo.findById(req.getAddedBy()).get();

        if(u.getUserType().equals("seller")){
            Product p = new Product();
            p.setProductName(req.getProductName());
            p.setProductDesc(req.getProductDesc());
            p.setProductImg("");
            p.setProductPrice(req.getProductPrice());
            p.setProductQuantity(req.getProductQuantity());
            p.setProductStatus("active");
            p.setProductType(req.getProductType());
            p.setUserId(req.getAddedBy());

            Product pp = prRepo.save(p);

            ProductAttributes pa = new ProductAttributes();
            pa.setProductId(pp.getId());
            pa.setProductColor(req.getProductColor());
            pa.setProductSize(req.getProductSize());

            prAtRepo.save(pa);

            return "Product added successfully.";
        }

        throw new UserNotFoundException("You are not eligible to add a product");
    }

    public String updateProduct(UpdateProductRequest req, Long productId){

        Product product = prRepo.findById(productId).get();
        if(product != null){

            product.setProductName(req.getProductName());
            product.setProductDesc(req.getProductDesc());
            product.setProductPrice(req.getProductPrice());
            product.setProductQuantity(req.getProductQuantity());
            product.setProductType(req.getProductType());

            prRepo.save(product);
            return "Product updated successfully";
        }

        throw new ProductNotFoundException("Product not found with id " + productId);
    }

    public List<ProductListResponse> getProductsList(){

        List<Product> p = prRepo.findAll();
        List<ProductListResponse> prList = new ArrayList<>();
        for(Product pp : p){

            ProductListResponse plr = new ProductListResponse();
            plr.setProductName(pp.getProductName());
            plr.setProductDesc(pp.getProductDesc());
            plr.setPrice(pp.getProductPrice());
            plr.setProductId(pp.getId());

            boolean checkStore = pp.getProductQuantity() > 1;
            if(checkStore){
                plr.setIsInStock("In stock");
            }else {
                plr.setIsInStock("Out of stock");
            }
            prList.add(plr);
        }

        return prList;
    }

    public ProductDetailsResponse getProductDetails(Long productId){

        List<Object> prdct = prRepo.getProductsByProductId(productId);
        Iterator it = prdct.iterator();
        ProductDetailsResponse productDetailsResponse = new ProductDetailsResponse();

        while(it.hasNext()){

            Object[] row = (Object[]) it.next();
            productDetailsResponse.setProductName(String.valueOf(row[0]));
            productDetailsResponse.setProductDesc(String.valueOf(row[1]));
            productDetailsResponse.setProductPrice((double) row[2]);
            productDetailsResponse.setProductColor(String.valueOf(row[3]));
            productDetailsResponse.setProductSize(String.valueOf(row[4]));
            productDetailsResponse.setProductType(String.valueOf(row[5]));
            productDetailsResponse.setAddedByName(String.valueOf(row[6]));
            productDetailsResponse.setAddedByPhone(String.valueOf(row[7]));

        }

        return productDetailsResponse;
    }

    public List<ProductListByUserResponse> getProductsByUsers(Long id){

        List<Object> pr = prRepo.getProductsByUserId(id);
        Iterator it = pr.iterator();
        List<ProductListByUserResponse> prLis = new ArrayList<>();

        while(it.hasNext()){
            Object[] row = (Object[]) it.next();
            ProductListByUserResponse plr = new ProductListByUserResponse();
            plr.setProductName(String.valueOf(row[0]));
            plr.setProductDesc(String.valueOf(row[1]));
            plr.setProductPrice((double) row[2]);
            plr.setProductColor(String.valueOf(row[3]));
            plr.setProductSize(String.valueOf(row[4]));
            plr.setProductType(String.valueOf(row[5]));
            plr.setProductQuantity((BigInteger) row[6]);

            prLis.add(plr);
        }

        return prLis;
    }

}
