package za.ac.cput.linkup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.linkup.domain.Like;
import za.ac.cput.linkup.domain.Match;
import za.ac.cput.linkup.repository.ILikeRepository;
import za.ac.cput.linkup.repository.LikeRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LikeService implements ILikeService{

    @Autowired
    private ILikeRepository likeRepository;

    @Autowired
    private MatchService matchService;



    @Override
    public Like create(Like like) {
        // Save the like if it does not already exist
        Like savedLike = likeRepository.save(like);

        boolean mutual = likeRepository.existsByFromUserIdAndToUserId(
                like.getToUserId(),   // B
                like.getFromUserId()  // A

        );

        if (mutual) {
            // Prevent duplicate matches
            if (!matchService.matchExists(like.getFromUserId(), like.getToUserId())) {
                // Build and save the match
                Match match = new Match.Builder()
                        .setUser1(like.getFromUserId())   // UserA
                        .setUser2(like.getToUserId())     // UserB
                        .setMatchedAt(LocalDateTime.now())
                        .setActive(true)
                        .build();

                matchService.create(match);
            }
        }
        return savedLike;
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

    public boolean delete(Long id) {
        if (likeRepository.existsById(id)) {
            likeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Like> getAllLike() {
        return likeRepository.findAll();
    }
}
