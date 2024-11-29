package com.biblio.dto.response;

import com.biblio.enumeration.ENotificationStatus;
import com.biblio.enumeration.ENotificationType;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class NotificationGetResponse {
    private Long id;
    private String content;
    private String title;
    private ENotificationType type;
    private ENotificationStatus status;
    private String hyperLink;
    private LocalDateTime createdAt;
    private LocalDateTime sentTime;
}
