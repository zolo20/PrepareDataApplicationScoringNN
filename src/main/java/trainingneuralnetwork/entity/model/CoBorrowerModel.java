package trainingneuralnetwork.entity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import trainingneuralnetwork.entity.CoBorrowerEntity;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CoBorrowerModel {
    private Date beginDateOfSeniority;
    private Long salary;
    private Boolean certificate;
    private Boolean otherLoan;
    private Date dateOfBirth;
    private Long creditHistoryAssessment;

    public CoBorrowerModel(CoBorrowerEntity coBorrowerEntity) {
        this.beginDateOfSeniority = coBorrowerEntity.getBeginDateOfSeniority();
        this.salary = coBorrowerEntity.getSalary();
        this.certificate = coBorrowerEntity.getCertificate();
        this.otherLoan = coBorrowerEntity.getOtherLoan();
        this.dateOfBirth = coBorrowerEntity.getDateOfBirth();
        this.creditHistoryAssessment = coBorrowerEntity.getCreditHistoryAssessment();
    }
}
