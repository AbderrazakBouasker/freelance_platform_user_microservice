package com.microservice.user.service.impl;

import com.microservice.user.dto.PortfolioDto;
import com.microservice.user.entity.PortfolioEntity;
import com.microservice.user.entity.UserEntity;
import com.microservice.user.mapper.PortfolioMapper;
import com.microservice.user.repository.PortfolioRepository;
import com.microservice.user.repository.UserRepository;
import com.microservice.user.service.IPortfolioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

//todo: Add fetch Jobs and Skills in PortfolioDto
@Service
@AllArgsConstructor
public class PortfolioService implements IPortfolioService {

    private PortfolioRepository portfolioRepository;
    private UserRepository userRepository;

    /**
     * @param username
     * @portfoliodto
     */
    @Override
    public void addPortfolio(String username) {
        Optional<UserEntity> optionalUser = userRepository.findByUserName(username);
        if (optionalUser.isPresent()) {
            PortfolioEntity portfolioEntity = new PortfolioEntity();
            portfolioEntity.setUser(optionalUser.get());
            portfolioRepository.save(portfolioEntity);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public void removePortfolio(String username) {
        Optional<UserEntity> optionalUser = userRepository.findByUserName(username);
        if (optionalUser.isPresent()) {
            Optional<PortfolioEntity> optionalPortfolio = portfolioRepository.findByUser(optionalUser.get());
            optionalPortfolio.ifPresent(portfolioRepository::delete);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public void updatePortfolio(PortfolioDto portfolioDto, String username) {
        Optional<UserEntity> optionalUser = userRepository.findByUserName(username);
        if (optionalUser.isPresent()) {
            Optional<PortfolioEntity> optionalPortfolio = portfolioRepository.findByUser(optionalUser.get());
            if (optionalPortfolio.isPresent()) {
                PortfolioEntity portfolioEntity = PortfolioMapper.mapToPortfolioEntity(portfolioDto, optionalPortfolio.get());
                portfolioRepository.save(portfolioEntity);
            }
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public Optional<PortfolioDto> getPortfolio(String username) {
        Optional<UserEntity> optionalUser = userRepository.findByUserName(username);
        if (optionalUser.isPresent()) {
            Optional<PortfolioEntity> optionalPortfolio = portfolioRepository.findByUser(optionalUser.get());
            return optionalPortfolio.map(portfolioEntity -> PortfolioMapper.mapToPortfolioDto(portfolioEntity, new PortfolioDto()));
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
