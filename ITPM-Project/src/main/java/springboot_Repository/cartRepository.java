package springboot_Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot_Model.cartModel;

@Repository
public interface cartRepository extends JpaRepository<cartModel, Long>{
	
}
