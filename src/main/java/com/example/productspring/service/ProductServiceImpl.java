package com.example.productspring.service;

import com.example.productspring.domain.ProductVO;
import com.example.productspring.dto.ProductDTO;
import com.example.productspring.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductMapper productMapper;
    private final ModelMapper modelMapper;
    @Override
    public void register(ProductDTO productDTO) {
        ProductVO productVO = modelMapper.map(productDTO, ProductVO.class);
        productMapper.insert(productVO);
    }

//    @Override
//    public List<ProductDTO> getAll() {
//        List<ProductDTO> dtoList = productMapper.selectAll().stream()
//                .map(vo -> modelMapper.getMapper().map(vo, ProductDTO.class))
//                .collect(Collectors.toList());
//        return dtoList;
//    }

    @Override
    public ProductDTO getOne(long tno) {
        ProductDTO productDTO = modelMapper.map(productMapper.selectOne(tno), ProductDTO.class);
        return productDTO;
    }

    @Override
    public void remove(long tno) {
        productMapper.delete(tno);
    }

    @Override
    public void modify(ProductDTO productDTO) {
        ProductVO productVO = modelMapper.map(productDTO, ProductVO.class);
        productMapper.update(productVO);
    }

    @Override
    public List<ProductDTO> getList(String name) {
        List<ProductVO> voList = productMapper.selectList(name);
        List<ProductDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, ProductDTO.class))
                .toList();

        return dtoList;
    }
}
