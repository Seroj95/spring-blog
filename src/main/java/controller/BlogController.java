package controller;

import model.BlogPost;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reposidory.BlogRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BlogController {
    private static Logger logger = (Logger) LoggerFactory.getLogger(BlogController.class);
    @Autowired
    private BlogRepository blogRepository;
    private String slug;

    @RequestMapping(value = {"/", "", "/blog"}, method = RequestMethod.GET)
    public String home(@PageableDefault(size = 5, sort = {"postDate"}, direction = Sort.Direction.DESC) Pageable pageable, ModelMap map) {

        {
            Page<BlogPost> posts = (Page<BlogPost>) blogRepository.findByStatusOrderByPostDateAsc(BlogPost.STATUS_ACTIVE, pageable);
            List<BlogPost> blogPosts = new ArrayList<>(posts.getContent());
            map.addAttribute("currenPage", pageable.getPageNumber() + 1);
            map.addAttribute("numPages", posts.getTotalPages());
            map.addAttribute("blogPosts", blogPosts);
            return "home";

        }
//        @RequestMapping(value="/blog/{slug}")
//        public String post(ModelMap map, @PathVariable("slug") String slug){
//            BlogPost post = blogRepository.findBySlug(slug);
//            map.addAttribute("requestedPost", post);
//            map.addAttribute("nextPost", null);
//            map.addAttribute("previousPost", null);
//            return "blogPost";
//
//        }
//        equestMapping(value="/tags", method=RequestMethod.GET)
//        public String listTags(ModelMap map){
//            List<String> tags = blogRepository.findAllTags();
//            List<BlogPost> posts = blogRepository.findAll();
//            Map<String,Integer> tagCounts = new HashMap<>();
//            for (BlogPost post: posts){
//                for (String tag: post.getTags()){
//                    if (!tagCounts.containsKey(tag)){
//                        tagCounts.put(tag, 0);
//                    }
//                    Integer count = tagCounts.get(tag);
//                    tagCounts.put(tag, count + 1);
//
//            }
//            map.addAttribute("tags", tagCounts.keySet());
//            map.addAttribute("tagCounts", tagCounts);
//            return "tagList";
//        }
//
//        @RequestMapping(value="/tags/{tag}", method=RequestMethod.GET)
//        public String tagDetails(ModelMap map, @PathVariable("tag") String tag){
//            List<BlogPost> blogPosts = blogRepository.findByTags(tag);
//            map.addAttribute("tag", tag);
//            map.addAttribute("blogPosts", blogPosts);
//            return "tagDetails";
//        }
//
//        //About page
//        @RequestMapping(value="/about")
//        public String about(ModelMap map){
//            return "about";
    }
}