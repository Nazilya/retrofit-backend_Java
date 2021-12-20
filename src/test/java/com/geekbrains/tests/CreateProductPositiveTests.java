package com.geekbrains.tests;

import com.geekbrains.utils.PrettyLogger;
import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.*;
import retrofit2.Response;
import com.geekbrains.dto.Product;


import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CreateProductPositiveTests extends BaseTest {
    static Integer id;

    @DisplayName("Create a new product")
    @Test
    void postProductTest() throws IOException {
        Response<Product> response = productService.createProduct(product).execute();
        PrettyLogger.DEFAULT.log(response.body().toString());
        id =  response.body().getId();
        assertThat(response.body().getTitle(), equalTo(product.getTitle()));
        assertThat(response.body().getPrice(), equalTo(product.getPrice()));
        assertThat(response.body().getCategoryTitle(), equalTo(product.getCategoryTitle()));
        assertThat(response.code(), equalTo(201));
    }

    @AfterEach
    void tearDown() throws IOException {
        Response<ResponseBody> response = productService.deleteProduct(id).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }

}
