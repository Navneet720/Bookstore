package com.example.bookstore.dto;

import java.util.List;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OrderDTO {
    private int orderId;
    private String orderDate;
    private List<ProductDTO> products;

//    public List<ProductDTO> getProductIds() {
//        ProductDTO productDTO = new ProductDTO();
//        productDTO.setProductId(products.get(0).getProductId());
//        return products;
//    }
}
