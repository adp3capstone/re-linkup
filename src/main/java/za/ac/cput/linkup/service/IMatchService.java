package za.ac.cput.linkup.service;

import za.ac.cput.linkup.domain.Match;

import java.util.List;

public interface IMatchService extends IService<Match, Long> {
    List<Match> getAllMatches();

}
