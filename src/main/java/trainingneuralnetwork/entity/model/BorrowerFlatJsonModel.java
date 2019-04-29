package trainingneuralnetwork.entity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import trainingneuralnetwork.common.TypeLoan;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BorrowerFlatJsonModel {
    private Long id;
    private Date beginDateOfSeniority;
    private Long salary;
    private Boolean certificate;
    private Boolean otherLoan;
    private Date dateOfBirth;
    private Long creditHistoryAssessment;
    private Date coBorrowerBeginDateOfSeniority;
    private Long coBorrowerSalary;
    private Boolean coBorrowerCertificate;
    private Boolean coBorrowerOtherLoan;
    private Date coBorrowerDateOfBirth;
    private Long coBorrowerCreditHistoryAssessment;
    private TypeLoan loanTypeLoan;
    private Long loanAmount;
    private Long loanInitialFee;
    private Double loanInterestRate;
    private Long loanCreditTerm;
    private Boolean result;
}
