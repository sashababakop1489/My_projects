package com.babakov.demo.facade;

import com.babakov.demo.dto.RequestDto;
import com.babakov.demo.dto.ResponseDto;

import java.util.List;

public interface BaseFacade <REQ extends RequestDto, RES extends ResponseDto> {

    void create(REQ req);
    void update(REQ req, Long id);
    void delete(Long id);
    RES findById(Long id);
    List<RES> findAll();
}
