package pl.wsei.storespring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import pl.wsei.storespring.dto.BasketDTO;
import pl.wsei.storespring.dto.PromotionDTO;
import pl.wsei.storespring.model.Basket;
import pl.wsei.storespring.service.BasketService;

import java.util.List;

@Tag(name = "Basket", description = "Basket management APIs")
@RestController
@RequestMapping("/api")
public class BasketController {

	private final BasketService basketService;

	@Autowired
	public BasketController(BasketService basketService) {
		this.basketService = basketService;
	}

	@Operation(summary = "Get all baskets")
	@GetMapping("/baskets")
	public ResponseEntity<List<BasketDTO>> getAllBaskets() {
		List<BasketDTO> baskets = basketService.getAllBaskets();
		return ResponseEntity.ok(baskets);
	}

	@Operation(summary = "Get basket by ID")
	@GetMapping("/basket/{id}")
	public ResponseEntity<BasketDTO> getBasketById(@PathVariable Long id) {
		BasketDTO basket = basketService.getBasketById(id);
		return ResponseEntity.ok(basket);
	}

	@Operation(summary = "Create a new basket")
	@PostMapping("/basket")
	public ResponseEntity<Basket> createBasket(@RequestBody BasketDTO basket) {
		Basket createdBasket = basketService.createBasket(basket);
		return ResponseEntity.status(201).body(createdBasket);
	}

	@Operation(summary = "Update an existing basket")
	@PutMapping("/basket/{id}")
	public ResponseEntity<Basket> updateBasket(@PathVariable Long id, @RequestBody BasketDTO basket) {
		Basket updatedBasket = basketService.updateBasket(id, basket);
		return ResponseEntity.ok(updatedBasket);
	}

	@Operation(summary = "Delete a basket")
	@DeleteMapping("/basket/{id}")
	public ResponseEntity<Void> deleteBasket(@PathVariable Long id) {
		basketService.deleteBasket(id);
		return ResponseEntity.noContent().build();
	}

	@Operation(summary = "Get total basket value")
	@GetMapping("/basket/{id}/total-value")
	public ResponseEntity<Double> getBasketTotalValue(@PathVariable Long id) {
		double totalValue = basketService.calculateBasketValue(id);
		return ResponseEntity.ok(totalValue);
	}

	@Operation(summary = "Set promotion for basket")
	@PostMapping("/basket/{id}/promotion")
	public ResponseEntity<Void> setBasketPromotion(@PathVariable Long id, @RequestBody PromotionDTO promotionDTO) {
		basketService.setPromotion(id, promotionDTO);
		return ResponseEntity.noContent().build();
	}
}