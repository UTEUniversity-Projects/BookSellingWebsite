package com.biblio.dao.impl;

import com.biblio.dao.ICategoryDAO;
import com.biblio.dto.request.SearchBookRequest;
import com.biblio.dto.response.CategoryBookCountResponse;
import com.biblio.entity.Category;
import com.biblio.jpaconfig.JpaConfig;

import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryDAOImpl extends GenericDAOImpl<Category> implements ICategoryDAO {

    public CategoryDAOImpl() {
        super(Category.class);
    }

    @Override
    public List<Category> findAll() {
        return super.findAll();
    }

    @Override
    public Category findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Category findBySubCategoryId(Long id) {
        String jpql = "SELECT c.* FROM category c, (SELECT s.category_id FROM sub_category s WHERE s.id = :id) AS sub WHERE c.id = sub.category_id";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        return super.findSingleByJPQL(jpql, params);
    }

    @Override
    public void addCategory(Category category) {
        super.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        super.update(category);
    }

    @Override
    public void deleteCategory(Long id) {
        super.delete(id);
    }

    @Override
    public List<CategoryBookCountResponse> countBookPerCategory(SearchBookRequest request) {
        StringBuilder jpql = new StringBuilder("SELECT new com.biblio.dto.response.CategoryBookCountResponse(c.id, c.name, COALESCE(COUNT(DISTINCT bt.id), 0)) "
                + "FROM Category c "
                + "LEFT JOIN c.subCategories sc "
                + "LEFT JOIN sc.books b "
                + "LEFT JOIN b.bookTemplate bt "
                + "ON b.id = (SELECT MIN(b2.id) FROM Book b2 WHERE b2.bookTemplate.id = bt.id AND bt.status = 'ON_SALE') "
                + "WHERE (b.sellingPrice IS NULL OR (b.sellingPrice >= :minPrice AND b.sellingPrice <= :maxPrice)) ");

        Map<String, Object> params = new HashMap<>();
        params.put("minPrice", Double.valueOf(request.getMinPrice()));
        params.put("maxPrice", Double.valueOf(request.getMaxPrice()));

        if (request.getTitle() != null && !request.getTitle().isEmpty()) {
            String[] searchTerms = request.getTitle().split("\\s+");
            jpql.append("AND (");
            for (int i = 0; i < searchTerms.length; i++) {
                jpql.append("b.title LIKE :title").append(i);
                params.put("title" + i, "%" + searchTerms[i] + "%");
                if (i < searchTerms.length - 1) {
                    jpql.append(" OR ");
                }
            }
            jpql.append(") ");
        }

        jpql.append("GROUP BY c.id, c.name ");
        jpql.append("ORDER BY COUNT(DISTINCT bt.id) DESC");

        System.out.println(jpql.toString());

        TypedQuery<CategoryBookCountResponse> query = JpaConfig.getEntityManager().createQuery(jpql.toString(), CategoryBookCountResponse.class);
        params.forEach(query::setParameter);

        return query.getResultList();
    }


}
