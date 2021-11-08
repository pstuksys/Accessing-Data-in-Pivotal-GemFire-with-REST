package com.paulius.demo.test;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.annotation.Region;

import java.util.concurrent.atomic.AtomicLong;
// Apache Geode domain objects need an id,
// so an AtomicLong is being used to increment with each Person object creation.
@Data
@Region("People")
public class Person {

    private static AtomicLong Counter = new AtomicLong(0l);

    @Id
    private Long id;
    private String firstName;
    private String lastName;

    @PersistenceConstructor
    public Person() {
        this.id = Counter.incrementAndGet();
    }
}
