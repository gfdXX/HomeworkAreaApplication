# Площадь пересечения квадратов на JavaFX

![Java](https://img.shields.io/badge/Java-17-007396?logo=openjdk&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-17-orange)
![Maven](https://img.shields.io/badge/Maven-build-C71A36?logo=apachemaven&logoColor=white)

Домашнее задание по курсу Java, МГТУ им. Н.Э. Баумана, ИУ1 (весна 2022).

В окне два квадрата 200×200 («Перемести»), их можно перетаскивать мышью. Кнопка **«Посчитать площадь»** выводит в консоль площадь их пересечения (0, если квадраты не перекрываются).

## Устройство

Вся логика — в [`HelloApplication.java`](src/main/java/com/example/homeworkareaapplication/HelloApplication.java):
- обработчики `setOnMousePressed` / `setOnMouseDragged` / `setOnMouseReleased` двигают кнопки-квадраты и меняют курсор;
- `areaCalculate()` по координатам левых верхних углов считает площадь прямоугольника пересечения для всех вариантов взаимного расположения.

`HelloController.java` и `hello-view.fxml` остались от шаблона проекта IntelliJ IDEA и не используются.

## Как запустить

Нужны JDK 17+ и Maven:

```bash
mvn clean javafx:run
```

## Автор

Салженикин Даниил, МГТУ им. Н.Э. Баумана.
