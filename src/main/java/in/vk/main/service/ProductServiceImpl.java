package in.vk.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.vk.main.entity.Product;
import in.vk.main.repository.ProductRepository;
@Service
public class ProductServiceImpl  implements ProductService{
	private ProductRepository productRepository;
	

	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}


	@Override
	public Product saveproduct(Product product) {
		
		return productRepository.save(product);
	}


	@Override
	public List<Product> getproduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	
	@Override
	public Product getproductbyid(Integer id) {
		
		return productRepository.getById(id);
	}


	@Override
	public String deleteProduct(Integer id) {

	    Product product = productRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

	    productRepository.delete(product);

	    return "Product deleted successfully";
	}


	@Override
	public Product updatproduct(Integer id, Product product) {
		 Product newproduct= productRepository.findById(id).orElse(null);
		 if(newproduct !=null){
			return  productRepository.save(newproduct);
			 
		 }
			 throw new RuntimeException("not found id :"+id);
	}


	






	
}
