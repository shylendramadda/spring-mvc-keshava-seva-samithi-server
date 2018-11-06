package com.rss.keshava.config;

import com.rss.keshava.viewresolver.PdfViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/upload_dir/**")
//                .addResourceLocations(new File("F:/KSS_SERVER/kss_server/upload_dir/").toURI().toString()); // Ramesh File Path
              //  .addResourceLocations(new File("D:/Projects/Web/kss_server/upload_dir/").toURI().toString()); // Raju File Path
                .addResourceLocations(new File("E:/Professional/Projects/Web/KSS/kss_server/upload_dir/").toURI().toString()); // Shylu File Path
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
                .defaultContentType(MediaType.APPLICATION_JSON)
                .favorPathExtension(true);
    }

    /*
     * Configure ContentNegotiatingViewResolver
     */
    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);

        // Define all possible view resolvers
        List<ViewResolver> resolvers = new ArrayList<>();

//        resolvers.add(csvViewResolver());
//        resolvers.add(excelViewResolver());
        resolvers.add(pdfViewResolver());

        resolver.setViewResolvers(resolvers);
        return resolver;
    }

    /*
     * Configure View resolver to provide XLS output using Apache POI library to
     * generate XLS output for an object content
     */
/*@Bean
public ViewResolver excelViewResolver() {
    return new ExcelViewResolver();
}*/

    /*
     * Configure View resolver to provide Csv output using Super Csv library to
     * generate Csv output for an object content
     */
/*@Bean
public ViewResolver csvViewResolver() {
    return new CsvViewResolver();
}*/

    /*
     * Configure View resolver to provide Pdf output using iText library to
     * generate pdf output for an object content
     */
    @Bean
    public ViewResolver pdfViewResolver() {
        return new PdfViewResolver();
    }

}