package com.enes.northwindProject.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.enes.northwindProject.business.abstacts.ProductService;
import com.enes.northwindProject.core.utilities.results.DataResult;
import com.enes.northwindProject.core.utilities.results.Result;
import com.enes.northwindProject.core.utilities.results.SuccessDataResult;
import com.enes.northwindProject.core.utilities.results.SuccessResult;
import com.enes.northwindProject.dataAccess.abstracts.ProductDao;
import com.enes.northwindProject.entities.concrete.Product;
import com.enes.northwindProject.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService {

	private ProductDao productDao;

	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {

		return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "Ürün Listelendi");

	}

	@Override
	public Result Add(Product product) {

		this.productDao.save(product);
		return new SuccessResult("Ürün eklendi");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName),"DAta Listelendi");

	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {

		return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId),"DAta Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName,int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId),"DAta Listelendi");

	}



//	@Override
//	public DataResult<List<Product>> getByProductNameContains(String productName) {
//		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName));
//	}

	
	 

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName, categoryId),"DAta Listelendi");

	}

	@Override
	public DataResult<List<Product>> getByProductNameStartingWith(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartingWith(productName),"DAta Listelendi");

	}

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
       
		  Pageable pageable=PageRequest.of(pageNo-1, pageSize);

		return  new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort =Sort.by(Sort.Direction.DESC,"productName");
		return  new SuccessDataResult<List<Product>>(this.productDao.findAll(sort));
	}

	@Override
	public DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categories) {
		
		return new SuccessDataResult<List<Product>>(this.productDao.getByCategory_CategoryIdIn(categories),"DAta Listelendi");

	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName),"DAta Listelendi");

	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		
		return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(),"Ürün Listelendi");

		
	}

	

}
