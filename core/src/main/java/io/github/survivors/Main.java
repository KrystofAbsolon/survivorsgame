package io.github.survivors;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.ScreenUtils;

import io.github.survivors.entities.Enemy;
import io.github.survivors.entities.Player;
import io.github.survivors.managers.EntityManager;
import io.github.survivors.managers.SpriteManager;
import io.github.survivors.managers.TextureManager;

public class Main extends ApplicationAdapter {
    private SpriteManager sm;
    private EntityManager em;
    private TextureManager tm;

    @Override
    public void create() {
        tm = new TextureManager();
        sm = SpriteManager.getInstance();
        em = EntityManager.getInstance();

        em.addPlayer(new Player());
        em.addEntity(new Enemy(300, 300, 8, 100, 10,"enemy"));
        tm.loadTextures();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        sm.begin();
        em.update();
        sm.end();

        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) Gdx.app.exit();
    }

    @Override
    public void dispose() {
        sm.dispose();
    }
}