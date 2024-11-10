package com.microservice.user.service;

import com.microservice.user.dto.PortfolioDto;

public interface IPortfolioService {

    /**
     * @portfoliodto
     */
    void addPortfolio(PortfolioDto portfolioDto);

    /**
     * @portfoliodto
     */
    void removePortfolio(PortfolioDto portfolioDto);

    /**
     * @portfoliodto
     */
    void updatePortfolio(PortfolioDto portfolioDto);

    /**
     * @portfoliodto
     */
    void getPortfolio(PortfolioDto portfolioDto);

}
