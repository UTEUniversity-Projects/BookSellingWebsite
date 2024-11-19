package com.biblio.dao.impl;

import com.biblio.dao.IOrderDAO;
import com.biblio.entity.Book;
import com.biblio.entity.MediaFile;
import com.biblio.entity.Order;
import com.biblio.entity.OrderItem;

import java.util.List;

public class OrderDAOImpl extends GenericDAOImpl<Order> implements IOrderDAO {

    public OrderDAOImpl() {
        super(Order.class);
    }

    @Override
    public Order findOne(Long id) {
        return super.findById(id);
    }

    @Override
    public List<Order> findAll() {
        return super.findAll();
    }

    public static void main(String[] args) {
        OrderDAOImpl dao = new OrderDAOImpl();
        Order order = dao.findOne(1L);
        System.out.println(order.getPromotions().size());
//        for (OrderItem orderItem : order.getOrderItems()) {
//            System.out.println("Order Item ID: " + orderItem.getId());
//
//            if (!orderItem.getBooks().isEmpty()) {
//                Book singleBook = orderItem.getBooks().iterator().next();
//                System.out.println("  - Title of one book: " + singleBook.getTitle());
//                System.out.println("  - Quantity: " + orderItem.getBooks().size());
//            } else {
//                System.out.println("  - No books in this OrderItem");
//            }
//        }
    }
}
