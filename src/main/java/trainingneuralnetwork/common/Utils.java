package trainingneuralnetwork.common;

import trainingneuralnetwork.entity.model.BorrowerModel;
import trainingneuralnetwork.entity.model.CoBorrowerModel;
import trainingneuralnetwork.entity.model.LoanModel;
import trainingneuralnetwork.entity.model.PrepareDataModel;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;

public class Utils {
    public static Number getRandom(int from, int to) {
        if (from < to)
            return from + new Random().nextInt(Math.abs(to - from));
        return from - new Random().nextInt(Math.abs(to - from));
    }

    private static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static LocalDate createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }

    public static Double getRandomDouble(Double rangeMin, Double rangeMax) {
        Random r = new Random();
        return rangeMin + (rangeMax - rangeMin) * r.nextDouble();
    }

    private static Long getDifferentDay(Date date) {
        LocalDate localDate = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currLocalDate = LocalDate.now();
        return ChronoUnit.DAYS.between(localDate, currLocalDate);
    }

    private static Integer convertBoolToInt(Boolean variable) {
        return variable ? 1 : 0;
    }

    public static PrepareDataModel prepareData(BorrowerModel borrowerModel) {
        CoBorrowerModel coBorrowerModel = borrowerModel.getCoBorrower();
        LoanModel loanModel = borrowerModel.getLoan();
        PrepareDataModel prepareDataModel;

        prepareDataModel = PrepareDataModel
                .builder()
                    .beginDateOfSeniority(getDifferentDay(borrowerModel.getBeginDateOfSeniority()))
                    .salary(borrowerModel.getSalary())
                    .certificate(convertBoolToInt(borrowerModel.getCertificate()))
                    .otherLoan(convertBoolToInt(borrowerModel.getOtherLoan()))
                    .dateOfBirth(getDifferentDay(borrowerModel.getDateOfBirth()))
                    .creditHistoryAssessment(borrowerModel.getCreditHistoryAssessment())

                    .coBorrowerBeginDateOfSeniority(coBorrowerModel != null ?
                            getDifferentDay(coBorrowerModel.getBeginDateOfSeniority()) : 0)
                    .coBorrowerCertificate(coBorrowerModel != null ?
                            convertBoolToInt(coBorrowerModel.getCertificate()) : 0)
                    .coBorrowerSalary(coBorrowerModel != null ?
                            coBorrowerModel.getSalary() : 0)
                    .coBorrowerDateOfBirth(coBorrowerModel != null ?
                            getDifferentDay(coBorrowerModel.getDateOfBirth()) : 0)
                    .coBorrowerOtherLoan(coBorrowerModel != null ?
                            convertBoolToInt(coBorrowerModel.getOtherLoan()) : 0)
                    .coBorrowerCreditHistoryAssessment(coBorrowerModel != null ?
                            coBorrowerModel.getCreditHistoryAssessment() : 0)

                    .instantLoan(loanModel.getTypeLoan().toString().equals("MG") ||
                            loanModel.getTypeLoan().toString().equals("CL") ? 0 : 1)
                    .autoLoan(loanModel.getTypeLoan().toString().equals("MG") ||
                            loanModel.getTypeLoan().toString().equals("IL") ? 0 : 1)
                    .mortgage(loanModel.getTypeLoan().toString().equals("CL") ||
                            loanModel.getTypeLoan().toString().equals("IL") ? 0 : 1)

                    .loanAmount(loanModel.getAmount())
                    .loanInitialFee(loanModel.getInitialFee())
                    .loanInterestRate(loanModel.getInterestRate())
                    .loanCreditTerm(loanModel.getCreditTerm())
                .build();

        if (borrowerModel.getId() != null) {
            prepareDataModel.setId(borrowerModel.getId());
        }

        if (borrowerModel.getResult() != null) {
            prepareDataModel.setResult(convertBoolToInt(borrowerModel.getResult()));
        }

        return prepareDataModel;
    }

}
