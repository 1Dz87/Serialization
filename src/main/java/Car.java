public class Car {

    private Long id;

    private String name;

    private Float engineValue;

    public Car() {
    }

    public Car(Long id, String name, Float engineValue) {
        this.id = id;
        this.name = name;
        this.engineValue = engineValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getEngineValue() {
        return engineValue;
    }

    public void setEngineValue(Float engineValue) {
        this.engineValue = engineValue;
    }

    public static class Builder {

        private Long id;

        private String name;

        private Float engineValue;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder engineValue(Float engineValue) {
            this.engineValue = engineValue;
            return this;
        }

        public Car build() {
            return new Car(this.id, this.name, this.engineValue);
        }
    }
}
