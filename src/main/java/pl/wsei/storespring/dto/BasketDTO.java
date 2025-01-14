package pl.wsei.storespring.dto;

import pl.wsei.storespring.model.Basket;

import java.util.List;

public class BasketDTO {
	
	long id;
	private List<ItemDTO> items;

//	String item;

//	public static BasketDTO fromEntity(Basket basket) {
//		BasketDTO basketDTO = new BasketDTO();
//		basketDTO.id = basket.getId();
//		basketDTO.item = basket.getItem();
//		return basketDTO;
//	}

//	public static Basket toEntity(BasketDTO basketDTO) {
//		Basket basket = new Basket();
//		basket.setId(basketDTO.id);
//		basket.setItem(basketDTO.item);
//		return basket;
//	}

	public static BasketDTO fromEntity(Basket basket) {
		BasketDTO basketDTO = new BasketDTO();
		basketDTO.id = basket.getId();
		basketDTO.items = basket.getItems().stream().map(ItemDTO::fromEntity).toList();
		return basketDTO;
	}

	public static Basket toEntity(BasketDTO basketDTO) {
		Basket basket = new Basket();
		basket.setId(basketDTO.getId());
		basket.setItems(basketDTO.getItems().stream().map(ItemDTO::toEntity).toList());
		return basket;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<ItemDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}

//	public String getItem() {
//		return item;
//	}
//
//	public void setItem(String item) {
//		this.item = item;
//	}
}
