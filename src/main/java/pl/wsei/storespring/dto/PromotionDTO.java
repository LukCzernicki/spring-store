package pl.wsei.storespring.dto;

import pl.wsei.storespring.model.Promotion;

public class PromotionDTO {

    private Long id;
    private double discountPercentage;

    // Gettery i settery
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    // Konwersje między Promotion a PromotionDTO
    public static PromotionDTO fromEntity(Promotion promotion) {
        PromotionDTO promotionDTO = new PromotionDTO();
        promotionDTO.id = promotion.getId();
        promotionDTO.discountPercentage = promotion.getDiscountPercentage();
        return promotionDTO;
    }

    public static Promotion toEntity(PromotionDTO promotionDTO) {
        Promotion promotion = new Promotion();
        promotion.setId(promotionDTO.id);
        promotion.setDiscountPercentage(promotionDTO.discountPercentage);
        return promotion;
    }
}


