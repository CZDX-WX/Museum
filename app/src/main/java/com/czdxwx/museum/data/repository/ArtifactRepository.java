package com.czdxwx.museum.data.repository;

import com.czdxwx.museum.data.db.dao.ArtifactDao;
import com.czdxwx.museum.data.db.entities.Artifact;

import java.util.List;

public class ArtifactRepository {
    private final ArtifactDao artifactDao;

    public ArtifactRepository(ArtifactDao artifactDao) {
        this.artifactDao = artifactDao;
    }

    public List<Artifact> getAllArtifacts() {
        return artifactDao.getAllArtifacts();
    }

    public void insertArtifact(Artifact artifact) {
        artifactDao.insertArtifact(artifact);
    }
}
