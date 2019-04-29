package trainingneuralnetwork.entity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import trainingneuralnetwork.common.TypeLoan;
import trainingneuralnetwork.entity.LoanEntity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LoanModel {
    private TypeLoan typeLoan;
    private Long amount;
    private Long initialFee;
    private Double interestRate;
    private Long creditTerm;

    public LoanModel(LoanEntity loanEntity) {
        this.typeLoan = loanEntity.getTypeLoan();
        this.amount = loanEntity.getAmount();
        this.initialFee = loanEntity.getInitialFee();
        this.interestRate = loanEntity.getInterestRate();
        this.creditTerm = loanEntity.getCreditTerm();
    }
}
