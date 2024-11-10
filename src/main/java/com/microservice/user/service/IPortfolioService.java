package com.microservice.user.service;

public interface IPortfolioService {

    /**
     * @param portfolio
     */
    void addPortfolio(String portfolio);

    /**
     * @param portfolio
     */
    void removePortfolio(String portfolio);

    /**
     * @param portfolio
     */
    void updatePortfolio(String portfolio);

    /**
     * @param portfolio
     */
    void getPortfolio(String portfolio);

}
