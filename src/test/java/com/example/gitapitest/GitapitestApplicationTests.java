package com.example.gitapitest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GitapitestApplicationTests {

    @Test
    public void testAuth() throws Exception{
        GitTest.authentication();
    }

    @Test
    public void testRepoService() throws Exception{
        GitTest.repoServiceTest();
    }

    @Test
    public void testCommitService() throws Exception{
        GitTest.commitService();
    }

}
