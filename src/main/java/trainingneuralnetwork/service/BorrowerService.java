package trainingneuralnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainingneuralnetwork.entity.BorrowerEntity;
import trainingneuralnetwork.entity.CoBorrowerEntity;
import trainingneuralnetwork.entity.LoanEntity;
import trainingneuralnetwork.entity.model.BorrowerModel;
import trainingneuralnetwork.repository.interfaceDAO.BorrowerDAO;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class BorrowerService {

    private BorrowerDAO borrowerDAO;

    @Autowired
    public BorrowerService(BorrowerDAO borrowerDAO) {
        this.borrowerDAO = borrowerDAO;
    }

    public BorrowerEntity saveBorrower(@NotNull BorrowerModel borrowerModel, @NotNull LoanEntity loanEntity, CoBorrowerEntity coBorrowerEntity) {
        BorrowerEntity borrowerEntity =
                BorrowerEntity.builder()
                        .beginDateOfSeniority(borrowerModel.getBeginDateOfSeniority())
                        .salary(borrowerModel.getSalary())
                        .certificate(borrowerModel.getCertificate())
                        .otherLoan(borrowerModel.getOtherLoan())
                        .dateOfBirth(borrowerModel.getDateOfBirth())
                        .creditHistoryAssessment(borrowerModel.getCreditHistoryAssessment())
                        .loan(loanEntity)
                        .result(borrowerModel.getResult())
                        .build();
        if (coBorrowerEntity != null) {
            borrowerEntity.setCoBorrower(coBorrowerEntity);
        }

        borrowerDAO.save(borrowerEntity);
        return borrowerEntity;
    }

    public List<BorrowerEntity> getAll() {
        return borrowerDAO.getAllBorrower();
    }

    public List<BorrowerEntity> getCluster(Long id, Long len) {
        return borrowerDAO.getClusterBorrower(id, len);
    }

    public Long getCountRow() {
        return borrowerDAO.getCountRow();
    }
}
