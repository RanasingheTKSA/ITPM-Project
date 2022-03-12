package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.model.cartModel;

@Repository
public interface cartRepository extends JpaRepository<cartModel, Long>{

}
