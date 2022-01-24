package com.sacha.dojoOverflow.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import com.sun.istack.NotNull;

@Entity
@Table(name="products")

public class Questions {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	@NotNull
    private Long id;
	
	@Size(min = 2, max = 20, message="Product name should be between 2-20")
	private String productName;

	@Size(min = 2, max = 200, message="Product description should be between 2-200")
	private String productDesc;
	
	@NotNull
    @Min((long) 0.01)
	private BigDecimal productPrice;
	
	 @ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(
		        name = "categories_products", 
		        joinColumns = @JoinColumn(name = "product_id"), 
		        inverseJoinColumns = @JoinColumn(name = "category_id")
		    )
    private List<Answers> answers;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public List<Answers> getCategories() {
		return answers;
	}
	public void setCategories(List<Answers> answers) {
		this.answers = answers;
	}
}
