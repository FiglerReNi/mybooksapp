package hu.tmx.mybooksapp.service;

public interface EmailService {

    void sendMessage(String email, String code, String name) throws Exception;
}
