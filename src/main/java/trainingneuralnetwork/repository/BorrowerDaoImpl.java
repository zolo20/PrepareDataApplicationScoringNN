package trainingneuralnetwork.repository;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import trainingneuralnetwork.entity.BorrowerEntity;
import trainingneuralnetwork.repository.interfaceDAO.BorrowerDAO;

import java.util.List;

@Repository
public class BorrowerDaoImpl implements BorrowerDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public BorrowerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(BorrowerEntity borrowerEntity) {
        sessionFactory.getCurrentSession().save(borrowerEntity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<BorrowerEntity> getAllBorrower() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM BorrowerEntity").list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<BorrowerEntity> getClusterBorrower(Long id, Long len) {
        Query query =  sessionFactory.getCurrentSession()
                .createQuery("FROM BorrowerEntity WHERE id >= :id AND id < :id + :len");
        query.setParameter("id", id);
        query.setParameter("len", len);
        return query.list();
    }

    @Override
    public Long getCountRow() {
        return (Long) sessionFactory.getCurrentSession().createQuery("SELECT COUNT(id) FROM BorrowerEntity").list().get(0);
    }
}
