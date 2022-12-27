package com.imodupsy.fraud.dao;

import com.imodupsy.fraud.model.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author iModupsy
 * @created 26/12/2022
 */
public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {
}
