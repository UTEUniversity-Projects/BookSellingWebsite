package com.biblio.dao;

import com.biblio.entity.MediaFile;

public interface IMediaFileDAO {

    MediaFile save(MediaFile mediaFile);

    MediaFile createMediaFile(MediaFile mediaFile);
    void deleteMediaFile(Long id);
}
