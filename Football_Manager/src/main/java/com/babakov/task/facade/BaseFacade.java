package com.babakov.task.facade;

import com.babakov.task.dto.RequestDto;
import com.babakov.task.dto.ResponseDto;

import java.util.List;

public interface BaseFacade <REQ extends RequestDto, RES extends ResponseDto> {

    void create(REQ req);
    void update(REQ req, Long id);
    void delete(Long id);
    RES findById(Long id);
    List<RES> findAll();
}
