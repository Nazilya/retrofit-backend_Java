package com.geekbrains.tests;

import com.geekbrains.dto.Category;
import com.geekbrains.dto.Product;
import com.geekbrains.enums.CategoryType;
import com.geekbrains.utils.PrettyLogger;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateProductNegativeTests extends BaseTest {

    @BeforeEach
    void setUpWithoutCategory() throws IOException {
        product = new Product()
                .withTitle(faker.book().author())
                .withPrice((int) ((Math.random() + 1) * 100));
        //.withCategoryTitle(CategoryType.FURNITURE.getTitle());
    }

    @DisplayName("Создать продукт без указания категории")
    @Test

    void postProductWithoutCategoryNegativeTest() throws IOException {
        Response<Product> response = productService.createProduct(product).execute();
        assertThat(response.code(), equalTo(500));
    }

    @DisplayName("Создать продукт c id=0")
    @Test
    void postProductWithIdNegativeTest() throws IOException {
        Response<Product> response = productService.createProduct(product.withId(0)).execute();
        assertThat(response.code(), equalTo(400));
    }
}
