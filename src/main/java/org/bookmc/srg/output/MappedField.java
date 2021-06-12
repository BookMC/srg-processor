package org.bookmc.srg.output;

public class MappedField {
    private final String unmappedOwner;
    private final String mappedOwner;

    private final String unmappedName;
    private final String mappedName;

    public MappedField(String unmappedOwner, String mappedOwner, String unmappedName, String mappedName) {
        this.unmappedOwner = unmappedOwner;
        this.mappedOwner = mappedOwner;
        this.unmappedName = unmappedName;
        this.mappedName = mappedName;
    }

    public String getUnmappedOwner() {
        return unmappedOwner;
    }

    public String getMappedOwner() {
        return mappedOwner;
    }

    public String getUnmappedName() {
        return unmappedName;
    }

    public String getMappedName() {
        return mappedName;
    }

    @Override
    public String toString() {
        return unmappedOwner + "/" + unmappedName + "=" + mappedOwner + "/" + mappedName;
    }
}
