package com.pCarpet.converter;

import java.util.ArrayList;
import java.util.List;

import com.pCarpet.dto.ItemDTO;
import com.pCarpet.model.Item;

public class ItemConverter {
	
	public static ItemDTO convertToDto(Item item) {
		ItemDTO itemDTO = null;
		if(item != null) {
			itemDTO = new ItemDTO();
			itemDTO.setId(item.getId());
			itemDTO.setName(item.getName());
			itemDTO.setIdFather(item.getFather().getId());
			itemDTO.setItemChildrenDTO(ItemConverter.toListDTO(item.getChildsList()));
		}
		return itemDTO;
	}
	
	public static Item convertToEntity(ItemDTO itemDTO) {
		Item item = null;
		if(itemDTO != null) {
			item = new Item();
			item.setId(itemDTO.getId());
			item.setName(itemDTO.getName());
			Item father = new Item();
			father.setId(itemDTO.getIdFather());
			item.setFather(father);
		}
		return item;
	}
	
	public static List<ItemDTO> toListDTO(List<Item> list){
		List<ItemDTO> listItemDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for(Item item : list) {
				listItemDTO.add(ItemConverter.convertToDto(item));
			}
		}
		return listItemDTO;
	}
	
	public static List<Item> toListEntity(List<ItemDTO> list){
		List<Item> listItem = new ArrayList<>();
		if (!list.isEmpty()) {
			for(ItemDTO itemDTO : list) {
				listItem.add(ItemConverter.convertToEntity(itemDTO));
			}
		}
		return listItem;
	}
}
