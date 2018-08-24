package confing;


import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@Profile({"dev","default"})
@ComponentScan()
@EnableMongoRepositories
public class EmbeddedDateSourceConfing {
//    @Bean(destroyMethod = "close")
////    public Mongo mongo()throuws IOExeption{
////        return new EmbeddedMongoBulider().bulid();
////    }
////    @Bean
////    public MongoTemplate mongoTemplate(Mongo mongo){
////        return new MongoTemplate(mongo,"blog");
////    }
////}
}