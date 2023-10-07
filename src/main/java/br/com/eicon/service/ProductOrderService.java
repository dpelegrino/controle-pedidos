package br.com.eicon.service;

import javax.transaction.Transactional;

import br.com.eicon.constant.MessageConstants;
import br.com.eicon.dto.ProductOrderDTO;
import br.com.eicon.entity.Client;
import br.com.eicon.entity.ProductOrder;
import br.com.eicon.exception.RecordException;
import br.com.eicon.repository.ProductOrderRepository;
import br.com.eicon.response.ProductOrderResponse;
import br.com.eicon.vo.ProductFilterVO;
import br.com.eicon.vo.ProductOrderVO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductOrderService {

    private final ProductOrderRepository productOrderRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public ProductOrderResponse createProductOrder(List<ProductOrderVO> vo) {
        ProductOrderResponse response = new ProductOrderResponse();

        if (vo.size() > 10) {
            throw new RecordException(MessageConstants.MORE_PRODUCTS_LIST);
        }

        vo.forEach(pr -> {
            Optional<ProductOrder> po = productOrderRepository.findByControlNumber(pr.getControlNumber());

            if (po.isPresent()) {
                throw new RecordException(MessageConstants.ALREADY_EXISTS);
            }

            ProductOrder productOrder = modelMapper.map(pr, ProductOrder.class);

            productOrder.setClient(new Client(pr.getClientCode()));

            if (productOrder.getDateRegister() == null) {
                productOrder.setDateRegister(LocalDate.now());
            }

            this.calcDiscount(productOrder);

            productOrderRepository.save(productOrder);

            response.getOrder().add(modelMapper.map(productOrder, ProductOrderDTO.class));
        });

        return response;
    }

    public Page<ProductOrderDTO> findByFilter(ProductFilterVO vo, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page,
                size,
                Sort.Direction.fromString("ASC"),
                "name");
        return productOrderRepository.findByFiltro(vo, pageRequest)
                .map(post -> modelMapper.map(post, ProductOrderDTO.class));
    }

    private ProductOrder calcDiscount(ProductOrder productOrder) {
        BigDecimal value = null;

        if (productOrder.getProductAmount() == null) {
            productOrder.setProductAmount(1L);
            productOrder.setProductTotal(productOrder.getProductValue());
        } else if (productOrder.getProductAmount() >= 5 && productOrder.getProductAmount() <= 9) {
            value = new BigDecimal(productOrder.getProductAmount()).multiply(productOrder.getProductValue());
            productOrder.setProductTotal(value.subtract(value.multiply(new BigDecimal(0.05))));
        } else if (productOrder.getProductAmount() >= 10) {
            value = new BigDecimal(productOrder.getProductAmount()).multiply(productOrder.getProductValue());
            productOrder.setProductTotal(value.subtract(value.multiply(new BigDecimal(0.10))));
        } else {
            productOrder.setProductTotal(new BigDecimal(productOrder.getProductAmount()).multiply(productOrder.getProductValue()));
        }

        return productOrder;
    }
}
