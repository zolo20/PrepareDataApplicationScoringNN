package trainingneuralnetwork.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import trainingneuralnetwork.entity.LoanEntity;
import trainingneuralnetwork.repository.interfaceDAO.LoanDAO;

@Repository
public class LoanDaoImpl implements LoanDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public LoanDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(LoanEntity loanEntity) {
        sessionFactory.getCurrentSession().save(loanEntity);
    }
}
