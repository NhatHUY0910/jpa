package com.practice_jpa_2.repository;

import com.practice_jpa_2.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CustomerRepository implements ICustomerRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(int id) {
        TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.id = :id", Customer.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() > 0) {
            em.merge(customer);
        } else {
            em.persist(customer);
        }
    }

    @Override
    public void delete(int id) {
        Customer c = em.find(Customer.class, id);
        if (c != null) {
            em.remove(c);
        }
    }
}
