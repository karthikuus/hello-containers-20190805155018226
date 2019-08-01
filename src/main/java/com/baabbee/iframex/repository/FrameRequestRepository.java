package com.baabbee.iframex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.baabbee.iframex.beans.FrameRequest;

public interface FrameRequestRepository extends CrudRepository<FrameRequest, Long> {

}
