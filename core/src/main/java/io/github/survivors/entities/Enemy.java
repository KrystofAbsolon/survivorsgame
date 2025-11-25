package io.github.survivors.entities;

public class Enemy extends Entity {
    public Enemy(float x, float y, float speed,  int health, int damage, String texture) {
        super(x, y, 32, 32, 1, speed, health, damage, texture);
    }

    public void update() {
        Player p = em.getPlayer();
        sm.draw(x, y, width, height, texture);
        float playerDistX = x - p.getX();
        float playerDistY = y - p.getY();

        float dir = (float) (Math.atan2(p.x - x, -(p.y - y)) - (Math.PI / 2));
        if(Math.abs(playerDistX) >= 32f) this.x += (float)(Math.cos(dir) * speed / 2);
        if(Math.abs(playerDistY) >= 32f) this.y += (float)(Math.sin(dir) * speed / 2);
        this.sprite.setX(this.x);
        this.sprite.setY(this.y);

        if(health<=0) destroy();
    }

    public void onCollide(Entity e) {
        if(e instanceof Player) ((Player) e).damage(damage);
    }
}
