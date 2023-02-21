package com.ippikioukami.acftbackend.Repositories;

import com.ippikioukami.acftbackend.Model.ServiceMember;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SMRepository extends CrudRepository<ServiceMember, Integer> {
}
