package org.bookmc.srg.output;

import java.util.List;

public class SrgOutput {
    private final List<MappedMethod> methods;
    private final List<MappedClass> classes;
    private final List<MappedField> fields;

    public SrgOutput(List<MappedMethod> methods, List<MappedClass> classes, List<MappedField> fields) {
        this.methods = methods;
        this.classes = classes;
        this.fields = fields;
    }

    public List<MappedMethod> getMethods() {
        return methods;
    }

    public List<MappedClass> getClasses() {
        return classes;
    }

    public List<MappedField> getFields() {
        return fields;
    }
}
