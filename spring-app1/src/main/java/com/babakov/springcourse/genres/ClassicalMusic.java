package com.babakov.springcourse.genres;

import com.babakov.springcourse.Music;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Component
public class ClassicalMusic implements Music {
//    private final List<String> musicList = new ArrayList(List.of(
//            new String[]{"Mocart", "Boyarskiy", "Balet"}));

    @Override
    public String getSong(){
        return "Mocart";

    }
}
