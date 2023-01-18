package com.enes.northwindProject.business.abstacts;

import java.util.List;


import com.enes.northwindProject.core.utilities.results.DataResult;
import com.enes.northwindProject.core.utilities.results.Result;
import com.enes.northwindProject.entities.concrete.Product;
import com.enes.northwindProject.entities.dtos.ProductWithCategoryDto;

public interface ProductService {

	
	DataResult<List<Product>> getAll();
	
	DataResult<List<Product>> getAllSorted();
	
	DataResult<List<Product>> getAll(int pageNo,int pageSize);
	
	Result Add(Product product);
	
    DataResult<Product> getByProductName(String productName);
	
    DataResult<Product> getByProductNameAndCategoryId(String productName,int categoryId);
	
    DataResult<List<Product>> getByProductNameOrCategoryId(String productName,int categoryId);
	
    DataResult<List<Product>>getByCategory_CategoryIdIn(List<Integer> categories);
	
    DataResult<List<Product>> getByProductNameContains(String productName);
	
    DataResult<List<Product>> getByProductNameStartingWith(String productName);
	
    DataResult<List<Product>> getByNameAndCategory(String productName,int categoryId);
    
    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}
