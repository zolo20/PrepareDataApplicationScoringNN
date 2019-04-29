package trainingneuralnetwork.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainingneuralnetwork.entity.CoBorrowerEntity;
import trainingneuralnetwork.entity.model.CoBorrowerModel;
import trainingneuralnetwork.repository.interfaceDAO.CoBorrowerDAO;

@Service
public class CoBorrowerService {

    private CoBorrowerDAO coBorrowerDAO;

    @Autowired
    public CoBorrowerService(CoBorrowerDAO coBorrowerDAO) {
        this.coBorrowerDAO = coBorrowerDAO;
    }

    public CoBorrowerEntity saveCoBorrower(@NonNull CoBorrowerModel coBorrowerModel) {
        CoBorrowerEntity coBorrowerEntity =
                CoBorrowerEntity.builder()
                        .beginDateOfSeniority(coBorrowerModel.getBeginDateOfSeniority())
                        .salary(coBorrowerModel.getSalary())
                        .certificate(coBorrowerModel.getCertificate())
                        .otherLoan(coBorrowerModel.getOtherLoan())
                        .dateOfBirth(coBorrowerModel.getDateOfBirth())
                        .creditHistoryAssessment(coBorrowerModel.getCreditHistoryAssessment())
                        .build();
        coBorrowerDAO.save(coBorrowerEntity);

        return coBorrowerEntity;
    }
}
