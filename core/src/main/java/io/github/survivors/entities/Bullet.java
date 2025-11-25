package io.github.survivors.entities;

import com.badlogic.gdx.Gdx;

public class Bullet extends Entity {
    private float dir;

    public Bullet(float x, float y, float width, float height, String texture) {
        super(x, y, width, height, texture);
        dir = (float)(Math.atan2(Gdx.input.getX() - x, -((Gdx.graphics.getHeight() - Gdx.input.getY()) - y)) - (Math.PI / 2));
        speed = 20;
        this.damage = em.getPlayer().damage;
        
    }

    @Override
    public void update() {
        this.x += (float)(Math.cos(dir) * speed);
        this.y += (float)(Math.sin(dir) * speed);
        sm.draw(x, y, getWidth(), getHeight(), getTexture());
    }

    @Override
    public void onCollide(Entity e) {
        if(e instanceof Enemy) {
            e.damage(damage);
            e.knockback(10);
        }
    }
    
}
