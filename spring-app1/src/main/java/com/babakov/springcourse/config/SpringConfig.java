package com.babakov.springcourse.config;

import com.babakov.springcourse.Computer;
import com.babakov.springcourse.Music;
import com.babakov.springcourse.MusicPlayer;
import com.babakov.springcourse.genres.ClassicalMusic;
import com.babakov.springcourse.genres.RockMusic;
import com.babakov.springcourse.genres.TehnoMusic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan("com.babakov.springcourse")
public class SpringConfig {
//    @Bean
//    public ClassicalMusic classicalMusic(){
//        return new ClassicalMusic();
//    }
//@Bean
//    public RockMusic rockMusic(){
//        return new RockMusic();
//    }
//@Bean
//    public TehnoMusic tehnoMusic(){
//        return new TehnoMusic();
//    }
//@Bean
//    public MusicPlayer musicPlayer(){
//        return new MusicPlayer(musicList());
//    }
//    @Bean
//    public List<Music> musicList(){
//        return Arrays.asList(classicalMusic(), rockMusic(), tehnoMusic());
//    }
//@Bean
//    public Computer computer(){
//        return new Computer(musicPlayer());
//    }
}
