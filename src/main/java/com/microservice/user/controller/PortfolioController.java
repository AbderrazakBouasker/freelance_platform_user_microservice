package com.microservice.user.controller;

import com.microservice.user.dto.PortfolioDto;
import com.microservice.user.service.IPortfolioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/portfolios")
@AllArgsConstructor
public class PortfolioController {

    private IPortfolioService portfolioService;

    @PostMapping("/{username}")
    public void addPortfolio(@PathVariable String username) {
        portfolioService.addPortfolio(username);
    }

    @DeleteMapping("/{username}")
    public void removePortfolio(@PathVariable String username) {
        portfolioService.removePortfolio(username);
    }

    @PutMapping("/{username}")
    public void updatePortfolio(@RequestBody PortfolioDto portfolioDto, @PathVariable String username) {
        portfolioService.updatePortfolio(portfolioDto, username);
    }

    @GetMapping("/{username}")
    public Optional<PortfolioDto> getPortfolio(@PathVariable String username) {
        return portfolioService.getPortfolio(username);
    }
}
