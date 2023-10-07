package br.com.eicon.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "product_order")
public class ProductOrder {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "control_number")
	private Long controlNumber;

	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client client;

	@Column(name = "date_register")
	private LocalDate dateRegister;

	@Column(name = "name")
	private String name;

	@Column(name = "product_value")
	private BigDecimal productValue;

	@Column(name = "product_amount")
	private Long productAmount;

	@Column(name = "product_total")
	private BigDecimal productTotal;
	
}
