package trainingneuralnetwork.entity.model;

import lombok.*;
import trainingneuralnetwork.entity.BorrowerEntity;
import trainingneuralnetwork.entity.CoBorrowerEntity;
import trainingneuralnetwork.entity.LoanEntity;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class BorrowerModel {
    private Long id;
    private Date beginDateOfSeniority;
    private Long salary;
    private Boolean certificate;
    private Boolean otherLoan;
    private Date dateOfBirth;
    private Long creditHistoryAssessment;
    private CoBorrowerModel coBorrower;
    private LoanModel loan;
    private Boolean result;

    public BorrowerModel(BorrowerEntity borrowerEntity) {
        CoBorrowerEntity coBorrowerEntity = borrowerEntity.getCoBorrower();

        this.id = borrowerEntity.getId();
        this.beginDateOfSeniority = borrowerEntity.getBeginDateOfSeniority();
        this.salary = borrowerEntity.getSalary();
        this.certificate = borrowerEntity.getCertificate();
        this.otherLoan = borrowerEntity.getOtherLoan();
        this.dateOfBirth = borrowerEntity.getDateOfBirth();
        this.creditHistoryAssessment = borrowerEntity.getCreditHistoryAssessment();
        this.coBorrower = coBorrowerEntity == null ? null : new CoBorrowerModel(coBorrowerEntity);
        this.loan = new LoanModel(borrowerEntity.getLoan());
        this.result = borrowerEntity.getResult();
    }
}
