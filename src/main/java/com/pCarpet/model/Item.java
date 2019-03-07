package com.pCarpet.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="items")

public class Item {
	
	@Id
	@Column(name = "id_item")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	@NotNull
	private String name;
	
	@ManyToOne
	@JoinColumn(name="id_wbs")
	private WBS wbs;
	
	@Column(name = "level")
	@NotNull
	private Integer level;
	
	@OneToMany(mappedBy="output")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<Manufacturing> manufacturings;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="id_father")
	private Item father;
	
	@OneToMany(mappedBy="father")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<Item> childsList=new ArrayList<>();
	
}
