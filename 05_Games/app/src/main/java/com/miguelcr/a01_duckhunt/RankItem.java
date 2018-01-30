package com.miguelcr.a01_duckhunt;

import io.realm.RealmObject;

/**
 * Created by miguelcampos on 30/1/18.
 */

public class RankItem extends RealmObject {
    String nick;
    int points;

    public RankItem() {}

    public RankItem(String nick, int points) {
        this.nick = nick;
        this.points = points;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
