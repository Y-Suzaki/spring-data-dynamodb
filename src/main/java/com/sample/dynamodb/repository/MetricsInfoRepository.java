package com.sample.dynamodb.repository;

import com.sample.dynamodb.model.MetricsInfo;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MetricsInfoRepository extends CrudRepository<MetricsInfo, String> {
    @EnableScan
    List<MetricsInfo> findAll();

    List<MetricsInfo> findByWorkflow(String workflow);
}
