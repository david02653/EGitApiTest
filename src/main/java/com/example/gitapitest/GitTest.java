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
        GitHubClient client = new GitHubClient("github.com").setOAuth2Token("33ad2a6fddceba1cf186865131a4bf2275c47c2d");
    }

    public static void repoServiceTest() throws IOException{

        RepositoryService repoService = new RepositoryService();
        for(Repository repo: repoService.getRepositories("david02653")){
            System.out.println(repo.getName() + " Watchers: " + repo.getWatchers());
//            if(repo.getName().equals("apiTest")){
//                System.out.println(repo.generateId());
//            }
        }

//        Repository target = repoService.getRepository(new ApiTestRepo());
//        System.out.println(target.getGitUrl());
//        System.out.println(target.getDescription());
//        System.out.println(target.getCloneUrl());

//        GitHubClient client = new GitHubClient("github.com").setOAuth2Token("33ad2a6fddceba1cf186865131a4bf2275c47c2d");
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
                    Commit commit = repoCommit.getCommit();
                    System.out.print("> ");
                    System.out.println(repoCommit);
//                    System.out.println(repoCommit.getCommit());
                    System.out.println(repositoryCommitContent(repoCommit));
                    System.out.println(commit);
//                    System.out.println(repoCommit.getCommit().getMessage());
                    System.out.println(commitContent(commit));
                    System.out.println();
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

    public static void dataService() throws IOException {
        // TODO: test data service
        /* EGit Data Service testing */
        // create commit
    }

    public static void pullRequestTest() throws IOException {
        // TODO: test pull request service
        /* EGit Pull Request testing */
    }

    public static void issueService() throws IOException {
        // TODO: test issue request service
        /* EGit Issue Service testing */
    }

    // return given commit in String
    public static String commitContent(Commit commit){
        StringBuilder builder = new StringBuilder("");
        builder.append("[Author]: " + commit.getAuthor() + "\n");
        builder.append("[CommentCount]: " + commit.getCommentCount() + "\n");
        builder.append("[Committer]: " + commit.getCommitter() + "\n");
        builder.append("[Message]: " + commit.getMessage() + "\n");
        builder.append("[Parents] : " + commit.getParents() + "\n");
        builder.append("[Sha]: " + commit.getSha() + "\n");
        builder.append("[Tree]: " + commit.getTree() + "\n");
        builder.append("[Url]: " + commit.getUrl());
        return builder.toString();
    }

    // return given Repository Commit in String
    public static String repositoryCommitContent(RepositoryCommit commit){
        StringBuilder builder = new StringBuilder("");
        builder.append("[Author]: " + commit.getAuthor() + "\n");
        builder.append("[Commit]: " + commit.getCommit() + "\n");
        builder.append("[Committer]: " + commit.getCommitter() + "\n");
        builder.append("[Files]: " + commit.getFiles() + "\n");
        builder.append("[Parents] : " + commit.getParents() + "\n");
        builder.append("[Sha]: " + commit.getSha() + "\n");
        builder.append("[Stats]: " + commit.getStats() + "\n");
        builder.append("[Url]: " + commit.getUrl());
        return builder.toString();
    }
}
