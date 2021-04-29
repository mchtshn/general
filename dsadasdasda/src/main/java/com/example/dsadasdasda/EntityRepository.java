package com.example.dsadasdasda;

import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EntityRepository extends ElasticsearchRepository<ElasticEntity, String> {
        List<ElasticEntity> findAllByTransactionIdStartingWithAndAppId(String startParameter, String action, Pageable pageable);
        List<ElasticEntity> findAllByMessageIdAndAction(Integer startParameter,String action);
}


