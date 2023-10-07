package br.com.eicon.dto;

import br.com.eicon.entity.Client;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ProductOrderDTO {

	private Long id;

	private Long controlNumber;

	private Client client;

	private LocalDate dateRegister;

	private String name;

	private BigDecimal productValue;

	private Long productAmount;

	private BigDecimal productTotal;
}
