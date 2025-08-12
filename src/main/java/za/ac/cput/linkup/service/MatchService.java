package za.ac.cput.linkup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.linkup.domain.Match;
import za.ac.cput.linkup.domain.User;
import za.ac.cput.linkup.repository.MatchRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MatchService implements IMatchService{

    @Autowired
    private MatchRepository matchRepository;


    @Override
    public Match create(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public Match read(Long aLong) {
        return matchRepository.findById(aLong).orElse(null);
    }

    @Override
    public Match update(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public boolean delete(Long aLong) {
        return false;
    }

    @Override
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    // method to check if a match exists between two users
    public boolean matchExists(User user1, User user2) {
        return matchRepository.existsByUser1AndUser2OrUser2AndUser1(user1, user2, user2, user1);
    }

    // method to create a match only if it doesn't exist yet
    public Match createMatchIfNotExists(User user1, User user2) {
        if (!matchExists(user1, user2)) {
            Match match = new Match.Builder()
                    .setUser1(user1)
                    .setUser2(user2)
                    .setMatchedAt(LocalDateTime.now())
                    .setActive(true)
                    .build();
            return matchRepository.save(match);
        }
        return null;
    }
}
