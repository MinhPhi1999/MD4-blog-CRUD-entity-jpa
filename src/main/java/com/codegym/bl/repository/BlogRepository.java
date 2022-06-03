package com.codegym.bl.repository;

import com.codegym.bl.model.Blog;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BlogRepository implements IBlogRepository {
    //quản lý entity
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = em.createQuery("Select c from Blog c", Blog.class);
        return query.getResultList();
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() != null) {
            em.merge(blog);
            //cập nhập trạng thái entity
        } else {
            em.persist(blog);
            //persist để lưu mới
        }
    }

    @Override
    public Blog findById(Long id) {
        TypedQuery<Blog> query = em.createQuery("select c from Blog c where  c.id=:id", Blog.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void remove(Long id) {
        Blog blog = findById(id);
        if (blog != null) {
            em.remove(blog);
        }
    }
}
