package lk.ijse.web.web_pos_backend.config;


import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "lk.ijse.web.web_pos_backend")
@EnableWebMvc
@EnableJpaRepositories(basePackages = "lk.ijse.web.web_pos_backend")
@EnableTransactionManagement
//multipart home data access
@MultipartConfig (
        fileSizeThreshold = 1024  * 1024 * 2, //2MB
        maxFileSize = 1024  * 1024 * 10,  //10MB
        maxRequestSize = 1024 * 1024 * 50 //50MB
)
public class WebAppConfig {
}
