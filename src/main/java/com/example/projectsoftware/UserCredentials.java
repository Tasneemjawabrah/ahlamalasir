package com.example.projectsoftware;

public class UserCredentials {
    private static String email;
    private static String password;
    private static int userId; // Add userId field

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        UserCredentials.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        UserCredentials.password = password;
    }
    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        UserCredentials.userId = userId;
    }
}
