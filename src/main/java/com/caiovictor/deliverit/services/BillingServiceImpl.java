package com.caiovictor.deliverit.services;

import com.caiovictor.deliverit.entities.Billing;
import com.caiovictor.deliverit.repositories.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class BillingServiceImpl implements BillingService {

    @Autowired
    private BillingRepository billingRepository;

    @Override
    public Billing createBilling(Billing billing) {

        long delayedDays;
        if (billing.getPaymentDate() != null
                && (delayedDays = DAYS.between(billing.getDueDate().toInstant(), billing.getPaymentDate().toInstant())) > 0) {
            billing.setDelayedDays(delayedDays);
            if (delayedDays > 5) {
                billing.setFinePercentageOfExpiration(5);
                billing.setFineDailyPercentage(0.3);
            } else if (delayedDays > 3) {
                billing.setFinePercentageOfExpiration(3);
                billing.setFineDailyPercentage(0.2);
            } else {
                billing.setFinePercentageOfExpiration(2);
                billing.setFineDailyPercentage(0.1);
            }
            billing.setPriceFinal(
                    billing.getPriceOriginal().add(
                            billing.getPriceOriginal().multiply(BigDecimal.valueOf(billing.getFinePercentageOfExpiration() / 100d))
                                    .add(BigDecimal.valueOf(delayedDays).multiply(billing.getPriceOriginal().multiply(BigDecimal.valueOf(billing.getFineDailyPercentage() / 100d))))
                    )
            );
        } else {
            billing.setPriceFinal(billing.getPriceOriginal());
        }
        return billingRepository.save(billing);
    }

    @Override
    public List<Billing> getBillingList() {
        return StreamSupport.stream(billingRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}
