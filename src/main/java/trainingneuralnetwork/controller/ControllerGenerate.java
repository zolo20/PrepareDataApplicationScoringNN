package trainingneuralnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import trainingneuralnetwork.common.TypeLoan;
import trainingneuralnetwork.common.Utils;
import trainingneuralnetwork.entity.model.BorrowerModel;
import trainingneuralnetwork.entity.model.CoBorrowerModel;
import trainingneuralnetwork.entity.model.LoanModel;
import trainingneuralnetwork.service.BorrowerService;
import trainingneuralnetwork.service.CoBorrowerService;
import trainingneuralnetwork.service.LoanService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

@RestController
public class ControllerGenerate {

    private BorrowerService borrowerService;
    private CoBorrowerService coBorrowerService;
    private LoanService loanService;

    @Autowired
    public ControllerGenerate(BorrowerService borrowerService, CoBorrowerService coBorrowerService, LoanService loanService) {
        this.borrowerService = borrowerService;
        this.coBorrowerService = coBorrowerService;
        this.loanService = loanService;
    }

    @RequestMapping(value = "/generate", method = RequestMethod.GET)
    public int generateCreditInfo() {
        int count = 0;
        for (int i = 0; i < 100_000; i++) {
            LocalDate randomDateSeniority = Utils.createRandomDate(1992, 2019);
            LocalDate randomDateOfBirth = Utils.createRandomDate(1940, 2001);

            LocalDate randomDateSeniorityCoBor = Utils.createRandomDate(1992, 2019);
            LocalDate randomDateOfBirthCoBor = Utils.createRandomDate(1940, 2001);

            Date beginDateOfSeniority = Date.from(randomDateSeniority.atStartOfDay(ZoneId.systemDefault()).toInstant());
            Long salary = Utils.getRandom(7500, 300_001).longValue();
            Boolean certificate = new Random().nextInt(2) == 1;
            Boolean otherLoan = new Random().nextInt(2) == 1;
            Date dateOfBirth = Date.from(randomDateOfBirth.atStartOfDay(ZoneId.systemDefault()).toInstant());
            Long creditHistoryAssessment = Utils.getRandom(300, 851).longValue();
            CoBorrowerModel coBorrower = null;
            if (new Random().nextInt(2) == 1) {
                coBorrower = CoBorrowerModel.builder()
                        .beginDateOfSeniority(Date.from(randomDateSeniorityCoBor.atStartOfDay(ZoneId.systemDefault()).toInstant()))
                        .salary(Utils.getRandom(7500, 300_000).longValue())
                        .certificate(new Random().nextInt(2) == 1)
                        .otherLoan(new Random().nextInt(2) == 1)
                        .dateOfBirth(Date.from(randomDateOfBirthCoBor.atStartOfDay(ZoneId.systemDefault()).toInstant()))
                        .creditHistoryAssessment(Utils.getRandom(300, 851).longValue())
                        .build();
            }

            Long amount = Utils.getRandom(7500, 300_000).longValue();
            Integer typeRandom = Utils.getRandom(0, 3).intValue();
            Double interestRate = typeRandom == 0 ? Math.rint(Utils.getRandomDouble(6.5, 18.0) * 10.0)/10.0 :
                    typeRandom == 1 ? Math.rint(Utils.getRandomDouble(15.0, 30.0) * 10.0)/10.0 :
                            typeRandom == 2 ? Math.rint(Utils.getRandomDouble(15.0, 30.0) * 10.0)/ 10.0 : 15.0;

            LoanModel loan =
                    LoanModel.builder()
                            .typeLoan(TypeLoan.values()[typeRandom])
                            .amount(amount)
                            .initialFee(Utils.getRandom((int) Math.round(amount.intValue() * 0.2), amount.intValue() + 1).longValue())
                            .interestRate(interestRate)
                            .creditTerm(Utils.getRandom(1, 31).longValue())
                            .build();

            BorrowerModel borrower =
                    BorrowerModel
                            .builder()
                            .beginDateOfSeniority(beginDateOfSeniority)
                            .salary(salary)
                            .certificate(certificate)
                            .otherLoan(otherLoan)
                            .dateOfBirth(dateOfBirth)
                            .creditHistoryAssessment(creditHistoryAssessment)
                            .coBorrower(coBorrower)
                            .loan(loan)
                            .result(new Random().nextInt(2) == 1)
                            .build();

            borrowerService.saveBorrower(borrower, loanService.saveLoan(loan), coBorrower != null ? coBorrowerService.saveCoBorrower(coBorrower) : null);
            count++;
        }
        return count;
    }
}
