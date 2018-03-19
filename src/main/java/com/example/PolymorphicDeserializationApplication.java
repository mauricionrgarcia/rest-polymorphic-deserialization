package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Test to use polymorphic type treatment to add handling ability and enable
 * addition of enough type information in Json messages. Than so that
 * deserializer can instantiate correct subtype of a value, even if declaration
 * of the field/setter/creator method only has single type (supertype) defined.
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 14/03/2018 21:46:22
 */
@SpringBootApplication
public class PolymorphicDeserializationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolymorphicDeserializationApplication.class, args);
	}

}
