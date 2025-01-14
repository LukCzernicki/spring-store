package pl.wsei.storespring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsei.storespring.dto.ItemDTO;
import pl.wsei.storespring.exception.ResourceNotFoundException;
import pl.wsei.storespring.model.Item;
import pl.wsei.storespring.repository.ItemRepository;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item createItem(ItemDTO itemDTO) {
        return itemRepository.save(ItemDTO.toEntity(itemDTO));
    }

    public List<ItemDTO> getAllItems() {
        return itemRepository.findAll().stream().map(ItemDTO::fromEntity).toList();
    }

    public ItemDTO getItemById(Long id) {
        return ItemDTO.fromEntity(itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found")));
    }

    public Item updateItem(Long id, ItemDTO itemDTO) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found"));
        item.setName(itemDTO.getName());
        item.setQuantity(itemDTO.getQuantity());
        return itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found"));
        itemRepository.delete(item);
    }
}

