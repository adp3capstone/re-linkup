package za.ac.cput.linkup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.linkup.domain.Like;
import za.ac.cput.linkup.repository.LikeRepository;

import java.util.List;

@Service
public class LikeService implements ILikeService{

    @Autowired
    private LikeRepository likeRepository;

    @Override
    public Like create(Like like) {
        return likeRepository.save(like);
    }

    @Override
    public Like read(Long aLong) {
        return likeRepository.findById(aLong)
                .orElse(null);
    }

    @Override
    public Like update(Like like) {
        return likeRepository.save(like);
    }

    @Override
    public boolean delete(Long aLong) {
        return false;
    }

    @Override
    public List<Like> getAllLike() {
        return likeRepository.findAll();
    }
}
