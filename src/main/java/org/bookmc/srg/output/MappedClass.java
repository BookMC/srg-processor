package org.bookmc.srg.output;

public class MappedClass {
    private final String unmappedName;
    private final String mappedName;

    public MappedClass(String unmappedName, String mappedName) {
        this.unmappedName = unmappedName;
        this.mappedName = mappedName;
    }

    public String getUnmappedName() {
        return unmappedName;
    }

    public String getMappedName() {
        return mappedName;
    }

    @Override
    public String toString() {
        return unmappedName + "=" + mappedName;
    }
}
