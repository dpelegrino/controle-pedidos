package br.com.eicon.repository;

import br.com.eicon.entity.ProductOrder;
import br.com.eicon.vo.ProductFilterVO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {

    @Query("Select s from ProductOrder s "
            + "WHERE (:#{#vo.order} IS NULL OR  s.id = :#{#vo.order}) "
            + "AND (:#{#vo.dateRegister} IS NULL OR  s.dateRegister = :#{#vo.dateRegister}) ")
    Page<ProductOrder> findByFiltro(@Param("vo") ProductFilterVO vo, Pageable page);

    Optional<ProductOrder> findByControlNumber(Long controlNumber);

}
