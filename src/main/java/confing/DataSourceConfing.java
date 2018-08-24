package confing;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Profile({"prd"})
@PropertySource({"classpath:data-source.properties"})

public class DataSourceConfing  extends AbstractMongoConfiguration {


    @Bean
    public Mongo mongo() throws Exception {
        ServerAddress serverAddress = new ServerAddress(("mongo.host"));
        List<MongoCredential> credentials = new ArrayList<>();
        return new MongoClient(serverAddress, credentials);
    }

    @Override
    protected String getDatabaseName() {
        return null;
    }

    @Override
    public MongoClient mongoClient() {
        return null;
    }
}
