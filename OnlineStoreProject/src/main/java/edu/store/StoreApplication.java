package edu.store;

import edu.store.entity.Product;
import edu.store.entity.UserRole;
import edu.store.service.ProductService;
import edu.store.service.ProductSizeService;
import edu.store.service.ProductTypeService;
import edu.store.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);

        return resolver;
    }

    @Bean
    public CommandLineRunner addAdmin(final UserService userService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                userService.addUser("admin@gmail.com", "8cb2237d0679ca88db6464eac60da96345513964", "Admin", "123", UserRole.ADMIN); //12345
            }
        };
    }

    @Bean
    public CommandLineRunner addProductSize(final ProductSizeService productSizeService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                productSizeService.addProductSize("XS");
                productSizeService.addProductSize("S");
                productSizeService.addProductSize("M");
                productSizeService.addProductSize("L");
                productSizeService.addProductSize("XL");
                productSizeService.addProductSize("NO SIZE");
            }
        };
    }

    @Bean
    public CommandLineRunner addProductType(final ProductTypeService productTypeService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                productTypeService.addProductType("Dresses");
                productTypeService.addProductType("Overalls");
                productTypeService.addProductType("T-shirts&Tops");
                productTypeService.addProductType("Denim");
                productTypeService.addProductType("Skirts");
                productTypeService.addProductType("Pants");
                productTypeService.addProductType("Pullovers");
                productTypeService.addProductType("Sweatshirts");
                productTypeService.addProductType("Coats");
            }
        };
    }

    @Bean
    public CommandLineRunner addProduct(final ProductService productService, final ProductTypeService productTypeService, final ProductSizeService productSizeService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                List<Long> sizes = new ArrayList<>();
                sizes.add(new Long(2));
                sizes.add(new Long(3));
                sizes.add(new Long(4));
                sizes.add(new Long(5));
                sizes.add(new Long(6));
                productService.addProduct(new Product("Blue Dress", new Integer(100), "Beautiful blue dress",
                        photoToByte("static/img/products/prod1_1.jpg", "static/img/products/prod1_2.jpg", "static/img/products/prod1_3.jpg"),
                        productTypeService.findProductTypeById(new Long(8)),
                        productSizeService.findProductSizesByIds(sizes)));

                productService.addProduct(new Product("Purple Overall", new Integer(110), "Beautiful purple overall",
                        photoToByte("static/img/products/prod2_1.jpg", "static/img/products/prod2_2.jpg", "static/img/products/prod2_3.jpg"),
                        productTypeService.findProductTypeById(new Long(9)),
                        productSizeService.findProductSizesByIds(sizes)));

                productService.addProduct(new Product("Blue Top", new Integer(60), "Beautiful blue top",
                        photoToByte("static/img/products/prod3_1.jpg", "static/img/products/prod3_2.jpg", "static/img/products/prod3_3.jpg"),
                        productTypeService.findProductTypeById(new Long(10)),
                        productSizeService.findProductSizesByIds(sizes)));

                productService.addProduct(new Product("Floral Skirt", new Integer(80), "Beautiful flowers skirt",
                        photoToByte("static/img/products/prod4_1.jpg", "static/img/products/prod4_2.jpg", "static/img/products/prod4_3.jpg"),
                        productTypeService.findProductTypeById(new Long(12)),
                        productSizeService.findProductSizesByIds(sizes)));

                productService.addProduct(new Product("Blue Pants", new Integer(90), "Beautiful blue pants",
                        photoToByte("static/img/products/prod5_1.jpg", "static/img/products/prod5_2.jpg", "static/img/products/prod5_3.jpg"),
                        productTypeService.findProductTypeById(new Long(13)),
                        productSizeService.findProductSizesByIds(sizes)));

                productService.addProduct(new Product("Grey Sweatshirt", new Integer(90), "Beautiful grey sweatshirt",
                        photoToByte("static/img/products/prod6_1.jpg", "static/img/products/prod6_2.jpg", "static/img/products/prod6_3.jpg"),
                        productTypeService.findProductTypeById(new Long(14)),
                        productSizeService.findProductSizesByIds(sizes)));

                productService.addProduct(new Product("Blue coat", new Integer(90), "Beautiful blue coat",
                        photoToByte("static/img/products/prod7_1.jpg", "static/img/products/prod7_2.jpg", "static/img/products/prod7_3.jpg"),
                        productTypeService.findProductTypeById(new Long(16)),
                        productSizeService.findProductSizesByIds(sizes)));
            }
        };
    }

    private byte[][] photoToByte(String path1, String path2, String path3) throws IOException {
        byte[][] photos = new byte[3][0];

        photos[0] = StreamUtils.copyToByteArray(new ClassPathResource(path1).getInputStream());
        photos[1] = StreamUtils.copyToByteArray(new ClassPathResource(path2).getInputStream());
        photos[2] = StreamUtils.copyToByteArray(new ClassPathResource(path3).getInputStream());

        return photos;
    }
}
