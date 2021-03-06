package reposidory;

import model.BlogPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface BlogRepository extends MongoRepository<BlogPost,String>,BlogOperations {
    List<BlogPost> findByStatusOrderByPostDateAsc(String status);

    Page<BlogPost> findByStatusOrderByPostDateAsc(String status,Pageable pageable);
    BlogPost findBySlug(String slug);
    List<BlogPost>findByTags(String tag);


    Optional<BlogPost> findOne();
}
