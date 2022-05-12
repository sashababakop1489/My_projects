package com.babakov.springcourse.genres;

import com.babakov.springcourse.Music;
import org.springframework.stereotype.Component;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
@Component
public class RockMusic implements Music {
//    private final List<String> musicList = new ArrayList(List.of(
//            new String[]{"Nirvana", "Ramshtain", "KIW"}));
@Override
    public String getSong() {
        return "KIW";   }
}
