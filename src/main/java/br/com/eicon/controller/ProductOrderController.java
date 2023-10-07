package br.com.eicon.controller;

import javax.validation.Valid;

import br.com.eicon.dto.ProductOrderDTO;
import br.com.eicon.response.ProductOrderResponse;
import br.com.eicon.vo.ProductFilterVO;
import br.com.eicon.vo.ProductOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.eicon.service.ProductOrderService;

import java.util.List;

@RestController
@RequestMapping("/product-orders")
public class ProductOrderController {

    @Autowired
    private ProductOrderService productOrderService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductOrderResponse> createOrder(@RequestBody @Valid List<ProductOrderVO> vo) {
        try {
            return new ResponseEntity<>(productOrderService.createProductOrder(vo), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/filter")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> filtro(@RequestBody ProductFilterVO vo,
                                         @RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size) {
        try {
            Page<ProductOrderDTO> result = productOrderService.findByFilter(vo, page, size);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
