package com.babakov.springcourse.genres;

import com.babakov.springcourse.Music;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TehnoMusic implements Music {

    @Override
    public String getSong() {
        return "thekomakoma";
    }
}
