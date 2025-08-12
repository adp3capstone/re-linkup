package za.ac.cput.linkup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.linkup.domain.Match;
import za.ac.cput.linkup.repository.MatchRepository;

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
}
