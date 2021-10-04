package secured;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // доступна во время выполнения, для проверки путем отражения.
@Target({ElementType.METHOD}) //  указать, какие элементы Java могут быть использованы для аннотации
public @interface Secured {

    int number();
    String type() default "strict";
}
