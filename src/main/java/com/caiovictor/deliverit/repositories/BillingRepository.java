package com.caiovictor.deliverit.repositories;

import com.caiovictor.deliverit.entities.Billing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BillingRepository extends CrudRepository<Billing, Long> {
}