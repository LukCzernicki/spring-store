package pl.wsei.storespring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsei.storespring.model.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
}
