package reposidory;

import com.mongodb.DBCollection;
import model.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BlogRepositoryImpl implements  BlogOperations {

    @Autowired
   private MongoTemplate mongoTemplate;
    private DBCollection getCollection(){
        return (DBCollection) mongoTemplate.getCollection(mongoTemplate.getCollectionName(BlogPost.class));
    }

    @Override
    public List<String> findTagsByFragment(String fragment) {
        Pattern pattern =Pattern.compile("^>*?"+fragment+".*$",Pattern.CASE_INSENSITIVE);
        List<String > matched =new ArrayList<>();
        for (String tag:this.findAllTags()){
            if (pattern.matcher(tag).find()){
                matched.add(tag);
            }
        }

        return null;
    }

    @Override
    public List<String> findAllTags() {
        return getCollection().distinct("tags");
    }
}
