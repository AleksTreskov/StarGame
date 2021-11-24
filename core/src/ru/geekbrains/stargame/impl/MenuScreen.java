package ru.geekbrains.stargame.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.BaseScreen;

public class MenuScreen extends BaseScreen {
    private final double V_LEN = 1;
    private Texture img;
    private Texture backGroundImg;
    private Vector2 pos;
    private Vector2 touch;
    private Vector2 v;
    private Vector2 temp;

    @Override
    public void show() {
        super.show();
        img = new Texture("data/badlogic.jpg");
        backGroundImg = new Texture("data/backGroundImg.png");

        pos = new Vector2();
        touch = new Vector2();
        v = new Vector2();
        temp = new Vector2();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        v.set(touch.cpy().sub(pos)).nor();
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        batch.begin();

        batch.draw(img, pos.x, pos.y);
        batch.end();
        temp.set(touch);
        if (temp.sub(pos).len() > V_LEN) {
            pos.add(v);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        backGroundImg.dispose();
    }
}
