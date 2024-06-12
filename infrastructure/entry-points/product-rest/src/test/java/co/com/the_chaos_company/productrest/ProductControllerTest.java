package co.com.the_chaos_company.productrest;

import co.com.the_chaos_company.model.product.Product;
import co.com.the_chaos_company.usecase.product.ProductUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ContextConfiguration(classes = ProductController.class)
@AutoConfigureMockMvc(addFilters = false)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductUseCase productUseCase;

    private ProductController productController;

    @BeforeEach
    void setUp() {
        productController = new ProductController(productUseCase);
    }

    @Test
    void findByName() throws Exception {
        when(productUseCase.findByName("Product1")).thenReturn(new Product("Product1", 100.0));

        MvcResult mvcResult = mockMvc.perform(get("/product/Product1"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        assertEquals("{\"name\":\"Product1\",\"price\":100.0,\"valid\":true}", content);
    }
}