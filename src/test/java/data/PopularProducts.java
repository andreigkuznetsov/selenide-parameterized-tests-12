package data;

public enum PopularProducts {
    FOR_BUSINESS("Бизнесу"),
    FOR_PERSONS("Самозанятым/Частным лицам"),
    TO_ANOTHER_COUNTRY("В другую страну");

    public final String description;

    PopularProducts(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
