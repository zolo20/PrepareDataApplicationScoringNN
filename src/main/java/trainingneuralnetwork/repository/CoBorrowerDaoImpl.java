package trainingneuralnetwork.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import trainingneuralnetwork.entity.CoBorrowerEntity;
import trainingneuralnetwork.repository.interfaceDAO.CoBorrowerDAO;

@Repository
public class CoBorrowerDaoImpl implements CoBorrowerDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public CoBorrowerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(CoBorrowerEntity coBorrowerEntity) {
        sessionFactory.getCurrentSession().save(coBorrowerEntity);
    }
}
