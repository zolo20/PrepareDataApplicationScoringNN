package trainingneuralnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trainingneuralnetwork.common.Utils;
import trainingneuralnetwork.entity.BorrowerEntity;
import trainingneuralnetwork.entity.CoBorrowerEntity;
import trainingneuralnetwork.entity.LoanEntity;
import trainingneuralnetwork.entity.model.BorrowerModel;
import trainingneuralnetwork.entity.model.PrepareDataModel;
import trainingneuralnetwork.service.BorrowerService;

import java.util.LinkedList;
import java.util.List;

@RestController
public class LearningController {

    private BorrowerService borrowerService;

    @Autowired
    public LearningController(BorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }

    @RequestMapping(value = "/learning", method = RequestMethod.GET)
    public List<PrepareDataModel> getLearningDataClusterBorrowers(@RequestParam("id") Long id, @RequestParam("length") Long len) {
        List<BorrowerModel> borrowerModels = new LinkedList<>();
        borrowerService.getCluster(id, len).forEach(borrowerEntity -> borrowerModels.add(new BorrowerModel(borrowerEntity)));
        List<PrepareDataModel> prepareDataModels = new LinkedList<>();
        borrowerModels.forEach(borrowerModel -> prepareDataModels.add(Utils.prepareData(borrowerModel)));
        return prepareDataModels;
    }

}
