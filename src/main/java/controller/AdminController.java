package controller;

import model.BlogPost;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import reposidory.BlogRepository;

import javax.validation.Valid;
import java.util.*;
import java.util.logging.Logger;

@Controller
@RequestMapping("/admin")
@SessionAttributes("blogPost")
public class AdminController {
    private static Logger logger = (Logger) LoggerFactory.getLogger(AdminController.class);
    @Autowired
    BlogRepository blogRepository;

    @ModelAttribute("blogPost")
    public BlogPost getBlogPost() {
        return new BlogPost();
    }

    @RequestMapping(value = "")
    public String admin(ModelMap map) {
        Long postCount = blogRepository.count();
        Integer tagCount = blogRepository.findAllTags().size();
        map.addAttribute("postCount", postCount);
        map.addAttribute("tagCount", tagCount);
        return "admin/admin";
    }

    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public String blogAdmin(ModelMap map, SessionStatus status) {
        status.setComplete();
        List<BlogPost> postList = blogRepository.findAll();
        map.addAttribute("postList", postList);
        return "admin/blogPostList";

    }

    @RequestMapping(value = "/blog/new", method = RequestMethod.POST)
    public String addPost(@Valid @ModelAttribute BlogPost blogPost, BindingResult result,
                          @RequestParam(value = "tagString", defaultValue = "") String tagString,
                          @RequestParam(value = "enablePegdown", required = false) boolean enablePegdown,
                          Model model, SessionStatus status)

    {
        if (result.hasErrors()) {
            return "admin/editBlogPost";

        }
        Set<String> tagSet = new HashSet<>();
        for (String tag : tagString.split(",")) {
            tag = tag.replace("//s+", "");
            if (tag != null && !tag.equals("")) {
                tagSet.add(tag);
            }
        }

blogPost.setEnablePegdown(enablePegdown);


        blogPost.setTags(tagSet);
        blogRepository.save(blogPost);
        status.setComplete();
        return "redrict:/admin/blog";
    }
//    @RequestMapping(value = "/blog/{id}",method = RequestMethod.GET)
//    public String editpost(ModelMap map, @PathVariable("id")String postId){
//        Optional<BlogPost> blogPost=blogRepository.findOne();
//        map.addAttribute("blogPost",blogPost);
//        Set<String> tags=blogPost.getTags();
//        String tagString="";
//        for(String tag :tags){
//            tagString=tagString+" "+tag;
//        }
//        tagString=tagString.trim();
//        map.addAttribute("tagString",tagString);
//        return "admin/editBlogPost";

//
//    }
//    @RequestMapping(value = "/blog/{id}",method = RequestMethod.POST)
//    public void savePostChanges(@Valid @ModelAttribute BlogPost blogPost, BindingResult result, @RequestMapping(value = "tagString")String tagString, @RequestParam("enablePegdown") boolean enablePegdown, Model model, SessionStatus status)
//
//    {
//
//        if (result.hasErrors()) {
//            return "admin/editBlogPost";
//        }
//        Set<String> tagSet=new HashSet<>();
//        for(String tag:tagString.split(",")){
//            tag=tag.replaceAll("//s+","");
//            if (!tag.equals("")&&tag!=null){
//                tagSet.add(tag);
//            }
//        }
//        if (!tag.equlas())

//    blogPost.setTags(tagSet);
//            blogPost.setPostDate(new Date());
//            blogRepository.save(blogPost);
//            status.setComplete();
//            return "redirect:/admin/blog";
//
//            }

//Delete blog post
@RequestMapping(value="/blog/delet/{id}", method=RequestMethod.POST)
public @ResponseBody  String deletBlogPost(@PathVariable("id")String id,SessionStatus status){
//    blogRepository.delete(String  id);
    status.setComplete();
    return "The item was deleted succesfully";
}



@RequestMapping(value="/blog/cancel", method=RequestMethod.GET)
public String cancelBlogEdit(SessionStatus status){
        status.setComplete();
        return "redirect:/admin/blog";
        }

//Tag list
//@RequestMapping(value="/tags", method=RequestMethod.GET)
//public String adminTagList(ModelMap map, SessionStatus status) {
//    status.setComplete();
//    List<BlogPost> posts = blogRepository.findAll();
//    Map<String, Integer> tagCounts = new HashMap<>();
//    for (BlogPost post : posts)
//        for (String tag : posts.getTagss()) {
//            if (!tagCounts.containsKey(tag)) {
//                tagCounts.put(tag, 0);
//            }
//            Integer count = tagCounts.get(tag);
//            tagCounts.put(tag, count + 1);
//        }
//
//        map.addAttribute("tags", tagCounts.keySet());
//        map.addAttribute("tagCounts", tagCounts);
//        return "admin/tagList";
        }

