package io.github.survivors.managers;

import java.util.ArrayList;
import java.util.List;

import io.github.survivors.entities.Entity;
import io.github.survivors.entities.Player;

public class EntityManager {
    private static EntityManager instance;
    public static EntityManager getInstance() {
        if (instance == null) instance = new EntityManager();
        return instance;
    }

    private Player player;
    private List<Entity> entities;

    public EntityManager() {
        entities = new ArrayList<>();
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public void addPlayer(Player p) {
        this.player = p;
        addEntity(p);
    }

    public Player getPlayer() {
        return player;
    }

    public void update() {
        for (Entity e: entities) {
            e.update();

            for (Entity e2: entities) {
                if (!e.equals(e2)) {
                    if (e.getSprite().getBoundingRectangle().overlaps(e2.getSprite().getBoundingRectangle())) {
                        e.onCollide(e2);
                        e2.onCollide(e);
                    }
                }
            }
        }
    }
}