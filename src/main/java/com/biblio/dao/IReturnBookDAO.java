package com.biblio.dao;

import com.biblio.entity.ReturnBook;

public interface IReturnBookDAO {

    ReturnBook findByOrderId(Long orderId);

    ReturnBook save(ReturnBook returnBook);
}
