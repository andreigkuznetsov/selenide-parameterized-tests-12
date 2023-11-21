package data;

public enum MainMenu {
    TARIFFS_FOR_BUSINESS("Тарифы для бизнеса"),
    INTERNATIONAL_DELIVERY("Международная доставка"),
    DELIVERY_MANAGE("Управление доставкой"),
    PARTNERSHIP("Партнерство"),
    ACTIONS("Акции"),
    GET_A_CONTRACT("Заключить договор");

    public final String description;

    MainMenu(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
