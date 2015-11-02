package io.protostuff.examples;

/**
 * @author Kostiantyn Shchepanovskyi
 */
public class Bar {

    private final int id;
    private final String name;

    private Bar(Builder builder) {
        id = builder.id;
        name = builder.name;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bar bar = (Bar) o;

        if (id != bar.id) return false;
        return !(name != null ? !name.equals(bar.name) : bar.name != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static final class Builder {
        private int id;
        private String name;

        private Builder() {
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Bar build() {
            return new Bar(this);
        }
    }
}
