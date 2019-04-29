package trainingneuralnetwork.repository.interfaceDAO;

import trainingneuralnetwork.entity.BorrowerEntity;

import java.util.List;

public interface BorrowerDAO {
    void save(BorrowerEntity borrowerEntity);
    List<BorrowerEntity> getAllBorrower();
    List<BorrowerEntity> getClusterBorrower(Long id, Long length);
    Long getCountRow();
}
