package trainingneuralnetwork.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import trainingneuralnetwork.common.Utils;
import trainingneuralnetwork.entity.model.BorrowerModel;
import trainingneuralnetwork.entity.model.PrepareDataModel;
import trainingneuralnetwork.entity.model.Result;

@RestController
public class PredictController {

    @RequestMapping(value = "/predict", method = RequestMethod.POST)
    public static Double predict(@RequestBody BorrowerModel borrowerModel) {
        PrepareDataModel prepareDataModel = Utils.prepareData(borrowerModel);
        final String uri = "http://127.0.0.1:5000/predict";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(uri,
                prepareDataModel, String.class);
        return Double.parseDouble(responseEntity.getBody());
    }


}
