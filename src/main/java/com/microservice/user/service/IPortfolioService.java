package com.microservice.user.service;

import com.microservice.user.dto.PortfolioDto;

import java.util.Optional;

public interface IPortfolioService {

    /**
     * @portfoliodto
     */
    void addPortfolio(String username);

    /**
     * @portfoliodto
     */
    void removePortfolio(String username);

    /**
     * @portfoliodto
     */
    void updatePortfolio(PortfolioDto portfolioDto, String username);

    /**
     * @portfoliodto
     */
    Optional<PortfolioDto> getPortfolio(String username);

}
