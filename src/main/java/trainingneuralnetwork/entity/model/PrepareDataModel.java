package trainingneuralnetwork.entity.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class PrepareDataModel {
    private long id;
    private Integer mortgage;
    private Integer autoLoan;
    private Integer instantLoan;
    private Long beginDateOfSeniority;
    private Long salary;
    private Integer certificate;
    private Integer otherLoan;
    private Long dateOfBirth;
    private Long creditHistoryAssessment;
    private Long coBorrowerBeginDateOfSeniority;
    private Long coBorrowerSalary;
    private Integer coBorrowerCertificate;
    private Integer coBorrowerOtherLoan;
    private Long coBorrowerDateOfBirth;
    private Long coBorrowerCreditHistoryAssessment;
    private Long loanAmount;
    private Long loanInitialFee;
    private Double loanInterestRate;
    private Long loanCreditTerm;
    private Integer result;
}
