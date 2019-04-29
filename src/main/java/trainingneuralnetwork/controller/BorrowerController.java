package trainingneuralnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import trainingneuralnetwork.common.Utils;
import trainingneuralnetwork.entity.BorrowerEntity;
import trainingneuralnetwork.entity.CoBorrowerEntity;
import trainingneuralnetwork.entity.LoanEntity;
import trainingneuralnetwork.entity.model.BorrowerFlatJsonModel;
import trainingneuralnetwork.entity.model.PrepareDataModel;
import trainingneuralnetwork.service.BorrowerService;

import java.util.LinkedList;
import java.util.List;

@RestController
public class BorrowerController {

    private BorrowerService borrowerService;

    @Autowired
    public BorrowerController(BorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }

    @RequestMapping(value = "/borrower", method = RequestMethod.GET)
    public List<BorrowerFlatJsonModel> getClusterBorrowers(@RequestParam("id") Long id, @RequestParam("length") Long len) {
        List<BorrowerEntity> borrowerEntities = borrowerService.getCluster(id, len);
        List<BorrowerFlatJsonModel> borrowerModels = new LinkedList<>();

        borrowerEntities.forEach(borrowerEntity -> {
            BorrowerFlatJsonModel borrowerFlatJsonModel;

            CoBorrowerEntity coBorrowerEntity = borrowerEntity.getCoBorrower();
            LoanEntity loanEntity = borrowerEntity.getLoan();
            borrowerFlatJsonModel =
                    BorrowerFlatJsonModel.builder()
                            .id(borrowerEntity.getId())
                            .beginDateOfSeniority(borrowerEntity.getBeginDateOfSeniority())
                            .certificate(borrowerEntity.getCertificate())
                            .salary(borrowerEntity.getSalary())
                            .dateOfBirth(borrowerEntity.getDateOfBirth())
                            .otherLoan(borrowerEntity.getOtherLoan())
                            .creditHistoryAssessment(borrowerEntity.getCreditHistoryAssessment())

                            .coBorrowerBeginDateOfSeniority(coBorrowerEntity != null ?
                                    coBorrowerEntity.getBeginDateOfSeniority() : null)
                            .coBorrowerCertificate(coBorrowerEntity != null ?
                                    coBorrowerEntity.getCertificate() : null)
                            .coBorrowerSalary(coBorrowerEntity != null ?
                                    coBorrowerEntity.getSalary() : null)
                            .coBorrowerDateOfBirth(coBorrowerEntity != null ?
                                    coBorrowerEntity.getDateOfBirth() : null)
                            .coBorrowerOtherLoan(coBorrowerEntity != null ?
                                    coBorrowerEntity.getOtherLoan() : null)
                            .coBorrowerCreditHistoryAssessment(coBorrowerEntity != null ?
                                    coBorrowerEntity.getCreditHistoryAssessment() : null)

                            .loanTypeLoan(loanEntity.getTypeLoan())
                            .loanAmount(loanEntity.getAmount())
                            .loanInitialFee(loanEntity.getInitialFee())
                            .loanInterestRate(loanEntity.getInterestRate())
                            .loanCreditTerm(loanEntity.getCreditTerm())
                            .result(borrowerEntity.getResult())
                            .build();

            borrowerModels.add(borrowerFlatJsonModel);
        });
        return borrowerModels;
    }


        @RequestMapping(value = "/borrower/count", method = RequestMethod.GET)
    public Long getCountRowBorrowers() {
        return borrowerService.getCountRow();
    }

}