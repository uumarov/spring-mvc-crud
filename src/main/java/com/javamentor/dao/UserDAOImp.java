package com.javamentor.dao;

import com.javamentor.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findOneById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(User user) {
        User userEntry = entityManager.find(User.class, user.getId());
        entityManager.remove(userEntry);
    }

    @Override
    public void delete(Long id) {
        User userEntry = entityManager.find(User.class, id);
        entityManager.remove(userEntry);
    }
}
