package trainingneuralnetwork.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Builder
@Entity
@Table(name = "Borrower", schema = "public")
public class BorrowerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "co_Borrower_id")
    private CoBorrowerEntity coBorrower;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_id")
    private LoanEntity loan;

    @Column(nullable = false)
    private Boolean result;
}
