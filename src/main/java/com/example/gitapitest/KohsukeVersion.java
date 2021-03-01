package com.example.gitapitest;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.List;

public class KohsukeVersion {

    private GitHub gitHub;

    KohsukeVersion() throws IOException{
//        this.gitHub = GitHub.connect();
        this.gitHub = new GitHubBuilder().withOAuthToken("").build();
    }

    final String test = "test";

    public void test(){
        System.out.println(test);
    }

    public void tryAccess() throws IOException {
//        GitHub gitHub = GitHub.connect();

        GHRepository repo = gitHub.getRepository("david02653/Fibonacci");
        System.out.println(repo.getDescription());
    }

    public void issue() throws IOException {
        GHRepository apiRepo = gitHub.getRepository("david02653/apiTest");
        GHRepository FRepo = gitHub.getRepository("david02653/Fibonacci");
        List<GHIssue> apiIssueList = apiRepo.getIssues(GHIssueState.OPEN);

        /* finding target issue by github-milestone */
//        for(GHIssue ghIssue: apiIssueList){
//            if(ghIssue.getMilestone() != null){
//                System.out.print(ghIssue.getMilestone().getTitle() + " > ");
//            }else{
//                System.out.print("no milestone > ");
//            }
//            System.out.println(ghIssue.getTitle());
//        }

//        GHMilestone milestone = apiRepo.getMilestone(1);
//        List<GHIssue> milestoneList = apiRepo.getIssues(GHIssueState.OPEN, milestone);
//        System.out.println(apiIssueList.size());
//        GHIssue target = apiIssueList.get(0);
//        System.out.println(target.getTitle());
//
//        System.out.println(milestoneList.get(0).getTitle());

        /* try to add comment in issue */
        for(GHIssue ghIssue: apiIssueList){
            if(ghIssue.getMilestone()!= null && ghIssue.getMilestone().getTitle().equals("VersionManage")){
                ghIssue.comment("update");
            }
        }
    }

}
