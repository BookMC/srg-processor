package org.bookmc.srg.output;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SrgOutput {
    private final Map<String, MappedMethod> methods;
    private final Map<String, MappedField> fields;
    private final Map<String, String> classes;

    public SrgOutput(Map<String, MappedMethod> methods, Map<String, MappedField> fields, Map<String, String> classes) {
        this.methods = methods;
        this.fields = fields;
        this.classes = classes;
    }

    public MappedMethod getMethod(String owner, String name, String descriptor) {
        return methods.get(owner + ":" + name + ":" + descriptor);
    }

    public MappedField getField(String owner, String name) {
        return fields.get(owner + ":" + name);
    }

    public String getClass(String name) {
        return classes.get(name);
    }
}
