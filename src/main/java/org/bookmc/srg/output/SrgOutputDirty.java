package org.bookmc.srg.output;

import java.util.HashMap;
import java.util.Map;

public class SrgOutputDirty {
    private final Map<String, MappedMethod> methods = new HashMap<>();
    private final Map<String, String> classes = new HashMap<>();
    private final Map<String, MappedField> fields = new HashMap<>();

    public void addMethod(MappedMethod method) {
        String owner = method.getObfuscatedOwner();
        String name = method.getObfuscatedName();
        String desc = method.getObfuscatedDescriptor();
        methods.put(owner + ":" + name + ":" + desc, method);
    }

    public void addClass(MappedClass mappedClass) {
        classes.put(mappedClass.getObfuscatedName(), mappedClass.getDeobfuscatedName());
    }

    public void addField(MappedField field) {
        String owner = field.getObfuscatedOwner();
        String name = field.getObfuscatedName();
        fields.put(owner + ":" + name, field);
    }

    public Map<String, MappedMethod> getMethods() {
        return methods;
    }

    public Map<String, String> getClasses() {
        return classes;
    }

    public Map<String, MappedField> getFields() {
        return fields;
    }
}