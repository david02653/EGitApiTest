package com.example.gitapitest;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class KohosukeVersionTest {

    private KohsukeVersion unit;
    @BeforeEach
    public void setup() throws Exception{
        this.unit = new KohsukeVersion();
    }

    @Test
    public void testInit(){
        unit.test();
    }

    @Test
    public void testTryAccess() throws IOException{
        unit.tryAccess();
    }

    @Test
    public void testIssue() throws Exception{
        unit.issue();
    }
}
