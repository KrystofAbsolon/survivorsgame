package io.github.survivors.managers;

import java.util.ArrayList;
import java.util.List;

import io.github.survivors.entities.Entity;

public class EntityManager {
    private static EntityManager instance;
    public static EntityManager getInstance() {
        if (instance == null) instance = new EntityManager();
        return instance;
    }

    private List<Entity> entities;

    public EntityManager() {
        entities = new ArrayList<>();
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public void update() {
        for (Entity e: entities) e.update();
    }
}