package me.chatapp.missionchat.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@ToString @NoArgsConstructor
public class Message {
    private String author;
    private String content;
    private String timestamp;


}
