package ClothesProject.NotSimpleMenu;

public interface IMenuItem {
    int getOrder();// порядковый номер

    String getTitle(); //что будет конкретно элемент меню

    void execute() throws Exception;//какое действие мы будем выполнять
}


