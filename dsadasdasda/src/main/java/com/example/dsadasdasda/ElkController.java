package com.example.dsadasdasda;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class ElkController {
    ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private EntityRepository entityRepository;
    private List<ElasticEntity> allEntities;

    public static void main(String[] args) {
        Date date = dateT("2021-03-27 22:21:39 PM TRT");
    }


   /* @GetMapping("indexprefix/{prefix}/{id}")
    public List<ElasticEntity> getInfo(@PathVariable String prefix,String id) {
        List<ElasticEntity> allByTransactionIdStartingWith = entityRepository.findAllByTransactionIdStartingWithAndAppId(prefix,"hip-sd-SALES_ORDER_KEYACCOUNT_CREATE-KASalesOrderScreateRoute");
        List<ElasticEntity> elasticEntities = new ArrayList<>();
        allByTransactionIdStartingWith.forEach(e-> {
            if (e.getBody().contains("exception")) {

                elasticEntities.add(e);
            }
        });


        return elasticEntities;
    }
*/

   /* @GetMapping("indexprefix/all/{prefix}")
    public List<ElasticEntity> getAll(@PathVariable String prefix) {
      return   entityRepository.findAllByTransactionIdStartingWithAndAppId(prefix,"hip-fi-SELLOUT_REPORT_CREDIT_CARD_SWEEP-SelloutCreditCardSweepReportRoute").stream().sorted(Comparator.comparing(ElasticEntity::getTransactionId)).collect(Collectors.toList());
    }*/

    public static Date dateT(String date) {

        String pm_trt = date.replace("PM TRT", "");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return simpleDateFormat.parse(pm_trt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/indexprefix/{prefix}")
    public List<ResponseDto> getInfo(@PathVariable String prefix) {
        final int pageCount = 100;
        List<ElasticEntity> allEntities = new ArrayList<>();
        int pageIndex = 0;
        List<ElasticEntity> allByTransactionIdStartingWith;
        do {
            Pageable pageable = PageRequest.of(pageIndex, pageCount);
            allByTransactionIdStartingWith = entityRepository.findAllByTransactionIdStartingWithAndAppId(prefix, "hip-fi-SELLOUT_UNPAID_INSTRUCTION-SelloutUnpaidInstructionReportRoute", pageable);

            List<ElasticEntity> collect = allByTransactionIdStartingWith.stream().sorted(Comparator.comparing(ElasticEntity::getTransactionId)).collect(Collectors.toList());
            allEntities.addAll(collect);
            pageIndex++;

        } while (allByTransactionIdStartingWith.size() >= pageCount);
        List<ResponseDto> responseDtos = new ArrayList<>();
        for (int i = 0; i < allEntities.size(); i = i + 4) {
            ResponseDto responseDto = calculateData(allEntities.get(i), allEntities.get(i + 1), allEntities.get(i + 2), allEntities.get(i + 3));
            responseDtos.add(responseDto);
        }

        return responseDtos;
    }

    @GetMapping("action/{prefix}")
    public List<JsonNode> getByAction(@PathVariable String prefix) throws Exception {
        Set<String> elasticEntities = new HashSet<>();
        List<String> allByMessageIdAndAction = entityRepository.findAllByMessageIdAndAction(0, prefix).stream().map(e -> e.getBody()).collect(Collectors.toList());
        List<JsonNode> collect = null;
        allByMessageIdAndAction
                .forEach(e -> {
                    try {
                        String s = objectMapper.writeValueAsString(e);
                        elasticEntities.add(s);

                    } catch (JsonProcessingException jsonProcessingException) {
                        jsonProcessingException.printStackTrace();
                    }
                });
        collect = elasticEntities.stream().map(e -> {
            try {
                return objectMapper.readValue(e, JsonNode.class);
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());

        return collect;
    }

    private ResponseDto calculateData(ElasticEntity req, ElasticEntity targetSystem, ElasticEntity targetResponse, ElasticEntity response) {
        ResponseDto dto = new ResponseDto();
        dto.setTransactionId(req.getTransactionId());
        dto.setReqArival(req.getCreatedDate().substring(11, 19));

        dto.setMwElapsedTimeforRequest((dateT(targetSystem.getCreatedDate()).getTime() - dateT(req.getCreatedDate()).getTime()) + " ms");
        dto.setRequestToEndpoint(targetSystem.getCreatedDate().substring(11, 19));
        dto.setEndpointResponseTime(targetResponse.getCreatedDate().substring(11, 19));
        dto.setEndpointElapsedTime((dateT(targetResponse.getCreatedDate()).getTime() - dateT(targetSystem.getCreatedDate()).getTime()) + " ms");
        dto.setMwResponseTime(response.getCreatedDate().substring(11, 19));

        dto.setMwElapsedTimeForResponse((dateT(response.getCreatedDate()).getTime() - dateT(targetResponse.getCreatedDate()).getTime()) + " ms");
        return dto;
    }
}