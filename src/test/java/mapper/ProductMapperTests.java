package mapper;

import com.example.productspring.domain.ProductVO;
import com.example.productspring.mapper.ProductMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class ProductMapperTests {
    @Autowired(required = false)
    ProductMapper productMapper;

    @Test
    public void selectListTest(){
        String name = "약과";
        List<ProductVO> voList = productMapper.selectList(name);
        System.out.println(voList);
    }
}