package pl.wsei.storespring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsei.storespring.dto.BasketDTO;
import pl.wsei.storespring.dto.ItemDTO;
import pl.wsei.storespring.dto.PromotionDTO;
import pl.wsei.storespring.exception.ResourceNotFoundException;
import pl.wsei.storespring.model.Basket;
import pl.wsei.storespring.model.Promotion;
import pl.wsei.storespring.repository.BasketRepository;
import pl.wsei.storespring.repository.PromotionRepository;

import java.util.List;

@Service
public class BasketService {

	private BasketRepository basketRepository;
	private PromotionRepository promotionRepository;

//	@Autowired
//	public BasketService(BasketRepository basketRepository) {
//		this.basketRepository = basketRepository;
//	}

	@Autowired
	public BasketService(BasketRepository basketRepository, PromotionRepository promotionRepository) {
		this.basketRepository = basketRepository;
		this.promotionRepository = promotionRepository;
	}

	public Basket createBasket(BasketDTO basketDto) {
		Basket basket = BasketDTO.toEntity(basketDto);
		return basketRepository.save(basket);
	}



	public BasketDTO getBasketById(Long id) {
		return BasketDTO.fromEntity(basketRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Basket not found")));
	}

	public List<BasketDTO> getAllBaskets() {
		return basketRepository.findAll().stream().map(BasketDTO::fromEntity).toList();
	}

//		public Basket updateBasket(Long id, BasketDTO basketDetails) {
//			Basket basket = basketRepository.findById(id)
//					.orElseThrow(() -> new ResourceNotFoundException("Basket not found"));
//			basket.setItem(basketDetails.getItem());
//			return basketRepository.save(basket);
//		}
	public Basket updateBasket(Long id, BasketDTO basketDetails) {
	Basket basket = basketRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Basket not found"));
	basket.setItems(basketDetails.getItems().stream().map(ItemDTO::toEntity).toList());
	return basketRepository.save(basket);
}

	public void deleteBasket(Long id) {
		Basket basket = basketRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Basket not found"));
		basketRepository.delete(basket);
	}

	public double calculateBasketValue(Long basketId) {
		Basket basket = basketRepository.findById(basketId)
				.orElseThrow(() -> new ResourceNotFoundException("Basket not found"));
		return basket.getItems().stream()
				.mapToDouble(item -> item.getPrice() * item.getQuantity())
				.sum();
	}

	public void setPromotion(Long basketId, PromotionDTO promotionDTO) {
		Basket basket = basketRepository.findById(basketId)
				.orElseThrow(() -> new ResourceNotFoundException("Basket not found"));

		Promotion promotion = promotionRepository.findById(promotionDTO.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Promotion not found"));

		basket.setPromotion(promotion);
		basketRepository.save(basket);
	}
}