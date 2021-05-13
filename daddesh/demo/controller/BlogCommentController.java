package daddesh.demo.controller;

import daddesh.demo.dao.entity.*;
import daddesh.demo.service.IBlogCommentService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blogcomment")
public class BlogCommentController {

    @Autowired
    IBlogCommentService iBlogCommentService;

    @GetMapping("/")
    public List<BlogComment> getBlog(){
        return  iBlogCommentService.getAllBlogComment();

    }
    @GetMapping("/find")
    public Optional<BlogComment> getBlog(@RequestParam Long id){
        return  iBlogCommentService.findById(id);

    }
    @PostMapping("/add")
    public BlogComment addCommande(@RequestBody BlogComment blogComment){

        return  iBlogCommentService.addBlogComment(blogComment);

    }


    @DeleteMapping("/remove")
    public boolean deleteBlog(@RequestParam Long id){
        return  iBlogCommentService.deleteBlogComment(id);

    }
    @PutMapping ("/update")
    public boolean updateBlog (@RequestBody BlogComment comment){
        return  iBlogCommentService.updateBlogComment(comment);

    }
    @GetMapping("/findbyblog")
    public List <BlogComment> getBlogCommentByBlog(@RequestParam Blog blog){
        return  iBlogCommentService.getByBlog(blog);

    }

}
