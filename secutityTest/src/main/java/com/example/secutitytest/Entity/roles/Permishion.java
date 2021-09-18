package com.example.secutitytest.Entity.roles;

public enum Permishion {
    DEVELOPERS_READ("developers:read"),
    DEVELOPERS_WRITE("developers:write");

    private final String permission;

    Permishion(String permission){
        this.permission=permission;
    }

    public String getPermission(){
        return permission;
    }
}
