package com.example.productspring.mapper;

import com.example.productspring.domain.ProductVO;

import java.util.List;

public interface ProductMapper {
    String getTime();
    void insert(ProductVO todoVO);

    List<ProductVO> selectList(String name);
    ProductVO selectOne(long id);
    void delete(long id);
    void update(ProductVO productVO);
    int getCount();
}
