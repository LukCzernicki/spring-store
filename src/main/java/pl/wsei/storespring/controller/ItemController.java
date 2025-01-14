package pl.wsei.storespring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsei.storespring.dto.ItemDTO;
import pl.wsei.storespring.service.ItemService;

import java.util.List;

@Tag(name = "Item", description = "Item management APIs")
@RestController
@RequestMapping("/api")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Operation(summary = "Get all items")
    @GetMapping("/items")
    public ResponseEntity<List<ItemDTO>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @Operation(summary = "Get item by ID")
    @GetMapping(("/item/{id}"))
    public ResponseEntity<ItemDTO> getItemById(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.getItemById(id));
    }

    @Operation(summary = "Create a new item")
    @PostMapping("/item")
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO itemDTO) {
        return ResponseEntity.status(201).body(ItemDTO.fromEntity(itemService.createItem(itemDTO)));
    }

    @Operation(summary = "Update an existing item")
    @PutMapping("/item/{id}")
    public ResponseEntity<ItemDTO> updateItem(@PathVariable Long id, @RequestBody ItemDTO itemDTO) {
        return ResponseEntity.ok(ItemDTO.fromEntity(itemService.updateItem(id, itemDTO)));
    }

    @Operation(summary = "Delete a item")
    @DeleteMapping("/item/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
