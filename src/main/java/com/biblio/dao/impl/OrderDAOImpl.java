package com.biblio.dao.impl;

import com.biblio.dao.IOrderDAO;
import com.biblio.dto.response.CustomerResponse;
import com.biblio.dto.response.OrderCustomerResponse;
import com.biblio.dto.response.ShippingResponse;
import com.biblio.entity.Book;
import com.biblio.entity.LineItem;
import com.biblio.entity.Order;
import com.biblio.enumeration.EBookMetadataStatus;
import com.biblio.enumeration.EOrderStatus;
import com.biblio.jpaconfig.JpaConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDAOImpl extends GenericDAOImpl<Order> implements IOrderDAO {
    private final EntityManager entityManager = JpaConfig.getEntityManager();

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

    @Override
    public List<Order> findAllForManagement() {
        StringBuilder jpql = new StringBuilder();

        jpql.append("SELECT DISTINCT o ")
                .append("FROM Order o ")
                .append("JOIN FETCH o.customer c ")
                .append("JOIN FETCH o.shipping s");

        return super.findAll(jpql.toString());
    }

    @Override
    public Order findOneForDetailsManagement(Long id) {
        StringBuilder jpql = new StringBuilder();

        jpql.append("SELECT DISTINCT o ")
                .append("FROM Order o ")
                .append("JOIN FETCH o.customer c ")
                .append("JOIN FETCH c.account ac ")
                .append("JOIN FETCH o.shipping s ")
                .append("JOIN FETCH s.address ad ")
                .append("JOIN FETCH o.lineItems li ")
                .append("JOIN FETCH li.books b ")
                .append("JOIN FETCH b.bookTemplate bt ")
                .append("JOIN FETCH bt.mediaFiles m ")
                .append("LEFT JOIN FETCH o.promotions p ")
                .append("WHERE o.id = :id");

        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        return super.findSingleByJPQL(jpql.toString(), params);
    }

    @Override
    public List<Order> findByJPQL(Long customerId) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT o ")
                .append("FROM Order o ")
                .append("WHERE o.customer.id = :customerId");

        // Tạo map để chứa các tham số cần gán
        Map<String, Object> params = new HashMap<>();
        params.put("customerId", customerId);

        // Truyền cả câu truy vấn và các tham số vào phương thức findAll
        return super.findByJPQL(jpql.toString(), params);
    }

    @Override
    public boolean updateStatus(Long id, EOrderStatus status) {
        Order order = findOne(id);
        if (order == null || order.getStatus().equals(status)) {
            return false;
        }
        order.setStatus(status);

        if (status == EOrderStatus.CANCELED) {
            for (LineItem lineItem : order.getLineItems()) {
                for (Book book : lineItem.getBooks()) {
                    book.getBookMetadata().setStatus(EBookMetadataStatus.IN_STOCK);
                }
            }
        }

        super.update(order);
        return true;
    }

    @Override
    public OrderCustomerResponse findById(Long id) {
        // Query to fetch the order details
        String query = "SELECT o FROM Order o LEFT JOIN FETCH o.customer c LEFT JOIN FETCH o.lineItems li LEFT JOIN FETCH o.shipping s WHERE o.id = :id";

        try {
            // Execute the query
            Order order = entityManager.createQuery(query, Order.class)
                    .setParameter("id", id)
                    .getSingleResult();

            // Map Order entity to OrderCustomerResponse
            return OrderCustomerResponse.builder()
                    .id(order.getId())
                    .note(order.getNote())
                    .orderDate(order.getOrderDate())
                    .paymentType(order.getPaymentType().toString())
                    .status(order.getStatus().toString())
                    .vat(order.getVat())
                    .customerId(order.getCustomer().getId())
                    .customerName(order.getCustomer().getFullName())
                    .shippingId(order.getShipping() != null ? order.getShipping().getId() : null)
                    .lineItems(order.getLineItems())
                    .address(order.getShipping().getAddress().getFullAddress())
                    .email(order.getCustomer().getEmailAddress())
                    .build();
        } catch (NoResultException e) {
            // Handle case when no order is found
            throw new EntityNotFoundException("Order with ID " + id + " not found.");
        }
    }



    @Override
    public void updateOrder(Order order) {
        entityManager.getTransaction().begin();
        entityManager.merge(order);
        entityManager.getTransaction().commit();
    }

    public static void main(String[] args) {
        OrderDAOImpl dao = new OrderDAOImpl();
//        for (Order order : orders) {
//            System.out.println(order.getId());
//        }
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
