package za.ac.cput.linkup.service;

import za.ac.cput.linkup.domain.Like;

import java.util.List;

public interface ILikeService extends IService<Like, Long>{
    List<Like> getAllLike();
}
