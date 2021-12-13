package ru.geekbrains.stargame.screen.impl;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.math.Rect;
import ru.geekbrains.stargame.screen.BaseScreen;
import ru.geekbrains.stargame.sprite.impl.Background;
import ru.geekbrains.stargame.sprite.impl.ButtonExit;
import ru.geekbrains.stargame.sprite.impl.ButtonPlay;
import ru.geekbrains.stargame.sprite.impl.Star;

public class MenuScreen extends BaseScreen {
    private static final int STAR_COUNT = 256;

    private final Game game;
    private Texture backGroundImg;
    private Star[] stars;
    private ButtonExit buttonExit;
    private ButtonPlay buttonPlay;
    private Background background;
    private TextureAtlas atlas;

    public MenuScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        super.show();
        backGroundImg = new Texture("data/backGroundImg.png");
        background = new Background(backGroundImg);
        atlas = new TextureAtlas("data/menuAtlas.tpack");

        stars = new Star[STAR_COUNT];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(atlas);
        }
        buttonExit = new ButtonExit(atlas);
        buttonPlay = new ButtonPlay(atlas, game);

    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        background.resize(worldBounds);
        for (Star star : stars) {
            star.resize(worldBounds);
        }
        buttonExit.resize(worldBounds);
        buttonPlay.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        buttonExit.touchDown(touch, pointer, button);
        buttonPlay.touchDown(touch, pointer, button);
        return false;
    }
    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        buttonExit.touchUp(touch, pointer, button);
        buttonPlay.touchUp(touch, pointer, button);
        return false;
    }
    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();


    }

    private void update(float delta) {
        for (Star star : stars) {
            star.update(delta);
        }
    }



    private void draw() {
        batch.begin();
        background.draw(batch);
        for (Star star : stars) {
            star.draw(batch);
        }
        buttonExit.draw(batch);
        buttonPlay.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();

        backGroundImg.dispose();
        atlas.dispose();
    }
}
