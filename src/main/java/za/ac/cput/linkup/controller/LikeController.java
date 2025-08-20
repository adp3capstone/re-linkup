package za.ac.cput.linkup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.linkup.domain.Like;
import za.ac.cput.linkup.service.LikeService;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/create")
    public Like create(@RequestBody Like like) {
        return likeService.create(like);
    }

    @GetMapping("/read/{likeId}")
    public Like read(@PathVariable Long likeId) {
        return likeService.read(likeId);
    }

    @PostMapping("/update")
    public Like update(@RequestBody Like like) {
        return likeService.update(like);
    }

    @DeleteMapping("/delete/{likeId}")
    public boolean delete(@PathVariable Long likeId) {
        likeService.delete(likeId);
        return likeService.read(likeId) == null;
    }

    @GetMapping("/getAll")
    public List<Like> getAll() {
        return likeService.getAllLike();
    }

}
