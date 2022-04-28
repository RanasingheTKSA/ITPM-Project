package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.model.AddItem;


@Repository
public interface AddItemRepository  extends JpaRepository<AddItem,Long>{

}
