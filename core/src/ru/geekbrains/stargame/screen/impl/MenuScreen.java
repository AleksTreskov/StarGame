package ru.geekbrains.stargame.screen.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.math.Rect;
import ru.geekbrains.stargame.screen.BaseScreen;
import ru.geekbrains.stargame.sprite.impl.Logo;
import ru.geekbrains.stargame.sprite.impl.Background;

public class MenuScreen extends BaseScreen {
    private final float V_LEN = 1;
    private Texture img;
    private Texture backGroundImg;
    private Background background;
    private Logo logo;

    @Override
    public void show() {
        super.show();
        img = new Texture("data/badlogic.jpg");
        backGroundImg = new Texture("data/backGroundImg.png");
        background = new Background(backGroundImg);
        logo = new Logo(img);

    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        logo.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        logo.touchDown(touch, pointer, button);
        return false;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();


    }

    private void update(float delta) {
        logo.update(delta);
    }

    private void draw() {
        batch.begin();
        background.draw(batch);
        logo.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        backGroundImg.dispose();
    }
}
