package com.example.gitapitest.Repo;

import org.eclipse.egit.github.core.IRepositoryIdProvider;

public class ApiTestRepo implements IRepositoryIdProvider {

    @Override
    public String generateId() {
        return "david02653/apiTest";
    }
}
