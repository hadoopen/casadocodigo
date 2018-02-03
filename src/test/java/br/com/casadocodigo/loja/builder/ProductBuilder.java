package br.com.casadocodigo.loja.builder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.casadocodigo.loja.models.BookType;
import br.com.casadocodigo.loja.models.Product;

public class ProductBuilder {

	private List<Product> products = new ArrayList<Product>();
	
	private ProductBuilder(Product product) {
		products.add(product);
	}
	
	
	public static ProductBuilder newProduct(BookType bookType,
			BigDecimal value){
		Product book = create("Book 1",bookType,value);
		return new ProductBuilder(book);
	}
	

	public static ProductBuilder newProduct(){
		Product book = create("Book 1",BookType.COMBO,BigDecimal.TEN);
		return new ProductBuilder(book);
	}
	
	public static Product create(String bookName,BookType bookType, BigDecimal value){
		
	}
  

}
