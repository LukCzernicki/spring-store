package pl.wsei.storespring.dto;
import pl.wsei.storespring.model.Item;

import java.util.List;

public class ItemDTO {

    private Long id;
    private List<ItemDTO> items;
    private String name;
    private int quantity;
    private double price;

    public static ItemDTO fromEntity(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.id = item.getId();
        itemDTO.name = item.getName();
        itemDTO.quantity = item.getQuantity();
        itemDTO.price = item.getPrice();
        return itemDTO;
    }

    public static Item toEntity(ItemDTO itemDTO) {
        Item item = new Item();
        item.setId(itemDTO.id);
        item.setName(itemDTO.name);
        item.setQuantity(itemDTO.quantity);
        item.setPrice(itemDTO.price);
        return item;
    }

    // Gettery i settery

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }
}

