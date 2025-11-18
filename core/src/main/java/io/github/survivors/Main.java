package io.github.survivors;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.utils.ScreenUtils;

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



        em.addEntity(new Player());
        tm.loadTextures();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        sm.begin();
        em.update();
        sm.draw(0, 0, 32, 32, "gigus");
        sm.end();
    }

    @Override
    public void dispose() {
        sm.dispose();
    }
}
