package com.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ExchangeValueRepository
 */
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

    ExchangeValue findByFromAndTo(String from, String to);
}