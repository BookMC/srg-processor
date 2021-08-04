package org.bookmc.srg.output;

public class MappedField {
    private final String obfuscatedOwner;
    private final String deobfuscatedOwner;

    private final String obfuscatedName;
    private final String deobfuscatedName;

    public MappedField(String obfuscatedOwner, String deobfuscatedOwner, String obfuscatedName, String deobfuscatedName) {
        this.obfuscatedOwner = obfuscatedOwner;
        this.deobfuscatedOwner = deobfuscatedOwner;
        this.obfuscatedName = obfuscatedName;
        this.deobfuscatedName = deobfuscatedName;
    }

    public String getObfuscatedOwner() {
        return obfuscatedOwner;
    }

    public String getDeobfuscatedOwner() {
        return deobfuscatedOwner;
    }

    public String getObfuscatedName() {
        return obfuscatedName;
    }

    public String getDeobfuscatedName() {
        return deobfuscatedName;
    }

    @Override
    public String toString() {
        return obfuscatedOwner + "/" + obfuscatedName + "=" + deobfuscatedOwner + "/" + deobfuscatedName;
    }
}
