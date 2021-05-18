package com.caiovictor.deliverit.entities;

import com.caiovictor.deliverit.helpers.MoneySerializerHelper;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Billing extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(nullable = false)
    @JsonSerialize(using = MoneySerializerHelper.class)
    private BigDecimal priceOriginal;

    @Column(nullable = false)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="EST")
    private Date dueDate;

    @Column(nullable = false)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="EST")
    private Date paymentDate;

    @Column(nullable = false)
    @JsonSerialize(using = MoneySerializerHelper.class)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private BigDecimal priceFinal;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long delayedDays;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private double finePercentageOfExpiration;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private double fineDailyPercentage;

    public Billing() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPriceOriginal() {
        return priceOriginal;
    }

    public void setPriceOriginal(BigDecimal priceOriginal) {
        this.priceOriginal = priceOriginal;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getPriceFinal() {
        return priceFinal;
    }

    public void setPriceFinal(BigDecimal priceFinal) {
        this.priceFinal = priceFinal;
    }

    public long getDelayedDays() {
        return delayedDays;
    }

    public void setDelayedDays(long delayedDays) {
        this.delayedDays = delayedDays;
    }

    public double getFinePercentageOfExpiration() {
        return finePercentageOfExpiration;
    }

    public void setFinePercentageOfExpiration(double finePercentageOfExpiration) {
        this.finePercentageOfExpiration = finePercentageOfExpiration;
    }

    public double getFineDailyPercentage() {
        return fineDailyPercentage;
    }

    public void setFineDailyPercentage(double fineDailyPercentage) {
        this.fineDailyPercentage = fineDailyPercentage;
    }
}
