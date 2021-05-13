package daddesh.demo.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import daddesh.demo.dao.entity.Blog;
import daddesh.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @GetMapping("/")
    public List<Blog> getBlog(){
        return  iBlogService.getAllBlog();

    }
    @GetMapping("/find")
    public Blog getBlog(@RequestParam Long id){
        return  iBlogService.findById(id);

    }
    @PostMapping("/add")
    public ResponseEntity<?> saveBlog(@RequestParam("file[]") MultipartFile file,
                                      @RequestParam("blog") String blog)
            throws JsonParseException, JsonMappingException, Exception{
        Blog blog1 = new ObjectMapper().readValue(blog, Blog.class);
        return ResponseEntity.ok(iBlogService.addBlog(blog1, file));
    }

    @GetMapping(path="/blogImage/{id}")
    public byte[] getImageBlog(@PathVariable("id") Long id)throws Exception{

        return iBlogService.getBlogImage(id);

    }
    @DeleteMapping("/remove")
    public boolean deleteBlog(@RequestParam Long id){
        return  iBlogService.deleteBlog(id);

    }
    @PutMapping ("/update")
    public boolean updateBlog (@RequestBody Blog blog){
        return  iBlogService.updateBlog(blog);

    }

}
