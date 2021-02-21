package com.example.gitapitest;

import com.example.gitapitest.Repo.ApiTestRepo;
import com.example.gitapitest.Repo.FibonacciRepo;
import org.eclipse.egit.github.core.*;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.client.GitHubRequest;
import org.eclipse.egit.github.core.service.CommitService;
import org.eclipse.egit.github.core.service.RepositoryService;

import java.io.IOException;
import java.util.List;

public class GitTest {

    public static void test(){
        System.out.println("testing");
    }

    public static void authentication() throws IOException {
//        GitHubClient client = new GitHubClient("github.com").setCredentials("username", "password");
        GitHubClient client = new GitHubClient("github.com").setOAuth2Token("token");
    }

    public static void repoServiceTest() throws IOException{

//        RepositoryService repoService = new RepositoryService();
//        for(Repository repo: repoService.getRepositories("david02653")){
//            System.out.println(repo.getName() + " Watchers: " + repo.getWatchers());
//            if(repo.getName().equals("apiTest")){
//                System.out.println(repo.generateId());
//            }
//        }

//        System.out.println();
//
//        Repository target = repoService.getRepository(new ApiTestRepo());
//        System.out.println(target.getGitUrl());
//        System.out.println(target.getDescription());
//        System.out.println(target.getCloneUrl());

//        GitHubClient client = new GitHubClient("github.com").setOAuth2Token("token");
        RepositoryService repositoryService = new RepositoryService();
        Repository repo = repositoryService.getRepository(new ApiTestRepo());
        System.out.println(repo.getCloneUrl());
        System.out.println(repo.getDescription());
    }

    public static void commitService() throws IOException {
//        RepositoryService repoService = new RepositoryService();
//        Repository repo = repoService.getRepository(new FibonacciRepo());
//        System.out.println(repo.getCloneUrl());
//        repo.setDescription("change description");

//        CommitService commitService = new CommitService();
////        System.out.println(commitService.getComments(repo).getClass());
//        for(CommitComment comment: commitService.getComments(repo)){
//            System.out.println(comment);
//            System.out.println(comment.getPath());
//            System.out.println(comment.getBody());
//        }
//        System.out.println();
//        System.out.println(commitService.getComments(repo).size());
        GitHubClient client = new GitHubClient("github.com").setCredentials("username", "password");
        RepositoryService repositoryService = new RepositoryService();
        for(Repository repo: repositoryService.getRepositories("david02653")){
            if(repo.getName().equals("Fibonacci")){
                System.out.println(repo.getCloneUrl());

                CommitService commitService = new CommitService();
//                commitService.getCommits(repo);
                for(RepositoryCommit repoCommit: commitService.getCommits(repo)){
                    System.out.println(repoCommit);
                    System.out.println(repoCommit.getCommit());
                    System.out.println(repoCommit.getCommit().getMessage());
                }
            }
        }
//        Repository repo = repositoryService.getRepository(new FibonacciRepo());
//        System.out.println(repo.getCloneUrl());
//        System.out.println(repo.getDescription());

//        for(RepositoryCommit repoCommit: commitService.getCommits(new FibonacciRepo())){
//            System.out.println(repoCommit.getCommit().getMessage());
//        }


    }
}
