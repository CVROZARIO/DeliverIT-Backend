package com.caiovictor.deliverit.services;

import com.caiovictor.deliverit.entities.Billing;

import java.util.List;

public interface BillingService {
    Billing createBilling(Billing billing);
    List<Billing> getBillingList();
}
