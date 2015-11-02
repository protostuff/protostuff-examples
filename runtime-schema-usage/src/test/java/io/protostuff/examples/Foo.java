package io.protostuff.examples;

import java.util.Map;

/**
 * @author Kostiantyn Shchepanovskyi
 */
public class Foo {

    private Bar bar;
    private Map<Integer, String> map;

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Foo foo = (Foo) o;

        if (bar != null ? !bar.equals(foo.bar) : foo.bar != null) return false;
        return !(map != null ? !map.equals(foo.map) : foo.map != null);

    }

    @Override
    public int hashCode() {
        int result = bar != null ? bar.hashCode() : 0;
        result = 31 * result + (map != null ? map.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "bar=" + bar +
                ", map=" + map +
                '}';
    }
}
