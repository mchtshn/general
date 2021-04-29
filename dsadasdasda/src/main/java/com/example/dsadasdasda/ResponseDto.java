package com.example.dsadasdasda;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ResponseDto {
        private String transactionId;
        @JsonFormat(pattern = "HH:mm:ss")
        private String  reqArival;
        private String  mwElapsedTimeforRequest;
        @JsonFormat(pattern = "HH:mm:ss")
        private String  requestToEndpoint;
        private String endpointElapsedTime;
        private String endpointResponseTime;
        private String mwElapsedTimeForResponse;
        @JsonFormat(pattern = "HH:mm:ss")
        private String  mwResponseTime;
}
