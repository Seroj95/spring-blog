package model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Set;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "blog_posts")
public class BlogPost {
    public static  String STATUS_ACTIVE  ;
    private static String STATUS_INACTIVE;
    @Id
    private String postId;
    @NonNull
    private String title;
    @NonNull
    private String contect;
    private Date postDate = new Date();
    private String status = BlogPost.STATUS_INACTIVE;
    private boolean enableComments = false;
    private boolean enablePegdown = true;

    public void setTags(Set<String> tagSet) {
    }

    public Set<String> getTags() {
        return null;
    }

    public void setSlug(String s) {
    }

    public void setContent(String content) {
    }
}

