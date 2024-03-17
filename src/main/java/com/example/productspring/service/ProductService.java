package com.example.productspring.service;

import com.example.productspring.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    void register(ProductDTO productDTO);

    List<ProductDTO> getList(String name);
    ProductDTO getOne(long id);
    void remove(long id);
    void modify(ProductDTO todoDTO);
    Boolean findName(String name);
}
