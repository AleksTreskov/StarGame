package ru.geekbrains.stargame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class StarGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    Texture backGround;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        backGround = new Texture("backGround.png");
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);
        batch.begin();
        batch.draw(backGround,0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(img, 0, 0);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
