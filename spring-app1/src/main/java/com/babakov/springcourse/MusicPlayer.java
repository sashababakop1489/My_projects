package com.babakov.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Component
public class MusicPlayer {

private final List<Music> musicList;
@Autowired
    public MusicPlayer(List<Music> musicList){
        this.musicList = musicList;
    }

    public String playMusic() {
        Random random = new Random();
        return musicList.get(random.nextInt(musicList.size())).getSong();
    }
}
