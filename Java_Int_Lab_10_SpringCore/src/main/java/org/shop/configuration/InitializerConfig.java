package org.shop.configuration;

import org.shop.*;
import org.shop.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class InitializerConfig {

    @Autowired
    private ProductService productService;

    @Bean
    public DataInitializer dataInitializer() {
        return new DataInitializer();
    }

    //ProductInitializer: передать параметры в конструктор
    @Bean
    public ProductInitializer productInitializer() {
        return new ProductInitializer(productService);
    }

    //ProposalInitializer: использовать autowiring by name
    @Bean
    public ProposalInitializer proposalInitializer() {
        return new ProposalInitializer();
    }

    // SellerInitializer: требуется параметр типа Map<sellerId, sellerName>
    @Bean
    public SellerInitializer sellerInitializer() {
        SellerInitializer sellerInitializer = new SellerInitializer();
        Map<Long, String> sellerNames = new HashMap<>();
        sellerNames.put(1L, "Sumsung");
        sellerNames.put(2L, "Amazon");
        sellerInitializer.setSellerNames(sellerNames);
        return sellerInitializer;
    }

    @Bean
    public UserInitializer userInitializer() {
        return new UserInitializer();
    }
}
