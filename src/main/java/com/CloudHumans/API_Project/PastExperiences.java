package com.CloudHumans.API_Project;

public class PastExperiences {
    private boolean sales;
    private boolean support;

    public PastExperiences(boolean sales, boolean support) {
        this.sales = sales;
        this.support = support;
    }

    public PastExperiences() {
    }

    public boolean isSales() {
        return sales;
    }

    public void setSales(boolean sales) {
        this.sales = sales;
    }

    public boolean isSupport() {
        return support;
    }

    public void setSupport(boolean support) {
        this.support = support;
    }
}
