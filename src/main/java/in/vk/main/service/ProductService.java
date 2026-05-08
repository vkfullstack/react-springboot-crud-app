package in.vk.main.service;

import java.util.List;
import in.vk.main.entity.Product;


public interface ProductService {
	public Product saveproduct(Product product);
	public List<Product> getproduct();
	public Product getproductbyid(Integer id);
	 public String deleteProduct(Integer id);
	 public Product updatproduct(Integer id ,Product product);

}
