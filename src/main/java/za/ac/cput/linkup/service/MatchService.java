package za.ac.cput.linkup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.linkup.domain.Match;
import za.ac.cput.linkup.domain.User;
import za.ac.cput.linkup.repository.IMatchRepository;
import za.ac.cput.linkup.repository.MatchRepository;

import java.util.List;

@Service
public class MatchService implements IMatchService{

    @Autowired
    private IMatchRepository matchRepository;

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

    //check if a match already exists between two users
    public boolean matchExists(User user1Id, User user2Id) {
        return matchRepository.findByUser1AndUser2(user1Id, user2Id).isPresent()
                || matchRepository.findByUser2AndUser1(user1Id, user2Id).isPresent();
    }

    // Find all matches for a specific user
    public List<Match> getMatchesForUser(User user) {
        return matchRepository.findByUser1OrUser2(user, user);
    }
}
