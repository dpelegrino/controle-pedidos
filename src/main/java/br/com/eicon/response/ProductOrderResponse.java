package br.com.eicon.response;

import br.com.eicon.dto.ProductOrderDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductOrderResponse {
	private List<ProductOrderDTO> order = new ArrayList<>();
}
