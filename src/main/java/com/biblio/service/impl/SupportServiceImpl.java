package com.biblio.service.impl;

import com.biblio.dao.ICustomerDAO;
import com.biblio.dao.INotificationDAO;
import com.biblio.dao.ISupportDAO;
import com.biblio.dao.impl.CustomerDAOImpl;
import com.biblio.dao.impl.NotificationDAOImpl;
import com.biblio.dao.impl.SupportDAOImpl;
import com.biblio.dto.request.SupportRequest;
import com.biblio.entity.Customer;
import com.biblio.entity.Notification;
import com.biblio.entity.Support;
import com.biblio.enumeration.ENotificationStatus;
import com.biblio.enumeration.ENotificationType;
import com.biblio.enumeration.ESupportStatus;
import com.biblio.service.ISupportService;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

public class SupportServiceImpl implements ISupportService {

    private ISupportDAO supportDAO;
    private INotificationDAO notificationDAO;
    private ICustomerDAO customerDAO;
    public SupportServiceImpl(ISupportDAO supportDAO, INotificationDAO notificationDAO) {
        this.supportDAO = supportDAO;
        this.notificationDAO = notificationDAO;
    }
    public SupportServiceImpl() {
        this.supportDAO = new SupportDAOImpl();
        this.notificationDAO = new NotificationDAOImpl();
        this.customerDAO = new CustomerDAOImpl();

    }

    @Override
    public List<Support> getAllSupportRequests() {
        List<Support> supportRequests = supportDAO.findAll();
        for (Support request : supportRequests) {
            request.getCustomer().getFullName();
        }
        return supportRequests;
    }

    @Override
    public Support getSupportRequestById(long id) {
        Support supportRequest = supportDAO.findById(id);
        if (supportRequest != null) {
            supportRequest.getCustomer().getFullName();
        }
        return supportRequest;
    }

    @Override
    public void respondToSupportRequest(SupportRequest request) throws SQLException {
        Support support = supportDAO.findById(request.getId());
        if (support != null) {
            support.setFeedbackContent(request.getFeedbackContent());
            support.setStatus(ESupportStatus.RESPONDED);
            support.setResponsedAt(LocalDateTime.now());
            supportDAO.update(support);

            // Create and save a notification for the customer
            Notification notification = new Notification();
            notification.setCreatedAt(LocalDateTime.now());
            notification.setSentTime(LocalDateTime.now());
            notification.setTitle("Your support request has been responded to");
            notification.setContent("We have responded to your request: " + support.getFeedbackContent());
            notification.setType(ENotificationType.SUPPORT);
            notification.setStatus(ENotificationStatus.NOT_SEEN);

            // Set up the customer relationship
            Customer customer = support.getCustomer();
            if (notification.getCustomers() == null) {
                notification.setCustomers(new HashSet<>()); // Initialize if null
            }
            notification.getCustomers().add(customer);
            customer.getNotifications().add(notification);
            notificationDAO.saveSupport_Notification(notification);
            customerDAO.updateSupport_Notification(customer);
        }
    }







}

