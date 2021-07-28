package org.bookmc.tests;

import org.bookmc.srg.SrgProcessor;
import org.bookmc.srg.output.MappedClass;
import org.bookmc.srg.output.MappedField;
import org.bookmc.srg.output.MappedMethod;
import org.bookmc.srg.output.SrgOutput;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SrgTests {
    private SrgOutput output;

    @Test
    @Order(0)
    public void processFile () {
        output = new SrgProcessor(readFile(Objects.requireNonNull(getClass().getResourceAsStream("/fake-srg.srg")))).process();
    }

    @Test
    @Order(1)
    public void testMethod() {
        MappedMethod mappedMethod = output.getMethods().get(0);
        Assertions.assertEquals("mapped_method_name", mappedMethod.getMappedName());
        Assertions.assertEquals("mapped_owner", mappedMethod.getMappedOwner());

        Assertions.assertEquals("unmapped_owner", mappedMethod.getUnmappedOwner());
        Assertions.assertEquals("unmapped_method_name", mappedMethod.getUnmappedName());
    }

    @Test
    @Order(2)
    public void testField() {
        MappedField mappedField = output.getFields().get(0);

        Assertions.assertEquals("mapped_owner", mappedField.getMappedOwner());
        Assertions.assertEquals("mapped_field_name", mappedField.getMappedName());

        Assertions.assertEquals("unmapped_owner", mappedField.getUnmappedOwner());
        Assertions.assertEquals("unmapped_field_name", mappedField.getUnmappedName());
    }

    @Test
    @Order(3)
    public void testClass() {
        MappedClass mappedClass = output.getClasses().get(0);

        Assertions.assertEquals("unmapped_class", mappedClass.getUnmappedName());
        Assertions.assertEquals("mapped_class", mappedClass.getMappedName());
    }

    private String readFile(InputStream stream) {
        try  {
            try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
                byte[] buffer = new byte[1024];

                int read;

                while ((read = stream.read(buffer, 0, buffer.length)) != -1) {
                    bos.write(buffer, 0, read);
                }

                return bos.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Java 8 sucks :(
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
