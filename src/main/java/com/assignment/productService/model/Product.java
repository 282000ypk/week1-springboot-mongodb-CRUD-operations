package com.assignment.productService.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document (collection = "ProductDB")
public class Product {

	@Id
	private long id;

	@Indexed(unique=true)
	private String name;
	private String description;
}
