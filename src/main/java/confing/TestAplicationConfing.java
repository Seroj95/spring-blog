package confing;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:test-blog.properties")
public class TestAplicationConfing {
}
