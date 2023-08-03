package com.org.ApiRest.controller;

import com.org.ApiRest.controller.DTO.ProductDTO;
import com.org.ApiRest.entities.Product;
import com.org.ApiRest.service.IproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {
     @Autowired
     private IproductService iproductService;

     @GetMapping("/find/{id}")
     public ResponseEntity<?> findById(@PathVariable Long id){
          Optional<Product> productOptional = iproductService.findById(id);

          if (productOptional.isPresent()){
               Product product = productOptional.get();
               ProductDTO productDTO = ProductDTO.builder()
                       .id(product.getId())
                       .name(product.getName())
                       .price(product.getPrice())
                       .maker(product.getMaker())
                       .build();
               return  ResponseEntity.ok(productDTO);
          }
          return ResponseEntity.notFound().build();
     }

     @GetMapping("/findAll")
     public ResponseEntity<?> findAll(){
          List<ProductDTO> productDTOList = iproductService.findAll()
                  .stream()
                  .map(product -> ProductDTO.builder()
                          .id(product.getId())
                          .name(product.getName())
                          .price(product.getPrice())
                          .maker(product.getMaker())
                          .build()
                  ).toList();
          return ResponseEntity.ok(productDTOList);
     }

     @PostMapping("/save")
     public ResponseEntity<?> save(@RequestBody ProductDTO productDTO) throws URISyntaxException {

          if (productDTO.getName().isBlank() || productDTO.getPrice() == null || productDTO.getMaker() == null){
               return ResponseEntity.badRequest().build();
          }
          Product product = Product.builder()
                  .name(productDTO.getName())
                  .price(productDTO.getPrice())
                  .maker(productDTO.getMaker())
                  .build();

          iproductService.save(product);

          return ResponseEntity.created(new URI("/api/product/save")).build();
     }
     @PutMapping("/update/{id}")
     public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductDTO productDTO){

          Optional<Product> productOptional = iproductService.findById(id);

          if (productOptional.isPresent()){
               Product product = productOptional.get();
               product.setName(productDTO.getName());
               product.setPrice(productDTO.getPrice());
               product.setMaker(productDTO.getMaker());
               iproductService.save(product);
          return ResponseEntity.ok("Registro Actualizado!");

          }
          return ResponseEntity.notFound().build();
     }

     @DeleteMapping("/delete/{id}")
     public ResponseEntity<?> deleteById(@PathVariable Long id){
          if (id != null){
               iproductService.deleteById(id);
               return ResponseEntity.ok("Resgistro Eliminado!");
          }
          return ResponseEntity.badRequest().build();
     }
}
