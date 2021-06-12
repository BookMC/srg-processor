package org.bookmc.srg.output;

import java.util.ArrayList;
import java.util.List;

public class SrgOutputDirty {
    private final List<MappedMethod> methods = new ArrayList<>();
    private final List<MappedClass> classes = new ArrayList<>();
    private final List<MappedField> fields = new ArrayList<>();

    public List<MappedMethod> getMethods() {
        return methods;
    }

    public List<MappedClass> getClasses() {
        return classes;
    }

    public List<MappedField> getFields() {
        return fields;
    }

    public void addMethod(MappedMethod method) {
        methods.add(method);
    }

    public void addClass(MappedClass mappedClass) {
        classes.add(mappedClass);
    }

    public void addField(MappedField field) {
        fields.add(field);
    }
}