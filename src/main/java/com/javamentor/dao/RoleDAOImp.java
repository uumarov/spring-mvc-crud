package com.javamentor.dao;

import com.javamentor.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDAOImp implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role findOneById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role findOneByRoleName(String roleName) {
        return entityManager.createQuery("FROM Role WHERE role = :roleName", Role.class)
                .setParameter("roleName", roleName).getSingleResult();
    }

    @Override
    public List<Role> findAll() {
        return entityManager.createQuery("FROM Role", Role.class).getResultList();
    }

    @Override
    public void save(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void update(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void delete(Role role) {
        Role roleEntry = entityManager.find(Role.class, role.getId());
        entityManager.remove(roleEntry);
    }

    @Override
    public void delete(Long id) {
        Role roleEntry = entityManager.find(Role.class, id);
        entityManager.remove(roleEntry);
    }
}
