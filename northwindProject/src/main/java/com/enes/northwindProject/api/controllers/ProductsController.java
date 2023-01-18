package com.enes.northwindProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enes.northwindProject.business.abstacts.ProductService;
import com.enes.northwindProject.core.utilities.results.DataResult;
import com.enes.northwindProject.core.utilities.results.Result;
import com.enes.northwindProject.entities.concrete.Product;
import com.enes.northwindProject.entities.dtos.ProductWithCategoryDto;


@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	
	@GetMapping("/getAll")
	public DataResult<List<Product>> getAll(){
		
		return this.productService.getAll();
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
			
		 return this.productService.Add(product);
	}
	
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String ProductName){
		
		return this.productService.getByProductName(ProductName);
		
	}
	
	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam int categoryId,@RequestParam String productName){
		
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
		
	}
		
	@GetMapping("/getByProductNameOrCategoryId")
	public DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam String productName, @RequestParam int categoryId){
		return this.productService.getByProductNameOrCategoryId(productName, categoryId);
		
	}

	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		
		return this.productService.getByProductNameContains(productName);
				
	}
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAllByPage(int pageNo,int pageSize){
		
		return this.productService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllSorted")
	public DataResult<List<Product>> getAllSorted(){
		return this.productService.getAllSorted();	
		
		
	}
	
	@GetMapping("/getByCategoryIdIn")
	public DataResult<List<Product>> getByProductNameIn(@RequestParam List<Integer> categories){
		
		return this.productService.getByCategory_CategoryIdIn(categories);
	}
	
	@GetMapping("/getProductWithCategoryDetails")
	
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();	
		
		
	}
	
}
