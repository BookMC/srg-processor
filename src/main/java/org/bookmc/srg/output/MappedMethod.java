package org.bookmc.srg.output;

public class MappedMethod {
    private final String unmappedOwner;
    private final String mappedOwner;

    private final String unmappedName;
    private final String mappedName;

    private final String unmappedDesc;
    private final String mappedDesc;

    public MappedMethod(String unmappedOwner, String mappedOwner, String unmappedName, String mappedName, String unmappedDesc, String mappedDesc) {
        this.unmappedOwner = unmappedOwner;
        this.mappedOwner = mappedOwner;
        this.unmappedName = unmappedName;
        this.mappedName = mappedName;
        this.unmappedDesc = unmappedDesc;
        this.mappedDesc = mappedDesc;
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

    public String getUnmappedDesc() {
        return unmappedDesc;
    }

    public String getMappedDesc() {
        return mappedDesc;
    }

    @Override
    public String toString() {
        return unmappedOwner + "/" + unmappedName + unmappedDesc + "=" + mappedOwner + "/" + mappedName + unmappedDesc;
    }
}
