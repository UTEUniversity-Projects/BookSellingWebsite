package com.biblio.dao;

import com.biblio.entity.ReturnBook;

public interface IReturnBookDAO {

    ReturnBook findById(Long id);

    ReturnBook findByOrderId(Long orderId);

    ReturnBook save(ReturnBook returnBook);

    ReturnBook update(ReturnBook returnBook);
}
