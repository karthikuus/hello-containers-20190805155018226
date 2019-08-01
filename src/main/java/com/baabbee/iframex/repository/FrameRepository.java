package com.baabbee.iframex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.baabbee.iframex.beans.Frame;
import com.baabbee.iframex.beans.FrameRequest;

public interface FrameRepository extends CrudRepository<Frame, Long> {

	List<Frame> getBySize(String size);

}
