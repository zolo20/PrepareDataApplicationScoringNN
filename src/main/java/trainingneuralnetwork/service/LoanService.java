package trainingneuralnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainingneuralnetwork.entity.LoanEntity;
import trainingneuralnetwork.entity.model.LoanModel;
import trainingneuralnetwork.repository.interfaceDAO.LoanDAO;

import javax.validation.constraints.NotNull;

@Service
public class LoanService {

    private LoanDAO loanDAO;

    @Autowired
    public LoanService(@NotNull LoanDAO loanDAO) {
        this.loanDAO = loanDAO;
    }

    public LoanEntity saveLoan(@NotNull LoanModel loanModel) {
        LoanEntity loanEntity =
                LoanEntity.builder()
                        .typeLoan(loanModel.getTypeLoan())
                        .amount(loanModel.getAmount())
                        .initialFee(loanModel.getInitialFee())
                        .interestRate(loanModel.getInterestRate())
                        .creditTerm(loanModel.getCreditTerm())
                        .build();
        loanDAO.save(loanEntity);

        return loanEntity;
    }
}
