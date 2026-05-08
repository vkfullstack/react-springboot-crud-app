package in.vk.main.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vk.main.entity.Product;
import in.vk.main.service.ProductService;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class ProductController {
	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@PostMapping("/savepoint")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {

	    Product savedProduct = productService.saveproduct(product);

	    return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Product>> getAllProducts() {

	    return new ResponseEntity<>(productService.getproduct(), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Product> getbyid(@PathVariable Integer id){
		return new ResponseEntity<>(productService.getproductbyid(id),HttpStatus.OK);
		
	}
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updatedetails(
	        @PathVariable Integer id,
	        @RequestBody Product product) {

	    Product productd = productService.updatproduct(id, product);

	    if (productd != null) {
	        return ResponseEntity.ok(productd);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {

	    String response = productService.deleteProduct(id);

	    return ResponseEntity.ok(response);
	}
}
