package com.example.demo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * data.sql用のパスワードハッシュを生成するツール
 * 一時的に使用してdata.sqlを作成後は削除可能
 */
public class PasswordHashGenerator {
    
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        // テスト用パスワードのハッシュ化
        String password1 = "password123";
        String password2 = "admin123";
        String password3 = "test123";
        
        System.out.println("=== data.sql用パスワードハッシュ ===");
        System.out.println("password123: " + encoder.encode(password1));
        System.out.println("admin123: " + encoder.encode(password2));
        System.out.println("test123: " + encoder.encode(password3));
        System.out.println("=====================================");
        
        // 確認用：生成したハッシュでマッチするかテスト
        String hash = encoder.encode(password1);
        System.out.println("パスワード確認テスト:");
        System.out.println("password123でマッチ: " + encoder.matches(password1, hash));
        System.out.println("wrongpasswordでマッチ: " + encoder.matches("wrongpassword", hash));
    }
}
