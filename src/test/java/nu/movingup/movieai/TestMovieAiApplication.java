package nu.movingup.movieai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestMovieAiApplication {

    public static void main(String[] args) {
        SpringApplication.from(MovieAiApplication::main).with(TestMovieAiApplication.class).run(args);
    }

}
