package com.wordwave.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MailDTO {
    private String toAddress;
    private String mainSubject;
    private String text;
}
