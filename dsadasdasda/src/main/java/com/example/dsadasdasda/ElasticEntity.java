package com.example.dsadasdasda;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "index_payload_2021_04_05")
@Data
public class ElasticEntity {


        @Id
        private String id;

        @Field(type = FieldType.Text, name = "createdDate")
        private String  createdDate;

        @Field(type = FieldType.Text, name = "docType")
        private String docType;

        @Field(type = FieldType.Text, name = "appId")
        private String appId;

        @Field(type = FieldType.Integer, name = "messageId")
        private String messageId;

        @Field(type = FieldType.Text, name = "action")
        private String action;

        @Field(type = FieldType.Object, name = "body")
        private String  body;


        @Field(type = FieldType.Text, name = "operation")
        private String operation;

         @Field(type = FieldType.Text, name = "transactionId")
        private String transactionId;
}
