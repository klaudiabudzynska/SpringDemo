package com.example.demo;

import java.util.Collection;

public class UserPage {
    public Integer PageNumber;
    public Integer PagesCount;
    public Integer PageSize;
    public Integer TotalCount;
    public Collection<UserEntity> Users;

    public UserPage() {

    }

    public UserPage(Integer pageNumber, Integer pagesCount, Integer pageSize, Integer totalCount, Collection<UserEntity> users) {
        PageNumber = pageNumber;
        PagesCount = pagesCount;
        PageSize = pageSize;
        TotalCount = totalCount;
        Users = users;
    }

    public void setPageNumber(Integer pageNumber) {
        PageNumber = pageNumber;
    }

    public void setPagesCount(Integer pagesCount) {
        PagesCount = pagesCount;
    }

    public void setPageSize(Integer pageSize) {
        PageSize = pageSize;
    }

    public void setTotalCount(Integer totalCount) {
        TotalCount = totalCount;
    }

    public void setUsers(Collection<UserEntity> users) {
        Users = users;
    }
}
