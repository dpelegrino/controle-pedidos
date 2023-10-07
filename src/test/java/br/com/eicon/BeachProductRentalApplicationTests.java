package br.com.eicon;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import br.com.eicon.constant.MessageConstants;

import br.com.eicon.exception.RecordException;
import br.com.eicon.repository.ProductOrderRepository;
import br.com.eicon.response.ProductOrderResponse;
import br.com.eicon.service.ProductOrderService;
import br.com.eicon.vo.ProductOrderVO;
import lombok.RequiredArgsConstructor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class BeachProductRentalApplicationTests {

    private final ProductOrderService productOrderService;

    private final ProductOrderRepository repository;

    @Test
    void testCreate() {

        List<ProductOrderVO> listProducts = new ArrayList<>();
        // given
        ProductOrderVO productOrderDTO = new ProductOrderVO();
        productOrderDTO.setControlNumber(12345678l);
        productOrderDTO.setDateRegister(LocalDate.now());
        productOrderDTO.setName("Arroz");
        productOrderDTO.setProductValue(new BigDecimal(10));
        productOrderDTO.setProductAmount(2l);
        productOrderDTO.setClientCode(1l);

        listProducts.add(productOrderDTO);

        // when
        ProductOrderResponse found = productOrderService.createProductOrder(listProducts);

        // then
        assertThat(found.getOrder().get(0).getName()).isEqualTo("Arroz");
    }

    @Test
    void testCreateBetweenFiveAndNine() {

        List<ProductOrderVO> listProducts = new ArrayList<>();
        // given
        ProductOrderVO productOrderDTO = new ProductOrderVO();
        productOrderDTO.setControlNumber(87654321l);
        productOrderDTO.setDateRegister(LocalDate.now());
        productOrderDTO.setName("Batata");
        productOrderDTO.setProductValue(new BigDecimal(8));
        productOrderDTO.setProductAmount(5l);
        productOrderDTO.setClientCode(2l);

        listProducts.add(productOrderDTO);

        // when
        ProductOrderResponse found = productOrderService.createProductOrder(listProducts);

        BigDecimal result = found.getOrder().get(0).getProductTotal().setScale
                (2, RoundingMode.HALF_EVEN);

        // then
        assertThat(result.toString()).isEqualTo("38.00");
    }

    @Test
    void testCreateUpTen() {

        List<ProductOrderVO> listProducts = new ArrayList<>();
        // given
        ProductOrderVO productOrderDTO = new ProductOrderVO();
        productOrderDTO.setControlNumber(4599876325l);
        productOrderDTO.setDateRegister(LocalDate.now());
        productOrderDTO.setName("Cafe");
        productOrderDTO.setProductValue(new BigDecimal(20));
        productOrderDTO.setProductAmount(11l);
        productOrderDTO.setClientCode(3l);

        listProducts.add(productOrderDTO);

        // when
        ProductOrderResponse found = productOrderService.createProductOrder(listProducts);

        BigDecimal result = found.getOrder().get(0).getProductTotal().setScale
                (2, RoundingMode.HALF_EVEN);
        // then
        assertThat(result.toString()).isEqualTo(("198.00"));
    }

    @Test()
    void testCreateErrorMoreTenOrders() {

        List<ProductOrderVO> listProducts = new ArrayList<>();
        // given
        ProductOrderVO productOrderDTO = new ProductOrderVO();
        productOrderDTO.setControlNumber(4599876325l);
        productOrderDTO.setDateRegister(LocalDate.now());
        productOrderDTO.setName("Cafe");
        productOrderDTO.setProductValue(new BigDecimal(20));
        productOrderDTO.setProductAmount(11l);
        productOrderDTO.setClientCode(3l);

        listProducts.add(productOrderDTO);

        productOrderDTO = new ProductOrderVO();
        productOrderDTO.setControlNumber(4599876325l);
        productOrderDTO.setDateRegister(LocalDate.now());
        productOrderDTO.setName("Cafe");
        productOrderDTO.setProductValue(new BigDecimal(20));
        productOrderDTO.setProductAmount(11l);
        productOrderDTO.setClientCode(3l);

        listProducts.add(productOrderDTO);

        productOrderDTO = new ProductOrderVO();
        productOrderDTO.setControlNumber(4599876325l);
        productOrderDTO.setDateRegister(LocalDate.now());
        productOrderDTO.setName("Cafe");
        productOrderDTO.setProductValue(new BigDecimal(20));
        productOrderDTO.setProductAmount(11l);
        productOrderDTO.setClientCode(3l);

        listProducts.add(productOrderDTO);

        productOrderDTO = new ProductOrderVO();
        productOrderDTO.setControlNumber(4599876325l);
        productOrderDTO.setDateRegister(LocalDate.now());
        productOrderDTO.setName("Cafe");
        productOrderDTO.setProductValue(new BigDecimal(20));
        productOrderDTO.setProductAmount(11l);
        productOrderDTO.setClientCode(3l);

        listProducts.add(productOrderDTO);

        productOrderDTO = new ProductOrderVO();
        productOrderDTO.setControlNumber(4599876325l);
        productOrderDTO.setDateRegister(LocalDate.now());
        productOrderDTO.setName("Cafe");
        productOrderDTO.setProductValue(new BigDecimal(20));
        productOrderDTO.setProductAmount(11l);
        productOrderDTO.setClientCode(3l);

        listProducts.add(productOrderDTO);

        productOrderDTO = new ProductOrderVO();
        productOrderDTO.setControlNumber(4599876325l);
        productOrderDTO.setDateRegister(LocalDate.now());
        productOrderDTO.setName("Cafe");
        productOrderDTO.setProductValue(new BigDecimal(20));
        productOrderDTO.setProductAmount(11l);
        productOrderDTO.setClientCode(3l);

        listProducts.add(productOrderDTO);

        productOrderDTO = new ProductOrderVO();
        productOrderDTO.setControlNumber(4599876325l);
        productOrderDTO.setDateRegister(LocalDate.now());
        productOrderDTO.setName("Cafe");
        productOrderDTO.setProductValue(new BigDecimal(20));
        productOrderDTO.setProductAmount(11l);
        productOrderDTO.setClientCode(3l);

        listProducts.add(productOrderDTO);

        productOrderDTO = new ProductOrderVO();
        productOrderDTO.setControlNumber(4599876325l);
        productOrderDTO.setDateRegister(LocalDate.now());
        productOrderDTO.setName("Cafe");
        productOrderDTO.setProductValue(new BigDecimal(20));
        productOrderDTO.setProductAmount(11l);
        productOrderDTO.setClientCode(3l);

        listProducts.add(productOrderDTO);

        productOrderDTO = new ProductOrderVO();
        productOrderDTO.setControlNumber(4599876325l);
        productOrderDTO.setDateRegister(LocalDate.now());
        productOrderDTO.setName("Cafe");
        productOrderDTO.setProductValue(new BigDecimal(20));
        productOrderDTO.setProductAmount(11l);
        productOrderDTO.setClientCode(3l);

        listProducts.add(productOrderDTO);

        productOrderDTO = new ProductOrderVO();
        productOrderDTO.setControlNumber(4599876325l);
        productOrderDTO.setDateRegister(LocalDate.now());
        productOrderDTO.setName("Cafe");
        productOrderDTO.setProductValue(new BigDecimal(20));
        productOrderDTO.setProductAmount(11l);
        productOrderDTO.setClientCode(3l);

        listProducts.add(productOrderDTO);

        productOrderDTO = new ProductOrderVO();
        productOrderDTO.setControlNumber(4599876325l);
        productOrderDTO.setDateRegister(LocalDate.now());
        productOrderDTO.setName("Cafe");
        productOrderDTO.setProductValue(new BigDecimal(20));
        productOrderDTO.setProductAmount(11l);
        productOrderDTO.setClientCode(3l);

        listProducts.add(productOrderDTO);

        productOrderDTO = new ProductOrderVO();
        productOrderDTO.setControlNumber(4599876325l);
        productOrderDTO.setDateRegister(LocalDate.now());
        productOrderDTO.setName("Cafe");
        productOrderDTO.setProductValue(new BigDecimal(20));
        productOrderDTO.setProductAmount(11l);
        productOrderDTO.setClientCode(3l);

        listProducts.add(productOrderDTO);

        Exception exception =  assertThrows(RecordException.class, () -> {
            productOrderService.createProductOrder(listProducts);
        });

        String expectedMessage = MessageConstants.MORE_PRODUCTS_LIST;
        String actualMessage = exception.getMessage();

        assertThat(actualMessage).isEqualTo((expectedMessage));
    }

    @Test
    void testCreateErrorNumControlerRegistered() {

        List<ProductOrderVO> listProducts = new ArrayList<>();
        // given
        ProductOrderVO productOrderDTO = new ProductOrderVO();
        productOrderDTO.setControlNumber(87654321l);
        productOrderDTO.setDateRegister(LocalDate.now());
        productOrderDTO.setName("Arroz");
        productOrderDTO.setProductValue(new BigDecimal(10));
        productOrderDTO.setProductAmount(2l);
        productOrderDTO.setClientCode(1l);

        listProducts.add(productOrderDTO);

        // when
        Exception exception =  assertThrows(RecordException.class, () -> {
            productOrderService.createProductOrder(listProducts);
        });

        String expectedMessage = MessageConstants.ALREADY_EXISTS;
        String actualMessage = exception.getMessage();

        assertThat(actualMessage).isEqualTo((expectedMessage));

        repository.deleteAll();
    }
}
