package org.example.model;

import java.lang.reflect.Field;

//Этот класс необходим только для отладки объектной модели, на релизе будет удален
//Содержит в себе методы для вывода в консоль (я точно посмотрю часть лекции про отладчик)
public abstract class Model {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName()).append("[");
        for (Field field : this.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true); //Ломает безопасность модели в блоке кода, но применяется только в рамках отладки
                sb.append(field.getName())
                        .append("=")
                        .append(field.get(this))
                        .append(", ");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
