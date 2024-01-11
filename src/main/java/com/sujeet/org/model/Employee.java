package com.sujeet.org.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Entity
@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="employee")
@ApiModel
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;// MySql doe't support the Integer types data types like(private int pinNumber)
    @ApiModelProperty(notes = "name of the employee")
    private String name;
    @ApiModelProperty(notes = "address of the employee")
    private String address;
    private String state;

    private Long pinNumber;

    private Long mobileNumber;
}
