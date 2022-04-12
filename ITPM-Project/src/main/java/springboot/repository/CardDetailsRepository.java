package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.model.CardDetails;

public interface CardDetailsRepository extends JpaRepository<CardDetails, Long> {

}
