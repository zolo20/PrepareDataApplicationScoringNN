package trainingneuralnetwork.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "co_Borrower", schema = "public")
public class CoBorrowerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "co_Borrower_id", unique = true)
    private Long id;
    @Column(name = "begin_date_of_seniority", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date beginDateOfSeniority;
    @Column(nullable = false)
    private Long salary;
    @Column(nullable = false)
    private Boolean certificate;
    @Column(name = "other_loan", nullable = false)
    private Boolean otherLoan;
    @Column(name = "date_of_birth", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "credit_history_assessment", nullable = false)
    private Long creditHistoryAssessment;
    @OneToOne(mappedBy="coBorrower")
    BorrowerEntity borrowerEntity;
}
