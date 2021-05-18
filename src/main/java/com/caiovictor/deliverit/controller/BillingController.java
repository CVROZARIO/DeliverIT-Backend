package com.caiovictor.deliverit.controller;

import com.caiovictor.deliverit.entities.Billing;
import com.caiovictor.deliverit.entities.SimpleKeyValue;
import com.caiovictor.deliverit.services.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @RequestMapping("/")
    public List<SimpleKeyValue> getApiIndex() {
        List<SimpleKeyValue> pairs = new ArrayList<>();
        pairs.add(new SimpleKeyValue("/billing/create", "[POST] Inclusão de conta a pagar"));
        pairs.add(new SimpleKeyValue("/billing/list", "[GET] Listagem das contas cadastradas"));
        return pairs;
    }

    @PostMapping("/billing/create")
    public Billing createBilling(@RequestBody Billing billing) {
        return billingService.createBilling(billing);
    }

    @GetMapping("/billing/list")
    public List<Billing> getBillingList() {
        return billingService.getBillingList();
    }

}
