package trainingneuralnetwork.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import trainingneuralnetwork.common.TypeLoan;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "Loan", schema = "public")
public class LoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id", unique = true)
    private Long id;
    @Column(name = "type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TypeLoan typeLoan;
    @Column(nullable = false)
    private Long amount;
    @Column(name = "initial_fee", nullable = false)
    private Long initialFee;
    @Column(name = "interest_rate", nullable = false)
    private Double interestRate;
    @Column(name = "credit_term", nullable = false)
    private Long creditTerm;
    @OneToOne(mappedBy = "loan")
    BorrowerEntity borrowerEntity;
}
