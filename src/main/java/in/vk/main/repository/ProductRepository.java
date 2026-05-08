package in.vk.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vk.main.entity.Product;

public interface ProductRepository  extends JpaRepository<Product, Integer>{

}
