package io.github.survivors.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import io.github.survivors.managers.SpriteManager;

public class Player extends Entity {
    private final SpriteManager sm;

    public Player() {
        super(100, 100, 32, 32, 1.0f, 10, 100, 10, "player");
        sm = SpriteManager.getInstance();
    }

    @Override
    public void update() {
        sm.draw(getX(), getY(), getWidth(), getHeight(), getTexture());

        if (Gdx.input.isKeyPressed(Input.Keys.W)) this.y += speed;
        if (Gdx.input.isKeyPressed(Input.Keys.S)) this.y -= speed;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) this.x -= speed;
        if (Gdx.input.isKeyPressed(Input.Keys.D)) this.x += speed;

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            em.addEntity(new Bullet(x, y, 16, 16, "player"));
        }

        this.sprite.setX(this.x);
        this.sprite.setY(this.y);

        if(health<=0) destroy();
    }

    @Override
    public void onCollide(Entity e) {
        if(e instanceof Enemy) e.knockback(350f);
    }
}
