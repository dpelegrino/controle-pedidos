package br.com.eicon.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ProductOrderVO {
    private LocalDate dateRegister;

    private Long controlNumber;

    private String name;

    private BigDecimal productValue;

    private Long productAmount;

    private Long clientCode;
}
