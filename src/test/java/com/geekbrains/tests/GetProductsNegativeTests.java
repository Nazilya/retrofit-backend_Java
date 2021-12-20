package com.geekbrains.tests;

import com.geekbrains.dto.Product;
import com.geekbrains.utils.PrettyLogger;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetProductsNegativeTests extends BaseTest {

    @DisplayName("Returns products методом DELETE")
    @Test
    void getProductsWrongMethod() throws IOException {
        Response<ArrayList<Product>> response = productService
                .getProductsWrongMethod()
                .execute();
        assertThat(response.code(), equalTo(405));
    }
}
