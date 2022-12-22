package com.example.eCommDemo.service;

import com.example.eCommDemo.entity.OrderItems;
import com.example.eCommDemo.entity.Orders;
import com.example.eCommDemo.entity.Product;
import com.example.eCommDemo.entity.Users;
import com.example.eCommDemo.exceptions.UserNotFoundException;
import com.example.eCommDemo.repository.OrderItemsRepository;
import com.example.eCommDemo.repository.OrdersRepository;
import com.example.eCommDemo.repository.ProductRepository;
import com.example.eCommDemo.repository.UserRepository;
import com.example.eCommDemo.request.NewOrderRequest;
import com.example.eCommDemo.request.OrderItemRequest;
import com.example.eCommDemo.response.OrderDetailsResponse;
import com.example.eCommDemo.response.OrderItemListResponse;
import com.example.eCommDemo.response.OrderListResponse;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private OrderItemsRepository orderItemsRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepo;

    public String addNewOrder(NewOrderRequest orderReq){

        Users u = userRepo.findById(orderReq.getOrderById()).get();

        if(u != null){
            u.setPhone(orderReq.getPhone());

            userRepo.save(u);

            Orders or = new Orders();
            or.setOrderId(RandomString.make(14));
            or.setOrderBy(orderReq.getOrderById());
            or.setOrderForCity(orderReq.getCity());
            or.setOrderForDist(orderReq.getDist());
            or.setOrderForLandmark(orderReq.getLandmark());
            or.setOrderForPincode(orderReq.getPincode());
            or.setOrderForState(orderReq.getState());
            or.setOrderForStreet(orderReq.getStreet());
            or.setTotalPrice(orderReq.getTotalPrice());
            or.setStatus("Not Delivered");

            Orders orders = ordersRepository.save(or);

            for(OrderItemRequest orir : orderReq.getOrderItem()){
                Product p = productRepository.findById(orir.getProductId()).get();

                Long availableProduct = p.getProductQuantity() - orir.getNoOfProduct();

                p.setProductQuantity(availableProduct);
                productRepository.save(p);

                OrderItems ori = new OrderItems();
                ori.setOrderId(orders.getId());
                ori.setProductId(p.getId());
                ori.setOrderItemName(p.getProductName());
                ori.setOrderItemPrice(p.getProductPrice());
                ori.setOrderItemQuantity(orir.getNoOfProduct());

                orderItemsRepository.save(ori);
            }

            return "Order placed successfully";
        }

        throw new UserNotFoundException("User not found with id" + orderReq.getOrderById());
    }

    public List<OrderListResponse> getOrdersByUser(Long userId){

        List<Object> gets = ordersRepository.getOrdersByUserId(userId);
        Iterator ite = gets.iterator();
        List<OrderListResponse> orList = new ArrayList<>();
        while (ite.hasNext()){

            Object[] row = (Object[]) ite.next();
            OrderListResponse ors = new OrderListResponse();
            ors.setOrderDate(String.valueOf(row[1]).substring(0, 10));
            ors.setDeliveryDate(String.valueOf(row[2]));

            orList.add(ors);
        }

        return orList;
    }

    public OrderDetailsResponse getOrderDetailsByOrderId(Long id){

        List<Object> ob = ordersRepository.getOrderDetailsByOrderId(id);
        List<OrderItems> orIt = orderItemsRepository.getDetailsByOderId(id);
        Iterator ite = ob.iterator();
        OrderDetailsResponse response = new OrderDetailsResponse();
        List<OrderItemListResponse> oritList = new ArrayList<>();
        while(ite.hasNext()){
            Object[] row = (Object[]) ite.next();
            response.setDeliveryDate(String.valueOf(row[0]));
            response.setOrderDate(String.valueOf(row[1]));
            response.setCity(String.valueOf(row[2]));
            response.setDistrict(String.valueOf(row[3]));
            response.setPhone((BigInteger) row[4]);
            response.setLandmark(String.valueOf(row[5]));
            response.setPincode(String.valueOf(row[6]));
            response.setState(String.valueOf(row[7]));
            response.setStreet(String.valueOf(row[8]));
            response.setPrice((double) row[9]);

            for(OrderItems oi : orIt){

                OrderItemListResponse oil = new OrderItemListResponse();
                oil.setItemName(oi.getOrderItemName());
                oil.setItemPrice(oi.getOrderItemPrice());
                oil.setItemQuantity(oi.getOrderItemQuantity());

                oritList.add(oil);
            }

            response.setItems(oritList);
        }

        return response;
    }

}
