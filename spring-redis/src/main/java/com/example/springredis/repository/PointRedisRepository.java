package com.example.springredis.repository;

import com.example.springredis.entity.Point;
import org.springframework.data.repository.CrudRepository;

public interface PointRedisRepository extends CrudRepository<Point, String> {

}
