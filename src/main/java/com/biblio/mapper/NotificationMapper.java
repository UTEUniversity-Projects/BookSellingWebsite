package com.biblio.mapper;

import com.biblio.dto.response.NotificationGetResponse;
import com.biblio.entity.Notification;

public class NotificationMapper {
    public static NotificationGetResponse toNotificationGetResponse(Notification notification) {
        return NotificationGetResponse.builder()
                .id(notification.getId())
                .title(notification.getTitle())
                .content(notification.getContent())
                .type(notification.getType())
                .status(notification.getStatus())
                .hyperLink(notification.getHyperlink())
                .createdAt(notification.getCreatedAt())
                .sentTime(notification.getSentTime())
                .build();
    }
}
